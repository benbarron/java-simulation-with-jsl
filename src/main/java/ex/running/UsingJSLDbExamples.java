/*
 * Copyright (c) 2019. Manuel D. Rossetti, rossetti@uark.edu
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package ex.running;

import ex.queueing.DriverLicenseBureauWithQ;
import jsl.modeling.Simulation;
import jsl.modeling.SimulationReporter;
import jsl.utilities.dbutil.DatabaseFactory;
import jsl.utilities.dbutil.DatabaseIfc;
import jsl.utilities.random.rvariable.ExponentialRV;
import jsl.utilities.reporting.JSLDatabase;
import jsl.utilities.reporting.JSLDatabaseObserver;
import jsl.utilities.statistic.MultipleComparisonAnalyzer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class UsingJSLDbExamples {

    public static void main(String[] args) {

        // shows how to use the default database
        //testDefaultDatabase();

        // shows how to use a database instead of the default
        //testJSLDatabaseObserver();

        // shows that 2 databases can be observing at the same time
        //testTwoDatabases();

        // shows that previous simulation results can be accessed w/o rerunning.
        //showDbReuse();

        // show multiple simulation runs captured to a database
        //testMCBRuns();

        // shows 2 databases (default and a postgres database)
        //testPostgressDb();

        showMultipleRunsOfSameSimulation();

    }

    /**
     *  Creates and runs a simulation with a default database
     *  Database will be deleted and re-filled based on run.
     *  Illustrates how to write database to Excel
     */
    public static void testDefaultDatabase() {
        // make the simulation with a default database
        Simulation sim = new Simulation("DLB_with_Q", true);
        // set the parameters of the experiment
        sim.setNumberOfReplications(30);
        sim.setLengthOfReplication(20000.0);
        sim.setLengthOfWarmUp(5000.0);

        // create the model element and attach it to the main model
        new DriverLicenseBureauWithQ(sim.getModel());

        // tell the simulation to run
        System.out.println("Simulation started.");
        sim.run();
        System.out.println("Simulation completed.");
        SimulationReporter r = sim.makeSimulationReporter();
        r.printAcrossReplicationSummaryStatistics();

        // get the default JSL database
        Optional<JSLDatabase> db = sim.getDefaultJSLDatabase();
        if (db.isPresent()) {
            System.out.println("Printing across replication records");
            db.get().getAcrossRepStatRecords().format(System.out);
            System.out.println();
            // write data from database to Excel workbook
            try {
                db.get().writeDbToExcelWorkbook();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Creates a non-default embedded derby database and captures data from simulation
     */
    public static void testJSLDatabaseObserver() {
        Simulation sim = new Simulation("DLB_with_Q");
        // set the parameters of the experiment
        sim.setNumberOfReplications(30);
        sim.setLengthOfReplication(20000.0);
        sim.setLengthOfWarmUp(5000.0);

        // make and use a embedded derby database, supply your own name
        // attach it as an observer onto the simulation
        JSLDatabaseObserver jslDatabaseObserver = sim.createJSLDatabaseObserver("AnotherOne");

        new DriverLicenseBureauWithQ(sim.getModel());

        // tell the simulation to run
        System.out.println("Simulation started.");
        sim.run();
        System.out.println("Simulation completed.");
        SimulationReporter r = sim.makeSimulationReporter();
        r.printAcrossReplicationSummaryStatistics();

        // get the JSLDatabase from the observer
        JSLDatabase db = jslDatabaseObserver.getJSLDatabase();
        System.out.println("Printing across replication records");
        db.getAcrossRepStatRecords().format(System.out);
        System.out.println();
    }

    /**
     *  Illustrates that two or more databases can be attached to the same simulation
     */
    public static void testTwoDatabases() {
        PrintWriter out = new PrintWriter(System.out);

        Simulation sim = new Simulation("TwoDbExample", true);

        // make and use an additional embedded derby database
        // this makes a new database, if one already exists with this name it is deleted and re-created
        JSLDatabaseObserver jslDatabaseObserver = sim.createJSLDatabaseObserver("SecondDb");

        // create the model element and attach it to the main model
        new DriverLicenseBureauWithQ(sim.getModel());

        // set the parameters of the experiment
        sim.setNumberOfReplications(30);
        sim.setLengthOfReplication(20000.0);
        sim.setLengthOfWarmUp(5000.0);

        SimulationReporter r = sim.makeSimulationReporter();
        // tell the simulation to run
        System.out.println("Simulation started.");
        sim.run();
        System.out.println("Simulation completed.");
        r.printAcrossReplicationSummaryStatistics();

        // get the default JSL database
        Optional<JSLDatabase> dbOptional = sim.getDefaultJSLDatabase();
        if (dbOptional.isPresent()) {
            System.out.println("Printing across replication records from default db");
            dbOptional.get().getAcrossRepStatRecords().format(System.out);
            System.out.println();
        }

        // get the other JSLDatabase from the observer
        JSLDatabase db2 = jslDatabaseObserver.getJSLDatabase();
        System.out.println("Printing across replication records from 2nd db");
        db2.getAcrossRepStatRecords().format(System.out);
        System.out.println();

    }

    /**
     * Illustrates how to use a Postgres database.  When running this method, you must
     * have a local Postgres server running and the database server needs to have the appropriate
     * user and password account set up.
     */
    public static void testPostgressDb(){
        PrintWriter out = new PrintWriter(System.out);

        Simulation sim = new Simulation("DLB_with_Q_PostGres_Test", true);
        // set the parameters of the experiment
        sim.setNumberOfReplications(30);
        sim.setLengthOfReplication(20000.0);
        sim.setLengthOfWarmUp(5000.0);
        // create the model element and attach it to the main model
        new DriverLicenseBureauWithQ(sim.getModel());

        // make and use an additional postgres database, if it already exists then just connects,
        // does not clear previous data
        JSLDatabase db = JSLDatabase.getPostgresLocalHostJSLDatabase("test", "test", "test");

        // attach the database to the simulation for observation, tell it to clear out experiment data
        // for this simulation prior to executing the simulation
        // This still leaves any previous simulation results in the database that do not have this
        // same simulation name and experiment name
        JSLDatabaseObserver databaseObserver = sim.createJSLDatabaseObserver(db, true);

        // tell the simulation to run
        System.out.println("Simulation started.");
        sim.run();
        System.out.println("Simulation completed.");

        sim.printHalfWidthSummaryReport();

        db.getAcrossRepStatRecords().format(out);

    }

    /**
     *  Illustrate how to get data from a previously executed simulation that
     *  had data in database. This method assumes that a database called, JSLDb_DriveThroughPharmacy
     *  exists within the jslOutput/db directory.
     */
    public static void showDbReuse() {
        // assumes that a database called JSLDb_DriveThroughPharmacy is in the jslOutput/db directory
        // create a reference to the previously created database
        DatabaseIfc database = DatabaseFactory.getEmbeddedDerbyDatabase("JSLDb_DriveThroughPharmacy");
        // use the database as the backing database for the new JSLDatabase instance
        JSLDatabase jslDatabase = new JSLDatabase(database);
        // just write out some results
        jslDatabase.getAcrossRepStatRecords().format(System.out);
    }

    public static void showMultipleRunsOfSameSimulation(){
        // make the simulation with a default database
        Simulation sim = new Simulation("MultiRun", true);
        // set the parameters of the experiment
        sim.setNumberOfReplications(30);
        sim.setLengthOfReplication(20000.0);
        sim.setLengthOfWarmUp(5000.0);

        // create the model element and attach it to the main model
        DriverLicenseBureauWithQ driverLicenseBureauWithQ = new DriverLicenseBureauWithQ(sim.getModel());
        sim.setExperimentName("1stRun");
        // tell the simulation to run
        System.out.println("Simulation started.");
        sim.run();
        System.out.println("Simulation completed.");

        //sim.setExperimentName("2ndRun");
        driverLicenseBureauWithQ.setServiceDistributionInitialRandomSource(new ExponentialRV(0.7));

        // tell the simulation to run
        System.out.println("Simulation started.");
        sim.run();
        System.out.println("Simulation completed.");

        // get the default JSL database
        Optional<JSLDatabase> db = sim.getDefaultJSLDatabase();

        if (db.isPresent()) {
            System.out.println("Printing across replication records");
            db.get().getAcrossRepStatRecords().format(System.out);
            System.out.println();
        }
    }

    /**
     *  Illustrates creating a single database to hold data from 3 consectutively
     *  created and executed simulations.
     *  Illustrates how to get MCB data from the database and show MCB results
     */
    private static void testMCBRuns(){

        // create a database with the name you want, if it already exists it is recreated
        JSLDatabase mcb_db = JSLDatabase.createEmbeddedDerbyJSLDatabase("MCB_Db");
        // run each of the experiments, changing the name of the experiment and
        // using the existing database
        System.out.println("Running the 1st simulation");
        run1stSimulation(mcb_db);
        System.out.println("Running the 2nd simulation");
        run2ndSimulation(mcb_db);
        System.out.println("Running the 3rd simulation");
        run3rdSimulation(mcb_db);

        // access the database to do the mcb analysis on a particular response for each of the experiments

        Set<String> experimentNames = new HashSet<>(Arrays.asList("FirstName", "2ndName", "3rdName"));

        MultipleComparisonAnalyzer analyzer = mcb_db.getMultipleComparisonAnalyzerFor(experimentNames, "System Time");
        System.out.println();
        System.out.println("MCB data from analyzer");
        System.out.println(analyzer);

        System.out.println();
        System.out.println("Print pairwise difference data from database");
        // illustrate that MCB data is in database
        mcb_db.getPairWiseAcrossRepRecords().format(System.out);
        System.out.println();
    }

    private static void run1stSimulation(JSLDatabase db) {
        Simulation sim = new Simulation("The Simulation");
        // set the parameters of the experiment
        sim.setNumberOfReplications(30);
        sim.setLengthOfReplication(20000.0);
        sim.setLengthOfWarmUp(5000.0);
        sim.setExperimentName("FirstName");

        DriverLicenseBureauWithQ dlb = new DriverLicenseBureauWithQ(sim.getModel());
        // here is where you set up the model with the correct configuration
        // by setting appropriate input parameters

        // create a JSLDatabaseObserver with the database for the simulation
        // causes data to go into the db
        sim.createJSLDatabaseObserver(db);

        // now run the model
        sim.run();
    }

    public static void run2ndSimulation(JSLDatabase db){
        Simulation sim = new Simulation();
        // set the parameters of the experiment
        sim.setNumberOfReplications(30);
        sim.setLengthOfReplication(20000.0);
        sim.setLengthOfWarmUp(5000.0);
        // important to change the name of the experiment
        sim.setExperimentName("2ndName");

        DriverLicenseBureauWithQ dlb = new DriverLicenseBureauWithQ(sim.getModel());
        // here is where you set up the model with the correct configuration
        // by setting appropriate input parameters, here I am just increasing the mean service time

        dlb.setServiceDistributionInitialRandomSource(new ExponentialRV(.7));

        // create a JSLDatabaseObserver with the database for the simulation
        // causes data to go into mcb_db
        sim.createJSLDatabaseObserver(db);

        sim.run();
    }

    public static void run3rdSimulation(JSLDatabase db){
        // creates a Simulation w/o a default database
        Simulation sim = new Simulation();
        // set the parameters of the experiment
        sim.setNumberOfReplications(30);
        sim.setLengthOfReplication(20000.0);
        sim.setLengthOfWarmUp(5000.0);
        // important to change the name of the experiment
        sim.setExperimentName("3rdName");
        DriverLicenseBureauWithQ dlb = new DriverLicenseBureauWithQ(sim.getModel());
        // here is where you set up the model with the correct configuration
        // by setting appropriate input parameters, here I am just increasing the mean service time
        dlb.setServiceDistributionInitialRandomSource(new ExponentialRV(.8));

        // use the existing database for the new simulation instance
        // create a JSLDatabaseObserver with the database for the simulation
        // causes data to go into mcb_db
        sim.createJSLDatabaseObserver(db);

        sim.run();
    }

}
