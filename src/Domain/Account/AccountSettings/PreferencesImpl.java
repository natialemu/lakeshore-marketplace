package Domain.Account.AccountSettings;

import Domain.Account.AccountProfile.Contact.Location;
import Domain.Account.AccountProfile.Finance.BankAccount;
import Domain.Account.AccountProfile.Finance.PaymentCard;

public class PreferencesImpl implements Preferences{
    private BankAccount defaultBankAccount;
    private Location defaultLocation;
    private PaymentCard defaultPaymentCard;

    @Override
    public String toString() {
        return "PreferencesImpl{" +
                "defaultBankAccount=" + defaultBankAccount +
                ", defaultLocation=" + defaultLocation +
                ", defaultPaymentCard=" + defaultPaymentCard +
                '}';
    }

    public BankAccount getDefaultBankAccount() {
        return defaultBankAccount;
    }

    public void setDefaultBankAccount(BankAccount defaultBankAccount) {
        this.defaultBankAccount = defaultBankAccount;
    }

    public Location getDefaultLocation() {
        return defaultLocation;
    }

    public void setDefaultLocation(Location defaultLocation) {
        this.defaultLocation = defaultLocation;
    }

    @Override
    public void setDefaultPaymentCard(String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber) {
        //TODO
    }

    @Override
    public void setDefaultBankAccount(String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode) {

        //TODO
    }

    public PaymentCard getDefaultPaymentCard() {
        return defaultPaymentCard;
    }

    public void setDefaultPaymentCard(PaymentCard defaultPaymentCard) {
        this.defaultPaymentCard = defaultPaymentCard;
    }
}
