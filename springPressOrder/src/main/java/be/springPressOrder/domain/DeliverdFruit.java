package be.springPressOrder.domain;

import java.util.Date;

public class DeliverdFruit {
    private Date deliverydate;
    private int amount;
    private Sort sort;
    private PressOrder pressorder;

    public Date getDeliverydate() {
        return deliverydate;
    }

    public int getAmount() {
        return amount;
    }

    public Sort getSort() {
        return sort;
    }

    public PressOrder getPressorder() {
        return pressorder;
    }

    public DeliverdFruit(int amount, Sort sort, PressOrder pressorder) {

        this.deliverydate = new Date();
        this.amount = amount;
        this.sort = sort;
        this.pressorder = pressorder;
    }
}
