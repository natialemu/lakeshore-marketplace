package Domain.Account;

import Domain.Account.AccountProfile.AccountProfile;
import Domain.Account.AccountProfile.AccountProfileImpl;
import Domain.Account.AccountProfile.Contact.Location;
import Domain.Account.AccountSettings.AccountSettings;
import Domain.Account.AccountState.*;

public class AccountImpl implements Account{
    private AccountState currentstate;

    public AccountProfile getAccountProfile() {
        return accountProfile;
    }

    public void setAccountProfile(AccountProfile accountProfile) {
        this.accountProfile = accountProfile;
    }

    public AccountSettings getAccountSettings() {
        return accountSettings;
    }

    public void setAccountSettings(AccountSettings accountSettings) {
        this.accountSettings = accountSettings;
    }

    private AccountProfile accountProfile;
    private AccountSettings accountSettings;

    private AccountState ACTIVE_STATE = new ActiveAccount(this);
    private AccountState INACTIVE_STATE = new InactiveAccount(this);
    private AccountState LOGGED_IN_STATE = new LoggedInState(this);

    public AccountImpl(String username, String password){
        //set account info
        accountProfile = new AccountProfileImpl(username,password);
        setAccountState(ACTIVE_STATE);
    }

    @Override
    public boolean updateUserName(String username) {
        return currentstate.updateUserName(username);
    }

    @Override
    public boolean updatePassword(String password) {
        return currentstate.updatePassword(password);
    }

    @Override
    public boolean updateDateOfBirth(String dateOfBirth) {
        return currentstate.updateDateOfBirth(dateOfBirth);
    }

    @Override
    public boolean updateEmail(String email) {
        return currentstate.updateEmail(email);
    }

    @Override
    public boolean updatePaymentCard(String cardNumber, String expirationDate, String cardHolderName, int securityCode) {
        return currentstate.updatePaymentCard(cardNumber,expirationDate,cardHolderName,securityCode);
    }

    @Override
    public boolean updateBankInformation(String bankName, String accountNumber, String routingNumber) {
        return currentstate.updateBankInformation(bankName,accountNumber,routingNumber);
    }

    @Override
    public boolean updateAddress(String streetAddress, String state, String city, int zipcode, String country, int pobox) {
        return currentstate.updateAddress(streetAddress,state,city,zipcode,country,pobox);
    }

    @Override
    public boolean deleteAccount(int accountID) {
        return currentstate.deleteAccount(accountID);
    }

    @Override
    public boolean deleteAccountAccount(String email, String password) {
        return currentstate.deleteAccountAccount(email,password);
    }

    @Override
    public boolean deleteAccountWithEmail(String username, String password) {

        return currentstate.deleteAccountWithPassword(username,password);
    }

    @Override
    public boolean getPassowrd(String securityQuestion, String securityQuestionAnswer) {
        return currentstate.getPassowrd(securityQuestion,securityQuestionAnswer);
    }

    @Override
    public boolean getPasswordThroughEmail(String email) {
        return currentstate.getPasswordThroughEmail(email);
    }

    @Override
    public void setDefaultLocation(Location location) {
        currentstate.setDefaultLocation(location);

    }

    @Override
    public void setDefaultPaymentCard(String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber) {

        currentstate.setDefaultPaymentCard(cardHolderName,cardNumber,cardExpirationDate,securityNumber);
    }

    @Override
    public void setDefaultBankAccount(String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode) {

        currentstate.setDefaultBankAccount(bankName,routingNumber,accountType,billingAddress,swiftCode);
    }

    @Override
    public boolean logInToAccount(String username, String password) {
        return currentstate.logInToAccount(username,password);
    }

    @Override
    public boolean logInToAccountWithEmail(String email, String password) {
        return currentstate.logInToAccountWithEmail(email,password);
    }

    @Override
    public boolean ReactivateAccount(String oldUsername, String oldPassword) {
        return currentstate.ReactivateAccount(oldUsername,oldPassword);
    }

    @Override
    public void setAccountState(AccountState accountState) {
             currentstate = accountState;
    }

    @Override
    public AccountState getAccountSate() {
        return currentstate;
    }

    @Override
    public AccountState getActiveState() {
        return ACTIVE_STATE;
    }

    @Override
    public AccountState getInActiveState() {
        return INACTIVE_STATE;
    }

    @Override
    public AccountState getLoggedInState() {
        return LOGGED_IN_STATE;
    }
}
