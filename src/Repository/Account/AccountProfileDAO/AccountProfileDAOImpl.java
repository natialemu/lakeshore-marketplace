package Repository.Account.AccountProfileDAO;

import Domain.Account.AccountProfile.AccountProfile;
import Domain.Account.AccountProfile.Contact.Location;

public class AccountProfileDAOImpl implements AccountProfileDAO {
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
    public void updateUserName(String username) {

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
    public boolean logIntoAccountWithEmail(String email, String password) {
        return false;
    }

    @Override
    public boolean validateAccountWithEmail(String email, String password) {
        return false;
    }

    @Override
    public boolean getPassword(String username, String securityQuestion, String securityQuestionAnswer) {
        return false;
    }

    @Override
    public boolean getPasswordThroughEmail(String email) {
        return false;
    }

    @Override
    public AccountProfile getAccountProfile(String username) {
        return null;
    }

    @Override
    public AccountProfile getAccountProfilewithEmail(String email) {
        //get all account profiles that have email as a foreign key
        //build the account profile and return it
        return null;
    }
}
