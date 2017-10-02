package Domain.Account.AccountManagement;

import Repository.Account.AccountDAO;

public class AccountDeletionImpl implements AccountDeletion{
    AccountDAO accountDAO;

    @Override
    public boolean deleteAccount(int accountID) {
        return false;
    }

    @Override
    public boolean deleteAccountAccount(String email, String password) {
        return false;
    }

    @Override
    public boolean deleteAccountWithUsername(String username, String password) {
        return false;
    }
}
