package Domain.Transaction;

import Domain.Order.Order;
import Domain.Transaction.TransactionManagement.PaymentNotification;
import Domain.Transaction.TransactionManagement.PaymentValidation;
import Domain.Transaction.TransactionManagement.ProcessPayment;

public interface TransactionFactory {
    boolean validatePayment(Order order);

    void processPayment(Order order);
    Transaction getTransaction();
    void setTransaction(Transaction transaction);
    Order getOrder();
    void setOrder(Order order);

    ProcessPayment getProcessPayment();
    void setProcessPayment(ProcessPayment processPayment);
    PaymentValidation getPaymentValidation();
    void setPaymentValidation(PaymentValidation paymentValidation);
    TransactionHistory getTransactionHistory();
    void setTransactionHistory(TransactionHistory transactionHistory);
    void refundMoney(Order order);







}
