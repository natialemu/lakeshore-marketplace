package Domain.Transaction;

import Domain.Order.Order;

public interface Transaction {
    boolean validatePayment(Order order);

    boolean processPayment(Order order);
}
