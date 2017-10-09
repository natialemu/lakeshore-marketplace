package Domain.Transaction.TransactionManagement;

import Domain.Order.Order;
import Repository.Transaction.TransactionDAO;
import Repository.Transaction.TransactionDAOImpl;

import java.awt.font.TransformAttribute;

public class ProcessPaymentImpl implements ProcessPayment {
    private PaymentNotification paymentNotification;
    private TransactionDAO transactionDAO;

    public ProcessPaymentImpl(){
        paymentNotification = new PaymentNotificationImpl();
        transactionDAO = new TransactionDAOImpl();
    }
    @Override
    public void processPayment(Order order, boolean direction) {
        System.out.println("Payment proccessed! ");
        paymentNotification.notifyPartnerOfPayment(order);

    }

    @Override
    public PaymentNotification getPaymentNotification() {
        return paymentNotification;
    }

    @Override
    public void setPaymentNotification(PaymentNotification paymentNotification) {
        this.paymentNotification = paymentNotification;

    }
}
