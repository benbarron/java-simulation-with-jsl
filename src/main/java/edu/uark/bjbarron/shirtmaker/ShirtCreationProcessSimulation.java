package edu.uark.bjbarron.shirtmaker;

import lombok.Data;
import lombok.EqualsAndHashCode;
import jsl.modeling.ModelElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jsl.modeling.Simulation;
import jsl.modeling.SimulationReporter;
import jsl.modeling.elements.station.SResource;
import jsl.modeling.elements.station.SingleQueueStation;
import jsl.modeling.elements.variable.RandomVariable;
import jsl.modeling.elements.variable.ResponseVariable;
import jsl.modeling.elements.variable.TimeWeighted;
import jsl.utilities.random.rvariable.LognormalRV;
import jsl.utilities.random.rvariable.PoissonRV;
import edu.uark.bjbarron.shirtmaker.components.EntityDisposal;
import edu.uark.bjbarron.shirtmaker.components.SeparateOrder;
import edu.uark.bjbarron.shirtmaker.components.BatchShirtAndPaperwork;
import edu.uark.bjbarron.shirtmaker.components.OrderArrivalsGenerator;
import java.io.PrintWriter;

@Data
@EqualsAndHashCode(callSuper = true)
public class ShirtCreationProcessSimulation extends ModelElement {
    private final SingleQueueStation processOrderStation;
    private final SingleQueueStation makeShirtStation;
    private final SingleQueueStation processPaperworkStation;
    private final EntityDisposal entityDisposal;
    private final TimeWeighted numberOfCustomersInSystem;
    private final ResponseVariable customerTimeInSystem;

    public ShirtCreationProcessSimulation(ModelElement parent, String name) {
        super(parent, name);
        RandomVariable processOrderTime = new RandomVariable(this, new LognormalRV(8, 3));
        RandomVariable makeShirtTime = new RandomVariable(this, new LognormalRV(5, 2));
        RandomVariable processPaperworkTime = new RandomVariable(this, new LognormalRV(7, 2));
        RandomVariable orderArrivalsRateRV = new RandomVariable(this, new PoissonRV(4));
        BatchShirtAndPaperwork batchShirtAndPaperwork = new BatchShirtAndPaperwork(this);
        SResource orderEmployees = new SResource(this, 3, "OrderEmployees");
        SResource shirtMakers = new SResource(this, 6, "ShirtMakers");
        this.processOrderStation = new SingleQueueStation(this, orderEmployees, processOrderTime, "ProcessOrderStation");
        this.makeShirtStation = new SingleQueueStation(this, shirtMakers, makeShirtTime, "MakeShirtStation");
        this.processPaperworkStation = new SingleQueueStation(this, orderEmployees, processPaperworkTime, "ProcessPaperworkStation");
        this.entityDisposal = new EntityDisposal(this);
        this.customerTimeInSystem = new ResponseVariable(this, "SystemTime");
        this.numberOfCustomersInSystem = new TimeWeighted(this, "NumberInSystem");
        this.processOrderStation.setNextReceiver(new SeparateOrder(this));
        this.makeShirtStation.setNextReceiver(batchShirtAndPaperwork);
        this.processPaperworkStation.setNextReceiver(batchShirtAndPaperwork);
        OrderArrivalsGenerator.start(this, orderArrivalsRateRV);
    }

    public static void main(String[] args) {
        final Logger logger = LoggerFactory.getLogger("ShirtCreationProcessSimulation.main()");
        Simulation simulation = new Simulation("ShirtCreationProcessSimulation", true);
        new ShirtCreationProcessSimulation(simulation.getModel(), "ShirtCreationProcessSimulation");
        SimulationReporter simulationReporter = simulation.makeSimulationReporter();
        simulation.setRepLengthWarningMessageOption(false);
        simulation.setLengthOfReplication(60*24);
        simulation.setNumberOfReplications(30);
        simulation.setLengthOfWarmUp(60);
        logger.info("Simulation is starting...");
        simulation.run();
        logger.info("Simulation is finished...");
        simulationReporter.printAcrossReplicationSummaryStatistics();
        simulationReporter.writeAcrossReplicationSummaryStatistics(new PrintWriter(System.out));
    }
}
