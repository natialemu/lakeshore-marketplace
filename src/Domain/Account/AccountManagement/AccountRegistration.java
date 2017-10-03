package Domain.Account.AccountManagement;

import Domain.Account.AccountProfile.Contact.Location;

public interface AccountRegistration {

    //Creating an account
    boolean createBasicAccount(String username, String password);
    boolean createAccountContactProfile(String email, String fullName, Location location, String dateOfBirth, String securityQuestion, String securityQuestionAnswer);
    boolean createAccountFinancialProfile(String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode);
    boolean createPaymentCardProfile(String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber);


}
