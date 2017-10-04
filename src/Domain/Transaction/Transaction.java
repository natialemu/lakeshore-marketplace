package Domain.Transaction;

import Domain.Order.Order;

import java.util.Date;

public interface Transaction {
    int getTransactionID();
    void setTransactionID(int transactionId);

    Date getTransactionDate();
    void setTransactionDate(Date transactionDate);
    double getTransactionAmount();
    void setTransactionAmount(double transactionAmount);
    void setOrder(Order order);
    Order getOrder();


}
