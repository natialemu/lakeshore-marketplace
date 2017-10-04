package Domain.Transaction;

import Domain.Order.Order;
import Domain.Partner.Partner;
import Domain.Transaction.TransactionManagement.*;
import Repository.Transaction.TransactionDAO;
import Repository.Transaction.TransactionDAOImpl;

import java.util.Date;

public class TransactionFactoryImpl implements TransactionFactory{
    private  Transaction transaction;
    private PaymentNotification paymentNotification;
    private ProcessPayment processPayment;
    private PaymentValidation paymentValidation;
    private TransactionHistory transactionHistory;
    private TransactionDAO transactionDAO;





    public TransactionFactoryImpl(Order order){
        transaction = new TransactionImpl(order);
        paymentNotification = new PaymentNotificationImpl();
        transactionHistory = new TransactionHistoryImpl();

        processPayment = new ProcessPaymentImpl();
        paymentValidation = new PaymentValidationImpl();
        transactionDAO = new TransactionDAOImpl();

    }
    @Override
    public boolean validatePayment(Order order) {
        return paymentValidation.validatePayment(order);
    }

    @Override
    public void processPayment(Order order) {
        processPayment.processPayment(order,true);

        transactionDAO.createTransaction(transaction);

    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }


    public PaymentNotification getPaymentNotification() {
        return paymentNotification;
    }

    public void setPaymentNotification(PaymentNotification paymentNotification) {
        this.paymentNotification = paymentNotification;
    }

    public ProcessPayment getProcessPayment() {
        return processPayment;
    }

    public void setProcessPayment(ProcessPayment processPayment) {
        this.processPayment = processPayment;
    }

    public PaymentValidation getPaymentValidation() {
        return paymentValidation;
    }

    public void setPaymentValidation(PaymentValidation paymentValidation) {
        this.paymentValidation = paymentValidation;
    }

    public TransactionHistory getTransactionHistory() {
        return transactionHistory;
    }

    public void setTransactionHistory(TransactionHistory transactionHistory) {
        this.transactionHistory = transactionHistory;
    }

    public void refundMoney(Order order){
        processPayment.processPayment(order,false);
    }

}
