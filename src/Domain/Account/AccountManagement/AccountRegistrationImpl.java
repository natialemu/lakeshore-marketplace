package Domain.Account.AccountManagement;

import Domain.Account.AccountProfile.Contact.Location;
import Repository.Account.AccountDAO;
import Repository.Account.AccountDAOImpl;

public class AccountRegistrationImpl implements AccountRegistration{

    private AccountDAO accountDAO;

    public AccountRegistrationImpl(){
        accountDAO = new AccountDAOImpl();
    }
    @Override
    public boolean createBasicAccount(String username, String password) {
        return accountDAO.createBasicAccount(username,password);
    }

    @Override
    public boolean createAccountContactProfile(String email, String fullName, Location location, String dateOfBirth, String securityQuestion, String securityQuestionAnswer) {
        return accountDAO.createAccountContactProfile(email,fullName,location,dateOfBirth,securityQuestion,securityQuestionAnswer);
    }

    @Override
    public boolean createAccountFinancialProfile(String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode) {
        return accountDAO.createAccountFinancialProfile(bankName,routingNumber,accountType,billingAddress,swiftCode);
    }

    @Override
    public boolean createPaymentCardProfile(String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber) {
        return accountDAO.createPaymentCardProfile(cardHolderName,cardNumber,cardExpirationDate,securityNumber);
    }
}
