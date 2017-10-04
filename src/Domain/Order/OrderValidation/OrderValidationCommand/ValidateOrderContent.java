package Domain.Order.OrderValidation.OrderValidationCommand;

import Domain.Order.Order;

public class ValidateOrderContent implements ValidationCommand{
    private Order order;

    public ValidateOrderContent(Order order){
        this.order = order;
    }


    @Override
    public boolean executeCommand() {
        return order.verifyOrderContent();
    }
}
