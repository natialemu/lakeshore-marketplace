package Domain.Account.AccountManagement;

import Domain.Account.Account;
import Domain.Account.AccountProfile.AccountProfile;
import Domain.Account.AccountProfile.Contact.Location;
import Domain.Account.AccountSettings.AccountSettings;
import Domain.Account.AccountState.AccountState;

public interface AccountManagement {
    //Update Account information
    boolean updateUserName(String username,String password);
    boolean updatePassword(String username, String password);
    boolean updateDateOfBirth(String dateOfBirth);
    boolean updateEmail(String email,String password);
    boolean updatePaymentCard(String cardNumber, String expirationDate, String cardHolderName, int securityCode);
    boolean updateBankInformation(String bankName, String accountNumber, String routingNumber);
    boolean updateAddress(String streetAddress, String state, String city, int zipcode, String country, int pobox);

    //Deleting An account
    boolean deleteAccount(int accountID);
    boolean deleteAccountAccount(String email, String password);
    boolean deleteAccountWithUsername(String username, String password);

    //Recovering an account
    String getPassowrd(String username, String securityQuestion, String securityQuestionAnswer);
    boolean getPasswordThroughEmail(String email);



    //Set Preferences
    void setDefaultLocation(Location location);
    void setDefaultPaymentCard(String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber);
    void setDefaultBankAccount(String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode);

    //Login to Account
    boolean logInToAccount(String username, String password);
    boolean logInToAccountWithEmail(String email, String password);

    //Re-activate Account
    boolean ReactivateAccount(String oldUsername, String oldPassword);



    //Creating an account
    boolean createBasicAccount(String username, String password);
    boolean createAccountContactProfile(String email, String fullName, Location location, String dateOfBirth, String securityQuestion, String securityQuestionAnswer);
    boolean createAccountFinancialProfile(String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode);
    boolean createPaymentCardProfile(String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber);

    boolean validateAccount(String username, String password);

    Account getAccount(String username);

    Account getAccountWithEmail(String email);

    boolean validateAccountWithEmail(String email, String password);

}
