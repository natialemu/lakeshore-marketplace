package Domain.Order.OrderState;

import Domain.Order.Order;

public class DeliveredOrder implements OrderState {
    private Order order;

    public DeliveredOrder(Order order){
        this.order = order;
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
        order.setState(order.getCancelledState());
        return true;
    }

    @Override
    public boolean sendConfirmation() {
        return true;
    }
}
