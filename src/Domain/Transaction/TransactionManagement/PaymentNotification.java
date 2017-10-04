package Domain.Transaction.TransactionManagement;

import Domain.Order.Order;

public interface PaymentNotification {
    void notifyPartnerOfPayment(Order order);

}
