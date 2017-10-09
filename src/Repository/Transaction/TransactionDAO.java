package Repository.Transaction;

import Domain.Order.Order;
import Domain.Transaction.Transaction;

import java.util.Date;

public interface TransactionDAO {
    void createTransaction(Transaction transaction);
    Transaction getTransaction(int transactionId);
}
