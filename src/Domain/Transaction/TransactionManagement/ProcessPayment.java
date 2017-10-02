package Domain.Transaction.TransactionManagement;

import Domain.Order.Order;

public interface ProcessPayment {
    void processPayment(Order order, boolean direction);

    PaymentNotification getPaymentNotification();
    void setPaymentNotification(PaymentNotification paymentNotification);
}
