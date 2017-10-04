package Domain.Order.OrderValidation.OrderValidationCommand;

import Domain.Order.Order;

public class ConfirmOrder implements ValidationCommand {
    private Order order;

    public ConfirmOrder(Order order){
        this.order = order;

    }


    @Override
    public boolean executeCommand() {
        return order.sendConfirmation();
    }
}
