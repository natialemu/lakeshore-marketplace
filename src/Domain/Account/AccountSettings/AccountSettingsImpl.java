package Domain.Account.AccountSettings;

import Domain.Account.AccountProfile.Contact.Location;
import Domain.Account.AccountProfile.Finance.BankAccount;
import Domain.Account.AccountProfile.Finance.PaymentCard;
import Domain.Tools.IDGenerator;
import com.sun.org.apache.bcel.internal.generic.I2D;

public class AccountSettingsImpl implements AccountSettings{
    //TODO
    private Preferences preferences;

    public int getAccountSettingsID() {
        return accountSettingsID;
    }

    public void setAccountSettingsID(int accountSettingsID) {
        this.accountSettingsID = accountSettingsID;
    }

    private int accountSettingsID;

    public AccountSettingsImpl(){
        preferences = new PreferencesImpl();
        accountSettingsID = IDGenerator.getId();

    }

    @Override
    public void setDefaultLocation(Location location) {
        preferences.setDefaultLocation(location);

    }

    @Override
    public void setDefaultPaymentCard(String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber) {

        preferences.setDefaultPaymentCard(cardHolderName,cardNumber,cardExpirationDate,securityNumber);
    }

    @Override
    public void setDefaultBankAccount(String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode) {

        preferences.setDefaultBankAccount(bankName,routingNumber,accountType,billingAddress,swiftCode);
    }

    @Override
    public Location getDefaultLocation() {
        return preferences.getDefaultLocation();
    }

    @Override
    public PaymentCard getDefaultPaymentCard() {
        return preferences.getDefaultPaymentCard();
    }

    @Override
    public BankAccount getDefaultBankAccount() {
        return preferences.getDefaultBankAccount();
    }


}
