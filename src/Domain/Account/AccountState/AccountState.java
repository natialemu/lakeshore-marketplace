package Domain.Account.AccountState;

import Domain.Account.AccountProfile.Contact.Location;

public interface AccountState {

    //Update Account information
    boolean updateUserName(String username);
    boolean updatePassword(String username,String password);
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
    boolean getPassowrd(String username, String securityQuestion, String securityQuestionAnswer);
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



}
