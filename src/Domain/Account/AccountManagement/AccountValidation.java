package Domain.Account.AccountManagement;

import Domain.Account.Account;

public interface AccountValidation {
    //Login to Account
    boolean logInToAccount(String username, String password);
    boolean logInToAccountWithEmail(String email, String password);

    boolean validateAccount(String username, String password);

    boolean validateAccountWithEmail(String email, String password);

    Account getAccount(String username);

    Account getAccountWithEmail(String email);

    boolean getPassword(String username, String securityQuestion, String securityQuestionAnswer);

    boolean getPasswordThroughEmail(String email);
}
