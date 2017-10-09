package Repository.Account.AccountSettingsDAO;

import Domain.Account.AccountProfile.Contact.Location;
import Domain.Account.AccountSettings.AccountSettings;

public class AccountSettingsDAOImpl implements AccountSettingsDAO {
    @Override
    public void setDefaultLocation(Location location) {

    }

    @Override
    public void setDefaultBankAccount(String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode) {

    }

    @Override
    public void setDefaultPaymentCard(String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber) {

    }

    @Override
    public AccountSettings getAccountSettings(String acct_settings_id) {
        return null;
    }
}
