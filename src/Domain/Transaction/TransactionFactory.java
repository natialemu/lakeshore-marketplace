package Domain.Transaction;

import Domain.Order.Order;

public interface TransactionFactory {
    boolean validatePayment(Order order);

    void processPayment(Order order);
}
