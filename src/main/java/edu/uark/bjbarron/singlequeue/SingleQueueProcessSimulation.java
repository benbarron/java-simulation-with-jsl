package edu.uark.bjbarron.singlequeue;

import jsl.modeling.*;
import jsl.modeling.elements.EventGenerator;
import jsl.modeling.elements.station.SResource;
import jsl.modeling.elements.station.SingleQueueStation;
import jsl.modeling.elements.variable.RandomVariable;
import jsl.modeling.elements.variable.ResponseVariable;
import jsl.modeling.elements.variable.TimeWeighted;
import jsl.utilities.random.rvariable.PoissonRV;
import jsl.utilities.random.rvariable.TriangularRV;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.PrintWriter;

@Data
@EqualsAndHashCode(callSuper = true)
public class SingleQueueProcessSimulation extends ModelElement {
    // sim components
    private final SingleQueueStation singleQueueStation;
    // sim statistics
    private final TimeWeighted numberOfCustomersInSystem;
    private final ResponseVariable customerTimeInSystem;

    public SingleQueueProcessSimulation(ModelElement parent, String name) {
        super(parent, name);
        // random variables
        RandomVariable arrivalsRateRV = new RandomVariable(this, new PoissonRV(6));
        RandomVariable processingTimeRV = new RandomVariable(this, new TriangularRV(5, 10, 15));
        SResource stationWorkers = new SResource(this, 2, "StationWorker");
        this.singleQueueStation = new SingleQueueStation(this, stationWorkers, processingTimeRV, "SingleQueueStation");
        this.singleQueueStation.setNextReceiver(new CustomerDisposal(this));

        // sim statistics
        this.customerTimeInSystem = new ResponseVariable(this, "SystemTime");
        this.numberOfCustomersInSystem = new TimeWeighted(this, "NumberInSystem");


        // generate customers
        CustomerArrivalsGenerator generator = new CustomerArrivalsGenerator(this);
        new EventGenerator(this, generator, arrivalsRateRV, arrivalsRateRV);
    }

    public static void main(String[] args) {
        final Logger logger = LoggerFactory.getLogger("SingleQueueProcessSimulation");
        Simulation simulation = new Simulation("SingleQueueProblem", true);
        Model model = simulation.getModel();
        SingleQueueProcessSimulation sys = new SingleQueueProcessSimulation(model, "SingleQueueProcessSimulation");
        SimulationReporter simulationReporter = simulation.makeSimulationReporter();
        simulation.setLengthOfReplication(20000.0);
        simulation.setNumberOfReplications(30);
        simulation.setLengthOfWarmUp(5000.0);
        logger.info("Simulation is starting...");
        simulation.run();
        logger.info("Simulation is finished...");
        simulationReporter.printAcrossReplicationSummaryStatistics();
        simulationReporter.writeAcrossReplicationSummaryStatistics(new PrintWriter(System.out));
    }
}
