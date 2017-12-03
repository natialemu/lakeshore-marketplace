package Domain.Account;

import Domain.Account.AccountProfile.AccountProfile;
import Domain.Account.AccountProfile.Contact.Location;
import Domain.Account.AccountSettings.AccountSettings;
import Domain.Account.AccountState.AccountState;
import Service.Representation.Account.Representation.AccountRepresentation;

public interface AccountFactory {



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
    boolean createBasicAccount(Account account);
    boolean createAccountContactProfile(String username,String email, String fullName, Location location, String dateOfBirth, String securityQuestion, String securityQuestionAnswer);
    boolean createAccountFinancialProfile(String username,String accountNumber, String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode);
    boolean createPaymentCardProfile(String accountNumber, String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber);


    Account getNewAccount(String email, String username, String password);
    Account getAccount(String username, String password);
	void updateBankName(String bankAccountNumber, String newBankName);
	void updateAccountNumber(String oldAccountNumber, String newAccountNumber);
	void updateRoutingNumber(String accountNumber, String newRoutingNumber);
	void updateSwiftCode(String accountNumber, int newSwiftCode);
	void updateAccountType(String accountNumber, String newAccountType);
	void updateCardNumber(String cardNumber, String newPaymentCard);
	void updateCardExpirationDate(String cardNumber, String newDate);
	void updateNameOnCard(String cardNumber, String newNameOncard);
	void updateSecurityCode(String cardNumber, String newSecurityCode);
	void deleteBankName(String bankAccountNumber, String bankName);
	void deleteAccountNumber(String accountNumber);
	void deleteRoutingNumber(String accountNumber, String routingNumber);
	void deleteSwiftCode(String accountNumber, String swiftCode);
	void deleteAccountType(String accountNumber, String accountType);
	void deleteCardNumber(String cardNumber);
	void deleteCardExpirationDate(String cardNumber, String expirationDate);
	void deleteNameOnCard(String cardNumber, String cardName);
	void deleteSecurityCode(String cardNumber, int securityCode);
	boolean createPersonalInformation(String birthDate, String cellPhone, String fullName, String city, String fullName2,
			String state, String streetAddress, String zipcode, String username);
	void removeSecurityAnswer(String email, String newSecurityQuestionAnswer);
	void removesecurityQuestion(String email, String newSecurityQuestion);
	void removePhone(String email, int areacode, int countrycode, int phoneNumber, int phoneType);
	void removeLocation(String email, String streetAddress, String state, String city, int zipcode, String country);
	void removeBirthDate(String email, String birthDate);
	void removeFullName(String email, String fullName);
	void removeEmail(String newEmail);
	void updatePhone(String email, int areacode, int countrycode, int phoneNumber, int phoneType);
	void updateAddress(String email, String streetAddress, String state, String city, int zipcode, String country);
	void updateBirthDate(String email, String birthDate);
	void updateFullName(String email, String newFullName);
	boolean validateAccount(String username, String password);
	Account getAccount(String username);
	String getUsername(String password);
}
