package Domain.Account;

import Domain.Account.AccountProfile.AccountProfile;
import Domain.Account.AccountProfile.AccountProfileImpl;
import Domain.Account.AccountProfile.Contact.Location;
import Domain.Account.AccountSettings.AccountSettings;
import Domain.Account.AccountState.AccountState;
import Domain.Account.AccountState.ActiveAccount;

public interface Account {
    //Update Account information
    boolean updateUserName(String username);
    boolean updatePassword(String password);
    boolean updateDateOfBirth(String dateOfBirth);
    boolean updateEmail(String email);
    boolean updatePaymentCard(String cardNumber, String expirationDate, String cardHolderName, int securityCode);
    boolean updateBankInformation(String bankName, String accountNumber, String routingNumber);
    boolean updateAddress(String streetAddress, String state, String city, int zipcode, String country, int pobox);

    //Deleting An account
    boolean deleteAccount(int accountID);
    boolean deleteAccountAccount(String email, String password);
    boolean deleteAccountWithPassword(String username, String password);

    //Recovering an account
    boolean getPassowrd(String securityQuestion, String securityQuestionAnswer);
    boolean getPasswordThroughEmail(String email);

    //Creating an account
    boolean createBasicAccount(String username, String password);
    boolean createAccountContactProfile(String email, String fullName, Location location, String dateOfBirth, String securityQuestion, String securityQuestionAnswer);
    boolean createAccountFinancialProfile(String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode);
    boolean createPaymentCardProfile(String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber);

    //Set Preferences
    void setDefaultLocation(Location location);
    void setDefaultPaymentCard(String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber);
    void setDefaultBankAccount(String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode);

    //Login to Account
    boolean logInToAccount(String username, String password);
    boolean logInToAccountWithEmail(String email, String password);

    //Re-activate Account
    boolean ReactivateAccount(String oldUsername, String oldPassword);


    //Set and get accountStates
    void setAccountState(AccountState accountState);
    AccountState getAccountSate();
    AccountState getActiveState();
    ActiveAccount getInActiveState();
    ActiveAccount  getLoggedInState();

    //Setter and getter
    AccountProfile getAccountProfile();
    AccountSettings getAccountSettings();
    void setAccountSettings(AccountSettings accountSettings);
    void setAccountProfile(AccountProfile accountProfile);
}
