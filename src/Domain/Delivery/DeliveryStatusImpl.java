package Domain.Delivery;

public class DeliveryStatusImpl implements DeliveryStatus{
    public int getTracking_number() {
        return tracking_number;
    }

    public void setTracking_number(int tracking_number) {
        this.tracking_number = tracking_number;
    }

    public String getDeliveryCarrier() {
        return deliveryCarrier;
    }

    public void setDeliveryCarrier(String deliveryCarrier) {
        this.deliveryCarrier = deliveryCarrier;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    private int tracking_number;
    private String deliveryCarrier;
    private String deliveryMethod;

    public DeliveryStatusImpl(int tracking_number, String deliveryCarrier,String deliveryMethod){
        this.tracking_number = tracking_number;
        this.deliveryCarrier = deliveryCarrier;
        this.deliveryMethod = deliveryMethod;

    }

    public DeliveryStatusImpl(int tracking_number){
        this.tracking_number = tracking_number;
        this.deliveryMethod = "UNKNOWN";
        this.deliveryCarrier = "UNKNOWN";
    }
}
