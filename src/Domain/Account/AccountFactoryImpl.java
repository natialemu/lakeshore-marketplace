package Domain.Account;

import Domain.Account.AccountManagement.AccountManagement;
import Domain.Account.AccountManagement.AccountManagementImpl;
import Domain.Account.AccountProfile.AccountProfile;
import Domain.Account.AccountProfile.Contact.Location;
import Domain.Account.AccountSettings.AccountSettings;
import Domain.Account.AccountState.AccountState;

public class AccountFactoryImpl implements AccountFactory {


    private AccountManagement accountManagement;
    private  Account account;//set when logging in

    public AccountFactoryImpl(){

        accountManagement = new AccountManagementImpl();

    }

    @Override
    public boolean updateUserName(String username) {
        if(account != null && account.updateUserName(username)){
            return accountManagement.updateUserName(username);
        }
        return false;
    }

    @Override
    public boolean updatePassword(String username, String password) {
        if(account != null && account.updatePassword(username, password)){
            return accountManagement.updatePassword(username, password);
        }
        return false;
    }

    @Override
    public boolean updateDateOfBirth(String dateOfBirth) {
        if(account != null && account.updateDateOfBirth(dateOfBirth)){
            return accountManagement.updateDateOfBirth(dateOfBirth);
        }
        return false;
    }

    @Override
    public boolean updateEmail(String email) {
        if(account != null && account.updateEmail(email)){
            return accountManagement.updateEmail(email);
        }
        return false;
    }

    @Override
    public boolean updatePaymentCard(String cardNumber, String expirationDate, String cardHolderName, int securityCode) {
        if(account != null && account.updatePaymentCard(cardNumber,expirationDate,cardHolderName,securityCode)){
            return accountManagement.updatePaymentCard(cardNumber,expirationDate,cardHolderName,securityCode);
        }
        return false;
    }

    @Override
    public boolean updateBankInformation(String bankName, String accountNumber, String routingNumber) {
        if(account != null && account.updateBankInformation(bankName,accountNumber,routingNumber)){
            return accountManagement.updateBankInformation(bankName,accountNumber,routingNumber);
        }
        return false;
    }

    @Override
    public boolean updateAddress(String streetAddress, String state, String city, int zipcode, String country, int pobox) {
        if(account != null && account.updateAddress(streetAddress,state,city,zipcode,country,pobox)){
            return accountManagement.updateAddress(streetAddress,state,city,zipcode,country,pobox);
        }
        return false;
    }

    @Override
    public boolean deleteAccount(int accountID) {
        if(account != null && account.deleteAccount(accountID)){
            return accountManagement.deleteAccount(accountID);
        }
        return false;
    }

    @Override
    public boolean deleteAccountAccount(String email, String password) {
        if(account != null && account.deleteAccountAccount(email,password)){
            return accountManagement.deleteAccountAccount(email,password);
        }
        return false;
    }

    @Override
    public boolean deleteAccountWithUsername(String username, String password) {
        if(account != null && account.deleteAccountWithUsername(username,password)){
            return accountManagement.deleteAccountWithUsername(username,password);
        }
        return false;
    }

    @Override
    public boolean getPassowrd(String username, String securityQuestion, String securityQuestionAnswer) {
        return accountManagement.getPassowrd(username, securityQuestion,securityQuestionAnswer);

    }

    @Override
    public boolean getPasswordThroughEmail(String email) {

        return accountManagement.getPasswordThroughEmail(email);
    }

    @Override
    public void setDefaultLocation(Location location) {
        if(account != null){
            account.setDefaultLocation(location);
            accountManagement.setDefaultLocation(location);
        }

    }

    @Override
    public void setDefaultPaymentCard(String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber) {
        if(account != null){
            account.setDefaultPaymentCard(cardHolderName,cardNumber,cardExpirationDate,securityNumber);
            accountManagement.setDefaultPaymentCard(cardHolderName,cardNumber,cardExpirationDate,securityNumber);
        }

    }

    @Override
    public void setDefaultBankAccount(String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode) {
        if(account != null){
            account.setDefaultBankAccount(bankName,routingNumber,accountType,billingAddress,swiftCode);
            accountManagement.setDefaultBankAccount(bankName,routingNumber,accountType,billingAddress,swiftCode);
        }
    }

    @Override
    public boolean logInToAccount(String username, String password) {
        if(account == null && accountManagement.validateAccount(username,password)){

            account = accountManagement.getAccount(username);

            return account.logInToAccount(username,password);
        }
        return false;
    }

    @Override
    public boolean logInToAccountWithEmail(String email, String password) {
        if(account == null && accountManagement.validateAccountWithEmail(email,password)){

            account = accountManagement.getAccountWithEmail(email);

            return account.logInToAccountWithEmail(email,password);
        }
        return false;
    }

    @Override
    public boolean ReactivateAccount(String oldUsername, String oldPassword) {
        if(account != null && account.ReactivateAccount(oldUsername,oldPassword)){
            return accountManagement.ReactivateAccount(oldUsername,oldPassword);

        }
        return false;
    }

    @Override
    public boolean createBasicAccount(String username, String password) {
        return accountManagement.createBasicAccount(username,password);
    }

    @Override
    public boolean createAccountContactProfile(String email, String fullName, Location location, String dateOfBirth, String securityQuestion, String securityQuestionAnswer) {
        return accountManagement.createAccountContactProfile(email,fullName,location,dateOfBirth,securityQuestion,securityQuestionAnswer);
    }

    @Override
    public boolean createAccountFinancialProfile(String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode) {
        return accountManagement.createAccountFinancialProfile(bankName,routingNumber,accountType,billingAddress,swiftCode);
    }

    @Override
    public boolean createPaymentCardProfile(String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber) {
        return accountManagement.createPaymentCardProfile(cardHolderName,cardNumber,cardExpirationDate,securityNumber);
    }
}
