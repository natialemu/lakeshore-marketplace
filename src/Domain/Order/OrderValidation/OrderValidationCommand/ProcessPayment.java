package Domain.Order.OrderValidation.OrderValidationCommand;

import Domain.Order.Order;
import Domain.Order.OrderState.ProcessedOrder;

public class ProcessPayment implements ValidationCommand{
    private Order order;

    public ProcessPayment(Order order){
        this.order = order;
    }

    @Override
    public boolean executeCommand() {
        return order.processPayment();
    }
}
