package Domain.Account.AccountManagement;

import Domain.Account.AccountProfile.Contact.Location;
import Repository.Account.AccountDAO;
import Repository.Account.AccountDAOImpl;

public class AccountUpdateImpl implements AccountUpdate {
    private AccountDAO accountDAO;

    public AccountUpdateImpl(){
        accountDAO = new AccountDAOImpl();
    }

    @Override
    public boolean updateUserName(String username) {
        return accountDAO.updateUserName(username);
    }

    @Override
    public boolean updatePassword(String username, String password) {
        return accountDAO.updatePassword(username,password);
    }

    @Override
    public boolean updateDateOfBirth(String dateOfBirth) {
        //TODO: will need username to identify account
        return false;
    }

    @Override
    public boolean updateEmail(String email) {

        return accountDAO.updateEmail(email);
    }

    @Override
    public boolean updatePaymentCard(String cardNumber, String expirationDate, String cardHolderName, int securityCode) {
        return accountDAO.updatePaymentCard(cardNumber,expirationDate,cardHolderName,securityCode);
    }

    @Override
    public boolean updateBankInformation(String bankName, String accountNumber, String routingNumber) {

        return accountDAO.updateBankInformation(bankName,accountNumber,routingNumber);
    }

    @Override
    public boolean updateAddress(String streetAddress, String state, String city, int zipcode, String country, int pobox) {
        return accountDAO.updateAddress(streetAddress,state,city,zipcode,country,pobox);
    }

    @Override
    public boolean activateStatusOfAccount(String oldUsername, String oldPassword) {
        return accountDAO.activateStatusOfAccount(oldUsername,oldPassword);
    }

    @Override
    public void setDefaultBankAccount(String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode) {

        accountDAO.setDefaultBankAccount(bankName,routingNumber,accountType,billingAddress,swiftCode);
    }

    @Override
    public void setDefaultLocation(Location location) {

        accountDAO.setDefaultLocation(location);

    }

    @Override
    public void setDefaultPaymentCard(String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber) {

        accountDAO.setDefaultPaymentCard(cardHolderName,cardNumber,cardExpirationDate,securityNumber);
    }
}
