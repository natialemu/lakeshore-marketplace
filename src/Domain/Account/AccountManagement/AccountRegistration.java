package Domain.Account.AccountManagement;

import Domain.Account.Account;
import Domain.Account.AccountProfile.Contact.Location;

public interface AccountRegistration {

    //Creating an account
    boolean createBasicAccount(Account account);
    boolean createAccountContactProfile(String username,String email, String fullName, Location location, String dateOfBirth, String securityQuestion, String securityQuestionAnswer);
    boolean createAccountFinancialProfile(String username,String cardNumber, String accountNumber, String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode);
    boolean createPaymentCardProfile(String username, String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber);
	boolean createAccountContactProfile(String username, String fullName, Location location, String birthDate,
			String cellPhone);
	boolean createBankProfile(String username,String accountNumber, String accountType, String bankName, String routingNumber);


}
