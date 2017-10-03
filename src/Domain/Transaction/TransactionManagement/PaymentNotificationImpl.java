package Domain.Transaction.TransactionManagement;

import Domain.Order.Order;

public class PaymentNotificationImpl implements PaymentNotification {
    @Override
    public void notifyPartnerOfPayment(Order order) {

        System.out.println("Partner has been notified of payment. ");

    }
}
