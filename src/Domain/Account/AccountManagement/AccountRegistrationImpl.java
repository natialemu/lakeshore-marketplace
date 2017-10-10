package Domain.Account.AccountManagement;

import Domain.Account.AccountProfile.Contact.Location;
import Domain.Tools.IDGenerator;
import Repository.Account.AccountDAO;
import Repository.Account.AccountDAOImpl;

public class AccountRegistrationImpl implements AccountRegistration{

    private AccountDAO accountDAO;

    public AccountRegistrationImpl(){
        accountDAO = new AccountDAOImpl();
    }
    @Override
    public boolean createBasicAccount(String username, String email, String password) {
        int account_id = IDGenerator.getId();
        int account_settings_id = IDGenerator.getId();
        int fin_profile_id = IDGenerator.getId();

        return accountDAO.createBasicAccount(username,email, password,account_id,account_settings_id,fin_profile_id);
    }

    @Override
    public boolean createAccountContactProfile(String email, String fullName, Location location, String dateOfBirth, String securityQuestion, String securityQuestionAnswer) {
        return accountDAO.createAccountContactProfile(email,fullName,location,dateOfBirth,securityQuestion,securityQuestionAnswer);
    }

    @Override
    public boolean createAccountFinancialProfile(String accountNumber, String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode) {
        return accountDAO.createAccountFinancialProfile(accountNumber, bankName,routingNumber,accountType,billingAddress,swiftCode);
    }

    @Override
    public boolean createPaymentCardProfile(String accountNumber, String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber) {
        return accountDAO.createPaymentCardProfile(accountNumber, cardHolderName,cardNumber,cardExpirationDate,securityNumber);
    }
}
