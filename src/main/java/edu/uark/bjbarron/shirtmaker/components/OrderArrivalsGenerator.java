package edu.uark.bjbarron.shirtmaker.components;

import jsl.modeling.JSLEvent;
import jsl.modeling.elements.EventGenerator;
import jsl.modeling.elements.EventGeneratorActionIfc;
import jsl.modeling.elements.variable.RandomVariable;
import edu.uark.bjbarron.shirtmaker.ShirtCreationProcessSimulation;
import edu.uark.bjbarron.shirtmaker.entities.Order;

public class OrderArrivalsGenerator implements EventGeneratorActionIfc {
    private final ShirtCreationProcessSimulation parent;
    private Integer orderIdCounter;

    public static void start(ShirtCreationProcessSimulation parent, RandomVariable orderArrivalsRateRV) {
        OrderArrivalsGenerator generator = new OrderArrivalsGenerator(parent);
        new EventGenerator(parent, generator, orderArrivalsRateRV, orderArrivalsRateRV);
    }

    public OrderArrivalsGenerator(ShirtCreationProcessSimulation parent) {
        this.parent = parent;
        this.orderIdCounter = 0;
    }

    @Override
    public void generate(EventGenerator generator, JSLEvent event) {
        Order order = new Order(this.parent, orderIdCounter);
        this.parent.getNumberOfCustomersInSystem().increment();
        this.parent.getProcessOrderStation().receive(order);
        this.orderIdCounter += 1;
    }
}
