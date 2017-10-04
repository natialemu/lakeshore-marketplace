package Domain.Order;

import Domain.Order.OrderState.CancelledOrder;
import Domain.Order.OrderState.OrderState;
import com.sun.deploy.util.OrderedHashSet;

public interface Order {


    boolean verifyPayment();
    boolean verifyOrderContent();
    boolean processPayment();
    boolean shipOrder();
    boolean cancelOrder();
    boolean sendConfirmation();


    void setState(OrderState orderState);
    String getStringOrderState();
    OrderState getCurrentState();

    OrderState getCancelledState();
    OrderState getDeliveredState();
    OrderState getProccessedState();
    OrderState getUnproccessedState();

    OrderDetail getOrderDetail();
    void setOrderDetail(OrderDetail orderDetail);

    boolean orderContentVerified();
    boolean paymentValidated();

    void setOrderContentVerified(boolean orderContentVerified);
    void setPaymentValidation(boolean paymentValidation);


    int getConfirmationID();

    OrderConfirmation getOrderConfirmation();
    void setOrderConfirmation(OrderConfirmation orderConfirmation);

    int getOrderID();
    void setOrderID(int orderID);
}
