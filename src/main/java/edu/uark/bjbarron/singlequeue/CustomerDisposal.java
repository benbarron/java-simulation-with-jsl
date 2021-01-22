package edu.uark.bjbarron.singlequeue;

import jsl.modeling.elements.station.ReceiveQObjectIfc;
import jsl.modeling.queue.QObject;

public class CustomerDisposal implements ReceiveQObjectIfc {

    private SingleQueueProcessSimulation parent;

    public CustomerDisposal(SingleQueueProcessSimulation parent) {
        this.parent = parent;
    }

    @Override
    public void receive(QObject qObj) {
        this.parent.getNumberOfCustomersInSystem().decrement();
        this.parent.getCustomerTimeInSystem().setValue(this.parent.getTime() - qObj.getCreateTime());
        ((Customer) qObj).dispose();
    }
}