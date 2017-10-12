package Domain.Account.AccountProfile.Finance;

import Domain.Account.AccountProfile.Contact.Location;

public interface FinancialInfo {
    void setBillingAddress(Location billingAddress);
    void setBankAccount(BankAccount bankAccount);
    void setPaymentCard(PaymentCard paymentCard);
    void setPaymentCard(String cardHolderName, String cardNumber, String cardExpirationDate, int cardSecurityNumber);
    void setBankAccount(String bankName, String routingNumber, String accountNumber, String swiftCode, String accountType);

    Location getBillingAddress();
    BankAccount getBankAccount();
    PaymentCard getPaymentCard();

    void setFinancialInfoID(int financialInfoID);
    int getFinancialInfoID();
}
