package Domain.Account;

import Domain.Account.AccountManagement.AccountManagement;
import Domain.Account.AccountProfile.AccountProfile;
import Domain.Account.AccountProfile.Contact.Location;
import Domain.Account.AccountSettings.AccountSettings;
import Domain.Account.AccountState.AccountState;

public class AccountFactoryImpl implements AccountFactory {
    private AccountManagement accountManagement;
    private Account account;

    @Override
    public boolean updateUserName(String username) {
        return false;
    }

    @Override
    public boolean updatePassword(String password) {
        return false;
    }

    @Override
    public boolean updateDateOfBirth(String dateOfBirth) {
        return false;
    }

    @Override
    public boolean updateEmail(String email) {
        return false;
    }

    @Override
    public boolean updatePaymentCard(String cardNumber, String expirationDate, String cardHolderName, int securityCode) {
        return false;
    }

    @Override
    public boolean updateBankInformation(String bankName, String accountNumber, String routingNumber) {
        return false;
    }

    @Override
    public boolean updateAddress(String streetAddress, String state, String city, int zipcode, String country, int pobox) {
        return false;
    }

    @Override
    public boolean deleteAccount(int accountID) {
        return false;
    }

    @Override
    public boolean deleteAccountAccount(String email, String password) {
        return false;
    }

    @Override
    public boolean deleteAccountWithEmail(String username, String password) {
        return false;
    }

    @Override
    public boolean getPassowrd(String securityQuestion, String securityQuestionAnswer) {
        return false;
    }

    @Override
    public boolean getPasswordThroughEmail(String email) {
        return false;
    }

    @Override
    public void setDefaultLocation(Location location) {

    }

    @Override
    public void setDefaultPaymentCard(String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber) {

    }

    @Override
    public void setDefaultBankAccount(String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode) {

    }

    @Override
    public boolean logInToAccount(String username, String password) {
        return false;
    }

    @Override
    public boolean logInToAccountWithEmail(String email, String password) {
        return false;
    }

    @Override
    public boolean ReactivateAccount(String oldUsername, String oldPassword) {
        return false;
    }

    @Override
    public void setAccountState(AccountState accountState) {

    }

    @Override
    public AccountState getAccountSate() {
        return null;
    }

    @Override
    public AccountState getActiveState() {
        return null;
    }

    @Override
    public AccountState getInActiveState() {
        return null;
    }

    @Override
    public AccountState getLoggedInState() {
        return null;
    }

    @Override
    public AccountProfile getAccountProfile() {
        return null;
    }

    @Override
    public AccountSettings getAccountSettings() {
        return null;
    }

    @Override
    public void setAccountSettings(AccountSettings accountSettings) {

    }

    @Override
    public void setAccountProfile(AccountProfile accountProfile) {

    }

    @Override
    public boolean createBasicAccount(String username, String password) {
        return false;
    }

    @Override
    public boolean createAccountContactProfile(String email, String fullName, Location location, String dateOfBirth, String securityQuestion, String securityQuestionAnswer) {
        return false;
    }

    @Override
    public boolean createAccountFinancialProfile(String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode) {
        return false;
    }

    @Override
    public boolean createPaymentCardProfile(String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber) {
        return false;
    }
}
