package Domain.Order.OrderState;

import Domain.Order.Order;

public class ProcessedOrder implements OrderState {

    private Order order;

    public ProcessedOrder(Order order){
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
        return true;
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
