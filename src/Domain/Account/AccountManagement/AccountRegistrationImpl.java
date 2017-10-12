package Domain.Account.AccountManagement;

import Domain.Account.Account;
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
    public boolean createBasicAccount(Account account) {
        int account_id = account.getAccountID();
        int account_settings_id = account.getAccountSettings().getAccountSettingsID();
        int fin_profile_id = account.getAccountProfile().getFinancialInfo().getFinancialInfoID();

        return accountDAO.createBasicAccount(account.getAccountProfile().getUsername(),account.getAccountProfile().getContactInfo().getEmail(), account.getAccountProfile().getPassword(),account_id,account_settings_id,fin_profile_id);
    }

    @Override
    public boolean createAccountContactProfile(String username,String email, String fullName, Location location, String dateOfBirth, String securityQuestion, String securityQuestionAnswer) {
        return accountDAO.createAccountContactProfile(username,email,fullName,location,dateOfBirth,securityQuestion,securityQuestionAnswer);
    }

    @Override
    public boolean createAccountFinancialProfile(String username, String accountNumber, String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode) {
        return accountDAO.createAccountFinancialProfile(username, accountNumber, bankName,routingNumber,accountType,billingAddress,swiftCode);
    }

    @Override
    public boolean createPaymentCardProfile(String accountNumber, String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber) {
        return accountDAO.createPaymentCardProfile(accountNumber, cardHolderName,cardNumber,cardExpirationDate,securityNumber);
    }
}
