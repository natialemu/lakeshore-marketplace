package Domain.Order.OrderState;

import Domain.Order.Order;
import Domain.Transaction.Transaction;

public class CancelledOrder implements OrderState{
    private Order order;

    public CancelledOrder(Order order){
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
        return false;
    }

    @Override
    public boolean sendConfirmation() {
        return true;
    }
}
