package Domain.Account.AccountManagement;

public interface AccountValidation {
    //Login to Account
    boolean logInToAccount(String username, String password);
    boolean logInToAccountWithEmail(String email, String password);

    boolean validateAccount(String username, String password);

    boolean validateAccountWithEmail(String email, String password);
}
