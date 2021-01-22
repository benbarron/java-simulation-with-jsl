package edu.uark.bjbarron.shirtmaker.components;

import jsl.modeling.elements.station.ReceiveQObjectIfc;
import jsl.modeling.queue.QObject;
import edu.uark.bjbarron.shirtmaker.ShirtCreationProcessSimulation;
import edu.uark.bjbarron.shirtmaker.entities.Order;

public class EntityDisposal implements ReceiveQObjectIfc {
    private ShirtCreationProcessSimulation parent;

    public EntityDisposal(ShirtCreationProcessSimulation parent) {
        this.parent = parent;
    }

    @Override
    public void receive(QObject qObj) {
        Order order = (Order) qObj;
        double timeInSystem = this.parent.getTime() - order.getCreateTime();
        this.parent.getNumberOfCustomersInSystem().decrement();
        this.parent.getCustomerTimeInSystem().setValue(timeInSystem);
        order.dispose();
    }
}
