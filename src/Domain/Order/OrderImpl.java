package Domain.Order;

import Domain.Order.OrderState.*;

public class OrderImpl implements Order{
    private OrderState CANCELLED_ORDER = new CancelledOrder(this);
    private OrderState DELIVERED_ORDER = new DeliveredOrder(this);
    private OrderState PROCCESSED_ORDER = new ProcessedOrder(this);
    private OrderState UNPROCCESSED_ORDER = new UnprocessedOrder(this);

    private OrderState currentState;
    private OrderDetail orderDetail;

    private boolean orderContentVerified;
    private boolean paymentValidated;
    private String stringCurrentState;


    public OrderImpl(){
        setState(UNPROCCESSED_ORDER);

    }

    @Override
    public boolean verifyPayment() {
        return false;
    }

    @Override
    public boolean verifyOrderContent() {
        return false;
    }

    @Override
    public boolean processPayment() {
        return false;
    }

    @Override
    public boolean shipOrder() {
        return false;
    }

    @Override
    public boolean cancelOrder() {
        return false;
    }

    @Override
    public boolean sendConfirmation() {
        return false;
    }

    @Override
    public void setState(OrderState orderState) {
        currentState = orderState;
        stringCurrentState = orderState.getClass().getSimpleName();

    }

    @Override
    public String getStringOrderState() {
        return null;
    }

    @Override
    public OrderState getCurrentState() {
        return null;
    }

    @Override
    public OrderState getCancelledState() {
        return null;
    }

    @Override
    public OrderState getDeliveredState() {
        return null;
    }

    @Override
    public OrderState getProccessedState() {
        return null;
    }

    @Override
    public OrderState getUnproccessedState() {
        return null;
    }

    @Override
    public OrderDetail getOrderDetail() {
        return null;
    }

    @Override
    public void setOrderDetail(OrderDetail orderDetail) {

    }

    @Override
    public boolean orderContentVerified() {
        return false;
    }

    @Override
    public boolean paymentValidated() {
        return false;
    }

    @Override
    public void setOrderContentVerified(boolean orderContentVerified) {

    }

    @Override
    public void setPaymentValidation(boolean paymentValidation) {

    }
}
