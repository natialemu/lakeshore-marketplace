package Domain.Account.AccountState;

import Domain.Account.Account;
import Domain.Account.AccountProfile.Contact.Location;

public class LoggedInState implements AccountState {
    private Account account;

    public LoggedInState(Account account){
        this.account = account;
    }
    @Override
    public boolean updateUserName(String username) {
        return true;
    }

    @Override
    public boolean updatePassword(String username, String password) {
        return true;
    }

    @Override
    public boolean updateDateOfBirth(String dateOfBirth) {
        return true;
    }

    @Override
    public boolean updateEmail(String email) {
        return true;
    }

    @Override
    public boolean updatePaymentCard(String cardNumber, String expirationDate, String cardHolderName, int securityCode) {
        return true;
    }

    @Override
    public boolean updateBankInformation(String bankName, String accountNumber, String routingNumber) {
        return true;
    }

    @Override
    public boolean updateAddress(String streetAddress, String state, String city, int zipcode, String country, int pobox) {
        return true;
    }

    @Override
    public boolean deleteAccount(int accountID) {
        account.setAccountState(account.getInActiveState());
        return true;
    }

    @Override
    public boolean deleteAccountAccount(String email, String password) {
        account.setAccountState(account.getInActiveState());
        return true;
    }

    @Override
    public boolean deleteAccountWithPassword(String username, String password) {
        account.setAccountState(account.getInActiveState());
        return true;
    }

    @Override
    public boolean getPassowrd(String username, String securityQuestion, String securityQuestionAnswer) {
        return false;
    }

    @Override
    public boolean getPasswordThroughEmail(String email) {
        return false;
    }

    @Override
    public void setDefaultLocation(Location location) {
        account.getAccountSettings().setDefaultLocation(location);

    }

    @Override
    public void setDefaultPaymentCard(String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber) {
        account.getAccountSettings().setDefaultPaymentCard(cardHolderName,cardNumber,cardExpirationDate,securityNumber);

    }

    @Override
    public void setDefaultBankAccount(String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode) {
        account.getAccountSettings().setDefaultBankAccount(bankName,routingNumber,accountType,billingAddress,swiftCode);
    }

    @Override
    public boolean logInToAccount(String username, String password) {
        return false;
    }

    @Override
    public boolean logInToAccountWithEmail(String email, String password) {
        return false;
    }

    @Override
    public boolean ReactivateAccount(String oldUsername, String oldPassword) {
        return false;
    }


}
