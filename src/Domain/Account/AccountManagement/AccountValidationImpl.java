package Domain.Account.AccountManagement;

import Domain.Account.Account;
import Repository.Account.AccountDAO;

public class AccountValidationImpl implements AccountValidation{
    private AccountDAO accountDAO;

    @Override
    public boolean logInToAccount(String username, String password) {
        return accountDAO.logIntoAccount(username,password);
    }

    @Override
    public boolean logInToAccountWithEmail(String email, String password) {
        return accountDAO.logIntoAccountWithEmail(email,password);
    }

    @Override
    public boolean validateAccount(String username, String password) {
        return accountDAO.validateAccount(username,password);
    }

    @Override
    public boolean validateAccountWithEmail(String email, String password) {
        return accountDAO.validateAccountWithEmail(email,password);
    }

    @Override
    public Account getAccount(String username) {
        return accountDAO.getAccount(username);
    }

    @Override
    public Account getAccountWithEmail(String email) {
        return accountDAO.getAccountWithEmail(email);
    }

    @Override
    public boolean getPassword(String username, String securityQuestion, String securityQuestionAnswer) {
        return accountDAO.getPassword(username,securityQuestion,securityQuestionAnswer);
    }

    @Override
    public boolean getPasswordThroughEmail(String email) {
        return accountDAO.getPasswordThroughEmail(email);
    }
}
