package Domain.Transaction.TransactionManagement;

import Domain.Order.Order;

public class PaymentValidationImpl implements PaymentValidation {
    @Override
    public boolean validatePayment(Order order) {
        System.out.println("Payment successfully validated!");
        return true;
    }
}
