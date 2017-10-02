package Domain.Account.AccountManagement;

import Repository.Account.AccountDAO;
import Repository.Account.AccountDAOImpl;

public class AccountDeletionImpl implements AccountDeletion{
    AccountDAO accountDAO;

    public AccountDeletionImpl(){
        accountDAO = new AccountDAOImpl();
    }
    @Override
    public boolean deleteAccount(int accountID) {

        return accountDAO.deleteAccount(accountID);
    }

    @Override
    public boolean deleteAccountAccount(String email, String password) {
        return accountDAO.deleteAccountAccount(email,password);
    }

    @Override
    public boolean deleteAccountWithUsername(String username, String password) {
        return accountDAO.deleteAccountWithUsername(username,password);
    }
}
