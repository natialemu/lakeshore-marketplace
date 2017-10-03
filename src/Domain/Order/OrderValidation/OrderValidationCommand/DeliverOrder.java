package Domain.Order.OrderValidation.OrderValidationCommand;

import Domain.Order.Order;
import Domain.Order.OrderState.DeliveredOrder;

public class DeliverOrder implements ValidationCommand{
    private Order order;
    public DeliverOrder(Order order){
        this.order = order;
    }
    @Override
    public boolean executeCommand() {
        return order.shipOrder();
    }
}
