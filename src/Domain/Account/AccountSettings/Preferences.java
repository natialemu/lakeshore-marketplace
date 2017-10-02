package Domain.Account.AccountSettings;

import Domain.Account.AccountProfile.Contact.Location;
import Domain.Account.AccountProfile.Finance.BankAccount;
import Domain.Account.AccountProfile.Finance.PaymentCard;

public interface Preferences {

    void setDefaultLocation(Location location);

    void setDefaultPaymentCard(String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber);

    void setDefaultBankAccount(String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode);

    Location getDefaultLocation();

    PaymentCard getDefaultPaymentCard();

    BankAccount getDefaultBankAccount();

}
