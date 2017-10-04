package Repository.Transaction;

import Domain.Order.Order;

public interface TransactionDAO {
    void createTransaction(Order order);
}
