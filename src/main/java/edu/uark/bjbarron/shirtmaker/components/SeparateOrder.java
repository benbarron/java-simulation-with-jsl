package edu.uark.bjbarron.shirtmaker.components;

import jsl.modeling.elements.station.ReceiveQObjectIfc;
import jsl.modeling.queue.QObject;
import edu.uark.bjbarron.shirtmaker.ShirtCreationProcessSimulation;
import edu.uark.bjbarron.shirtmaker.entities.Order;
import edu.uark.bjbarron.shirtmaker.entities.Shirt;

public class SeparateOrder implements ReceiveQObjectIfc {
    private final ShirtCreationProcessSimulation parent;

    public SeparateOrder(ShirtCreationProcessSimulation parent) {
        this.parent = parent;
    }

    @Override
    public void receive(QObject qObj) {
        Order order = (Order) qObj;
        for(int i = 0; i < order.getNumberOfShirts(); i++) {
            Shirt shirt = new Shirt(this.parent, order.getOrderId());
            this.parent.getMakeShirtStation().receive(shirt);
        }
        this.parent.getProcessPaperworkStation().receive(order);
    }
}
