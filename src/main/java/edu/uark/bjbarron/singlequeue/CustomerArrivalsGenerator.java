package edu.uark.bjbarron.singlequeue;

import jsl.modeling.JSLEvent;
import jsl.modeling.elements.EventGenerator;
import jsl.modeling.elements.EventGeneratorActionIfc;

public class CustomerArrivalsGenerator implements EventGeneratorActionIfc {
    private SingleQueueProcessSimulation parent;

    public CustomerArrivalsGenerator(SingleQueueProcessSimulation parent) {
        this.parent = parent;
    }

    @Override
    public void generate(EventGenerator generator, JSLEvent event) {
        Customer customer = new Customer(this.parent);
        this.parent.getSingleQueueStation().receive(customer);
        this.parent.getNumberOfCustomersInSystem().increment();
    }
}