package edu.uark.bjbarron.shirtmaker.entities;

import jsl.modeling.queue.QObject;
import jsl.utilities.random.rvariable.DUniformRV;
import lombok.Data;
import lombok.EqualsAndHashCode;
import edu.uark.bjbarron.shirtmaker.ShirtCreationProcessSimulation;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class Order extends QObject {
    private ShirtCreationProcessSimulation parent;
    private Double numberOfShirts;
    private Integer orderId;
    private boolean completed;
    private List<Shirt> finishedShirts;

    public Order(ShirtCreationProcessSimulation parent, Integer orderId) {
        super(parent.getTime(), null);
        this.parent = parent;
        this.orderId = orderId;
        this.numberOfShirts = new DUniformRV(1, 10).getValue();
        this.finishedShirts = new ArrayList<>();
        this.completed = false;
    }

    public void completeShirt(Shirt shirt) {
        this.finishedShirts.add(shirt);
        this.completed = this.finishedShirts.size() >= this.numberOfShirts;
    }

    public void dispose() {

    }
}
