package Domain.Account.AccountManagement;

import Repository.Account.AccountDAO;

public class AccountValidationImpl implements AccountValidation{
    private AccountDAO accountDAO;

    @Override
    public boolean logInToAccount(String username, String password) {
        return false;
    }

    @Override
    public boolean logInToAccountWithEmail(String email, String password) {
        return false;
    }

    @Override
    public boolean validateAccount(String username, String password) {
        return false;
    }

    @Override
    public boolean validateAccountWithEmail(String email, String password) {
        return false;
    }
}
