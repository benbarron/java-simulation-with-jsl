package edu.uark.bjbarron.shirtmaker.components;

import jsl.modeling.elements.station.ReceiveQObjectIfc;
import jsl.modeling.queue.QObject;
import edu.uark.bjbarron.shirtmaker.ShirtCreationProcessSimulation;
import edu.uark.bjbarron.shirtmaker.entities.Order;
import edu.uark.bjbarron.shirtmaker.entities.Shirt;

import java.util.ArrayList;
import java.util.List;

public class BatchShirtAndPaperwork implements ReceiveQObjectIfc {
    private final ShirtCreationProcessSimulation parent;
    private final List<Shirt> shirts;
    private final List<Order> orders;

    public BatchShirtAndPaperwork(ShirtCreationProcessSimulation parent) {
        this.parent = parent;
        this.orders = new ArrayList<>();
        this.shirts = new ArrayList<>();
    }

    public void receivePaperwork(Order order) {
        for(Shirt shirt : this.shirts) {
            if(shirt.getOrderId().equals(order.getOrderId())) {
                order.completeShirt(shirt);
                if(order.isCompleted()) {
                    this.parent.getEntityDisposal().receive(order);
                    return;
                }
            }
        }
        this.orders.add(order);
    }

    public void receiveShirts(Shirt shirt) {
        for(Order order : this.orders) {
            if(order.getOrderId().equals(shirt.getOrderId())) {
                order.completeShirt(shirt);
                if(order.isCompleted()) {
                    this.parent.getEntityDisposal().receive(order);
                }
                return;
            }
        }
        this.shirts.add(shirt);
    }

    @Override
    public void receive(QObject qObj) {
        if(qObj instanceof Shirt) {
            this.receiveShirts((Shirt)qObj);
        } else {
            this.receivePaperwork((Order)qObj);
        }
    }
}
