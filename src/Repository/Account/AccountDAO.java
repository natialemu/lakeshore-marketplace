package Repository.Account;

import Domain.Account.Account;
import Domain.Account.AccountProfile.Contact.Location;

public interface AccountDAO {

    boolean createBasicAccount(String username, String password);

    boolean createAccountContactProfile(String email, String fullName, Location location, String dateOfBirth, String securityQuestion, String securityQuestionAnswer);

    boolean createAccountFinancialProfile(String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode);

    boolean createPaymentCardProfile(String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber);


    boolean deleteAccount(int accountID);

    boolean deleteAccountAccount(String email, String password);

    boolean deleteAccountWithUsername(String username, String password);

    boolean updateUserName(String username,String password);


    boolean updatePassword(String username, String password);

    boolean updateEmail(String email,String password);

    boolean updatePaymentCard(String cardNumber, String expirationDate, String cardHolderName, int securityCode);

    boolean updateBankInformation(String bankName, String accountNumber, String routingNumber);

    boolean updateAddress(String streetAddress, String state, String city, int zipcode, String country, int pobox);

    boolean activateStatusOfAccount(String oldUsername, String oldPassword);

    void setDefaultBankAccount(String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode);

    void setDefaultLocation(Location location);

    void setDefaultPaymentCard(String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber);

    boolean logIntoAccount(String username, String password);

    boolean logIntoAccountWithEmail(String email, String password);

    boolean validateAccount(String username, String password);

    boolean validateAccountWithEmail(String email, String password);

    Account getAccount(String username);

    Account getAccountWithEmail(String email);

    String getPassword(String username, String securityQuestion, String securityQuestionAnswer);

    boolean getPasswordThroughEmail(String email);


    Account getAccount(int account_id);
}
