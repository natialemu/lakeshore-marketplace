package Domain.Delivery;

public interface DeliveryStatus {
    int getTracking_number();
    void setTracking_number(int tracking_number);
    String getDeliveryCarrier();
    void setDeliveryCarrier(String deliveryCarrier);
    String getDeliveryMethod();
    void setDeliveryMethod(String deliveryMethod);


}
