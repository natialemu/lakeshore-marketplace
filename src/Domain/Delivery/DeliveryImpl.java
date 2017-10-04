package Domain.Delivery;

import Domain.Order.Order;
import Domain.Tools.IDGenerator;

import java.util.Date;

public class DeliveryImpl implements Delivery {
    private Order order;
    private Date deliveryCreationDate;
    private DeliveryStatus deliveryStatus;
    private int deliveryID;

    public DeliveryImpl(Order order){
        this.order = order;
        int deliveryID = IDGenerator.getId();
        deliveryCreationDate = new Date();
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setDeliveryStatus(int trackingNumber){
        deliveryStatus = new DeliveryStatusImpl(trackingNumber);
    }
    public void setDeliveryStatus(int trackingNumber, String deliveryMethod, String deliveryCarrier){
        deliveryStatus = new DeliveryStatusImpl(trackingNumber,deliveryCarrier,deliveryMethod);
    }

    public Date getDeliveryCreationDate() {
        return deliveryCreationDate;
    }

    public void setDeliveryCreationDate(Date deliveryCreationDate) {
        this.deliveryCreationDate = deliveryCreationDate;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public int getDeliveryID() {
        return deliveryID;
    }

    public void setDeliveryID(int deliveryID) {
        this.deliveryID = deliveryID;
    }
}
