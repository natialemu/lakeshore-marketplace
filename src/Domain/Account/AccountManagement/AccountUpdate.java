package Domain.Account.AccountManagement;

import Domain.Account.AccountProfile.Contact.Location;

public interface AccountUpdate {
    //Update Account information
    boolean updateUserName(String username,String password);
    boolean updatePassword(String username, String password);
    boolean updateDateOfBirth(String dateOfBirth);
    boolean updateEmail(String email,String password);
    boolean updatePaymentCard(String cardNumber, String expirationDate, String cardHolderName, int securityCode);
    boolean updateBankInformation(String bankName, String accountNumber, String routingNumber);
    boolean updateAddress(String username,String streetAddress, String state, String city, int zipcode, String country, int pobox);

    boolean activateStatusOfAccount(String oldUsername, String oldPassword);

    void setDefaultBankAccount(String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode);

    void setDefaultLocation(Location location);

    void setDefaultPaymentCard(String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber);

}
