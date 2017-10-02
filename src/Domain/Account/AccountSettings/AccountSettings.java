package Domain.Account.AccountSettings;

import Domain.Account.AccountProfile.Contact.Location;

public interface AccountSettings {

    void setDefaultLocation(Location location);
    void setDefaultPaymentCard(String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber);

    void setDefaultBankAccount(String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode);
}
