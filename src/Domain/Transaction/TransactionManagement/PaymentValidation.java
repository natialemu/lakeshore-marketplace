package Domain.Transaction.TransactionManagement;

import Domain.Order.Order;

public interface PaymentValidation {

    boolean validatePayment(Order order);


}
