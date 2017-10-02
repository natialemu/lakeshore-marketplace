package Domain.Order.OrderValidation.OrderValidationCommand;

import Domain.Order.Order;

public class ValidatePayment implements ValidationCommand{
    private Order order;

    public ValidatePayment(Order order){
        this.order = order;
    }


    @Override
    public boolean executeCommand() {
        return order.verifyPayment();
    }
}
