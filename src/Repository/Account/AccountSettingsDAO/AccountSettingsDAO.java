package Repository.Account.AccountSettingsDAO;

import Domain.Account.AccountProfile.Contact.Location;
import Domain.Account.AccountSettings.AccountSettings;

public interface AccountSettingsDAO {
    void setDefaultLocation(Location location);

    void setDefaultBankAccount(String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode);

    void setDefaultPaymentCard(String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber);

    AccountSettings getAccountSettings(String acct_settings_id);

    void createBasicSettings(int account_settings_id);

}
