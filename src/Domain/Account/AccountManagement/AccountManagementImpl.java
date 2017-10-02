package Domain.Account.AccountManagement;

import Domain.Account.Account;
import Domain.Account.AccountProfile.AccountProfile;
import Domain.Account.AccountProfile.Contact.Location;
import Domain.Account.AccountSettings.AccountSettings;
import Domain.Account.AccountState.AccountState;
import Repository.Account.AccountDAO;
import Repository.Account.AccountDAOImpl;

public class AccountManagementImpl implements AccountManagement {
    private AccountDeletion accountDeletion;
    private AccountRegistration accountRegistration;
    private AccountValidation accountValidation;
    private AccountUpdate accountUpdate;
    private AccountDAO accountDAO;

    public AccountManagementImpl(){

        accountDAO = new AccountDAOImpl();
        accountDeletion = new AccountDeletionImpl();
        accountValidation = new AccountValidationImpl();
        accountRegistration = new AccountRegistrationImpl();
        accountUpdate = new AccountUpdateImpl();
    }
    @Override
    public boolean updateUserName(String username) {
        return accountUpdate.updateUserName(username);
    }

    @Override
    public boolean updatePassword(String password) {
        return accountUpdate.updatePassword(password);
    }

    @Override
    public boolean updateDateOfBirth(String dateOfBirth) {
        return accountUpdate.updateDateOfBirth(dateOfBirth);
    }

    @Override
    public boolean updateEmail(String email) {
        return accountUpdate.updateEmail(email);
    }

    @Override
    public boolean updatePaymentCard(String cardNumber, String expirationDate, String cardHolderName, int securityCode) {
        return accountUpdate.updatePaymentCard(cardNumber,expirationDate,cardHolderName,securityCode);
    }

    @Override
    public boolean updateBankInformation(String bankName, String accountNumber, String routingNumber) {
        return accountUpdate.updateBankInformation(bankName,accountNumber,routingNumber);
    }

    @Override
    public boolean updateAddress(String streetAddress, String state, String city, int zipcode, String country, int pobox) {
        return accountUpdate.updateAddress(streetAddress,state,city,zipcode,country,pobox);
    }

    @Override
    public boolean deleteAccount(int accountID) {
        return accountDeletion.deleteAccount(accountID);
    }

    @Override
    public boolean deleteAccountAccount(String email, String password) {
        return accountDeletion.deleteAccountAccount(email,password);
    }

    @Override
    public boolean deleteAccountWithUsername(String username, String password) {
        return accountDeletion.deleteAccountAccount(username,password);
    }

    @Override
    public boolean getPassowrd(String securityQuestion, String securityQuestionAnswer) {
        //TODO: needs to be implemented here
        return false;
    }

    @Override
    public boolean getPasswordThroughEmail(String email) {
        //TODO: needs to be implemented here
        return false;
    }

    @Override
    public void setDefaultLocation(Location location) {
        //TODO: needs to be impelemented here

    }

    @Override
    public void setDefaultPaymentCard(String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber) {
        //TODO: needs to be impelemented here

    }

    @Override
    public void setDefaultBankAccount(String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode) {
        //TODO: needs to be implemented here

    }

    @Override
    public boolean logInToAccount(String username, String password) {
        return accountValidation.logInToAccount(username,password);
    }

    @Override
    public boolean logInToAccountWithEmail(String email, String password) {
        return accountValidation.logInToAccountWithEmail(email,password);
    }

    @Override
    public boolean ReactivateAccount(String oldUsername, String oldPassword) {
        //TODO: needs to be implemented here
        return false;
    }

    @Override
    public boolean createBasicAccount(String username, String password) {
        return accountRegistration.createBasicAccount(username,password);
    }

    @Override
    public boolean createAccountContactProfile(String email, String fullName, Location location, String dateOfBirth, String securityQuestion, String securityQuestionAnswer) {
        return accountRegistration.createAccountContactProfile(email,fullName,location,dateOfBirth,securityQuestion,securityQuestionAnswer);
    }

    @Override
    public boolean createAccountFinancialProfile(String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode) {
        return accountRegistration.createAccountFinancialProfile(bankName,routingNumber,accountType,billingAddress,swiftCode);
    }

    @Override
    public boolean createPaymentCardProfile(String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber) {
        return accountRegistration.createPaymentCardProfile(cardHolderName,cardNumber,cardExpirationDate,securityNumber);
    }

    @Override
    public boolean validateAccount(String username, String password) {
        return accountValidation.validateAccount(username,password);
    }

    @Override
    public Account getAccount(String username) {
        //TODO: to be implemented here
        return null;
    }

    @Override
    public Account getAccountWithEmail(String email) {
        //TODO: to be implemented here
        return null;
    }

    @Override
    public boolean validateAccountWithEmail(String email, String password) {

        return accountValidation.validateAccountWithEmail(email,password);
    }
}
