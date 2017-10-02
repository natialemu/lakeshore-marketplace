package Domain.Account.AccountManagement;

public interface AccountDeletion {
    //Deleting An account
    boolean deleteAccount(int accountID);
    boolean deleteAccountAccount(String email, String password);
    boolean deleteAccountWithUsername(String username, String password);

}
