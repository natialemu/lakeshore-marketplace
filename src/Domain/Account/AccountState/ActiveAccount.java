package Domain.Account.AccountState;

import Domain.Account.Account;
import Domain.Account.AccountProfile.Contact.Location;

public class ActiveAccount implements AccountState {
    private Account account;

    public ActiveAccount(Account account){
        this.account = account;
    }

    @Override
    public boolean updateUserName(String username) {
        return false;
    }

    @Override
    public boolean updatePassword(String password) {
        return false;
    }

    @Override
    public boolean updateDateOfBirth(String dateOfBirth) {
        return false;
    }

    @Override
    public boolean updateEmail(String email) {
        return true;
    }

    @Override
    public boolean updatePaymentCard(String cardNumber, String expirationDate, String cardHolderName, int securityCode) {
        return false;
    }

    @Override
    public boolean updateBankInformation(String bankName, String accountNumber, String routingNumber) {
        return false;
    }

    @Override
    public boolean updateAddress(String streetAddress, String state, String city, int zipcode, String country, int pobox) {
        return false;
    }

    @Override
    public boolean deleteAccount(int accountID) {
        return false;
    }

    @Override
    public boolean deleteAccountAccount(String email, String password) {
        return false;
    }

    @Override
    public boolean deleteAccountWithPassword(String username, String password) {
        return false;
    }

    @Override
    public boolean getPassowrd(String securityQuestion, String securityQuestionAnswer) {
        return true;
    }

    @Override
    public boolean getPasswordThroughEmail(String email) {
        return true;
    }


    @Override
    public void setDefaultLocation(Location location) {
        //account.getAccountSettings().setDefaultLocation(location);

    }

    @Override
    public void setDefaultPaymentCard(String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber) {
        //account.getAccountSettings().setDefaultPaymentCard(cardHolderName,cardNumber,cardExpirationDate,securityNumber);

    }

    @Override
    public void setDefaultBankAccount(String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode) {

        //account.getAccountSettings().setDefaultBankAccount(bankName,routingNumber,accountType,billingAddress,swiftCode);
    }

    @Override
    public boolean logInToAccount(String username, String password) {
        account.setAccountState(account.getLoggedInState());
        return true;
    }

    @Override
    public boolean logInToAccountWithEmail(String email, String password) {
        account.setAccountState(account.getLoggedInState());
        return true;
    }

    @Override
    public boolean ReactivateAccount(String oldUsername, String oldPassword) {
        return false;
    }
}
