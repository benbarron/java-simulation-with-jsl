package edu.uark.bjbarron.shirtmaker.entities;

import jsl.modeling.queue.QObject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import edu.uark.bjbarron.shirtmaker.ShirtCreationProcessSimulation;

@Data
@EqualsAndHashCode(callSuper = true)
public class Shirt extends QObject {
    private ShirtCreationProcessSimulation parent;
    private Integer orderId;

    public Shirt(ShirtCreationProcessSimulation parent, Integer orderId) {
        super(parent.getTime(), null);
        this.parent = parent;
        this.orderId = orderId;
    }

}
