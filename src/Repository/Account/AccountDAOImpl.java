package Repository.Account;

import Domain.Account.Account;
import Domain.Account.AccountProfile.AccountProfile;
import Domain.Account.AccountProfile.Contact.Location;
import Domain.Account.AccountSettings.AccountSettings;
import Repository.Account.AccountProfileDAO.AccountProfileDAO;
import Repository.Account.AccountProfileDAO.AccountProfileDAOImpl;
import Repository.Account.AccountSettingsDAO.AccountSettingsDAO;
import Repository.Account.AccountSettingsDAO.AccountSettingsDAOImpl;

public class AccountDAOImpl implements AccountDAO {
    AccountProfileDAO accountProfileDAO;
    AccountSettingsDAO accountSettingsDAO;

    public AccountDAOImpl(){
        accountProfileDAO = new AccountProfileDAOImpl();
        accountSettingsDAO = new AccountSettingsDAOImpl();
    }
    @Override
    public boolean createBasicAccount(String username, String password) {
        //TODO
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

    @Override
    public boolean deleteAccount(int accountID) {
        return false;
    }

    @Override
    public boolean deleteAccountAccount(String email, String password) {
        return false;
    }

    @Override
    public boolean deleteAccountWithUsername(String username, String password) {
        return false;
    }

    @Override
    public boolean updateUserName(String username) {
        return false;
    }

    @Override
    public boolean updatePassword(String username, String password) {
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
    public boolean activateStatusOfAccount(String oldUsername, String oldPassword) {
        return false;
    }

    @Override
    public void setDefaultBankAccount(String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode) {

    }

    @Override
    public void setDefaultLocation(Location location) {

    }

    @Override
    public void setDefaultPaymentCard(String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber) {

    }

    @Override
    public boolean logIntoAccount(String username, String password) {
        return false;
    }

    @Override
    public boolean logIntoAccountWithEmail(String email, String password) {
        return false;
    }

    @Override
    public boolean validateAccount(String username, String password) {
        return false;
    }

    @Override
    public boolean validateAccountWithEmail(String email, String password) {
        return false;
    }

    @Override
    public Account getAccount(String username) {
        return null;
    }

    @Override
    public Account getAccountWithEmail(String email) {
        return null;
    }

    @Override
    public boolean getPassword(String username, String securityQuestion, String securityQuestionAnswer) {
        return false;
    }

    @Override
    public boolean getPasswordThroughEmail(String email) {
        return false;
    }
}
