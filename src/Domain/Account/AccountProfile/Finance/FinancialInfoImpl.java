package Domain.Account.AccountProfile.Finance;

import Domain.Account.AccountProfile.Contact.Location;

public class FinancialInfoImpl implements FinancialInfo{
    private Location billingAddress;
    private BankAccount bankAccount;
    private PaymentCard paymentCard;

    public Location getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Location billingAddress) {
        this.billingAddress = billingAddress;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public PaymentCard getPaymentCard() {
        return paymentCard;
    }

    public void setPaymentCard(PaymentCard paymentCard) {
        this.paymentCard = paymentCard;
    }

    @Override
    public void setPaymentCard(String cardHolderName, String cardNumber, String cardExpirationDate, int cardSecurityNumber) {
        this.paymentCard = new CreditCard();
        paymentCard.setCardHolderName(cardHolderName);
        paymentCard.setCardNumber(cardNumber);
        paymentCard.setCardExpirationDate(cardExpirationDate);
        paymentCard.setCardSecurityNumber(cardSecurityNumber);
    }

    @Override
    public void setBankAccount(String bankName, String routingNumber, String accountNumber, String swiftCode, String accountType) {

        bankAccount = new BankAccountImpl();
        bankAccount.setBankName(bankName);
        bankAccount.setRoutingNumber(routingNumber);
        bankAccount.setAccountNumber(accountNumber);
        bankAccount.setSwiftCode(swiftCode);
        bankAccount.setAccountType(accountType);
    }

    @Override
    public String toString() {
        return "FinancialInfoImpl{" +
                "billingAddress=" + billingAddress +
                ", bankAccount=" + bankAccount +
                ", paymentCard=" + paymentCard +
                '}';
    }
}
