package Domain.Order;

import Domain.Customer.Customer;
import Domain.Order.OrderState.*;
import Domain.Product.Product;

import java.util.List;

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


    public OrderImpl(List<Product> products, Customer customer){
        orderDetail = new OrderDetailImpl(products,customer);
        setState(UNPROCCESSED_ORDER);
    }

    @Override
    public boolean verifyPayment() {
        return currentState.verifyPayment();
    }

    @Override
    public boolean verifyOrderContent() {
        return currentState.verifyOrderContent();
    }

    @Override
    public boolean processPayment() {
        return currentState.processPayment();
    }

    @Override
    public boolean shipOrder() {
        return currentState.shipOrder();
    }

    @Override
    public boolean cancelOrder() {
        return currentState.cancelOrder();
    }

    @Override
    public boolean sendConfirmation() {
        return currentState.sendConfirmation();
    }

    @Override
    public void setState(OrderState orderState) {
        currentState = orderState;
        stringCurrentState = orderState.getClass().getSimpleName();

    }

    @Override
    public String getStringOrderState() {
        return stringCurrentState;
    }

    @Override
    public OrderState getCurrentState() {
        return currentState;
    }

    @Override
    public OrderState getCancelledState() {
        return CANCELLED_ORDER;
    }

    @Override
    public OrderState getDeliveredState() {
        return DELIVERED_ORDER;
    }

    @Override
    public OrderState getProccessedState() {
        return PROCCESSED_ORDER;
    }

    @Override
    public OrderState getUnproccessedState() {
        return UNPROCCESSED_ORDER;
    }

    @Override
    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    @Override
    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;

    }

    @Override
    public boolean orderContentVerified() {
        return orderContentVerified;
    }

    @Override
    public boolean paymentValidated() {
        return paymentValidated;
    }

    @Override
    public void setOrderContentVerified(boolean orderContentVerified) {
        this.orderContentVerified = orderContentVerified;

    }

    @Override
    public void setPaymentValidation(boolean paymentValidation) {
        this.paymentValidated =  paymentValidation;
    }
}
