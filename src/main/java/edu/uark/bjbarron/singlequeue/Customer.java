package edu.uark.bjbarron.singlequeue;

import jsl.modeling.queue.QObject;

public class Customer extends QObject {
    private SingleQueueProcessSimulation parent;

    public Customer(SingleQueueProcessSimulation parent) {
        super(parent.getTime(), null);
        this.parent = parent;
    }

    public void dispose() {

    }
}