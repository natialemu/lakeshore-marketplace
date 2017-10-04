package Domain.Order.OrderState;

public interface OrderState {
    boolean verifyPayment();
    boolean verifyOrderContent();
    boolean processPayment();
    boolean shipOrder();
    boolean cancelOrder();
    boolean sendConfirmation();

}
