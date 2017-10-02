package Repository.Account.AccountProfileDAO;

import Domain.Account.AccountProfile.Contact.Location;

public interface AccountProfileDAO {
    boolean createAccountContactProfile(String email, String fullName, Location location, String dateOfBirth, String securityQuestion, String securityQuestionAnswer);

    boolean createAccountFinancialProfile(String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode);

    boolean createPaymentCardProfile(String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber);


    void updateUserName(String username);

    boolean updatePassword(String username, String password);

    boolean updateEmail(String email);

    boolean updatePaymentCard(String cardNumber, String expirationDate, String cardHolderName, int securityCode);

    boolean updateBankInformation(String bankName, String accountNumber, String routingNumber);

    boolean updateAddress(String streetAddress, String state, String city, int zipcode, String country, int pobox);

    boolean logIntoAccountWithEmail(String email, String password);
}
