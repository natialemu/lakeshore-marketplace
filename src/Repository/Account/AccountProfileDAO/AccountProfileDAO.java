package Repository.Account.AccountProfileDAO;

import Domain.Account.AccountProfile.AccountProfile;
import Domain.Account.AccountProfile.Contact.Location;

public interface AccountProfileDAO {
    boolean createAccountContactProfile(String username, String email, String fullName, Location location, String dateOfBirth, String securityQuestion, String securityQuestionAnswer);

    boolean createAccountFinancialProfile(String username, String accountNumber, String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode);

    boolean createPaymentCardProfile(String accountNumber, String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber);


    void updateUserName(String username, String password);

    boolean updatePassword(String username, String password);

    boolean updateEmail(String email, String password);

    boolean updatePaymentCard(String cardNumber, String expirationDate, String cardHolderName, int securityCode);

    boolean updateBankInformation(String bankName, String accountNumber, String routingNumber);

    boolean updateAddress(String streetAddress, String state, String city, int zipcode, String country, int pobox);

    boolean logIntoAccountWithEmail(String email, String password);

    boolean validateAccountWithEmail(String email, String password);

    String getPassword(String username, String securityQuestion, String securityQuestionAnswer);

    boolean getPasswordThroughEmail(String email);


    AccountProfile getAccountProfile(String username);

    AccountProfile getAccountProfilewithEmail(String email);//get

    boolean logInToAccount(String username, String password);

    void createBasicProfile(String username, String email, int fin_profile_id, String password);

	boolean updateAccountContactProfile(String username, String fullName, Location location, String birthDate,
			String cellPhone);

	String getUsername(String password);

}
