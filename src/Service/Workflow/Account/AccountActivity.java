package Service.Workflow.Account;

import Service.Representation.Account.AccountRepresentation;

public interface AccountActivity {

	void deleteAccount(String username, String passowrd);

	AccountRepresentation getAccount();

	void updateAccount(String oldUsername, String newUsername, String oldPassowrd, String newPassword);

	void updatePassword(String oldPassword, String newPassword);

	void updateUsername(String oldUsername, String newUnsername);

	boolean loginWithUsername(String username, String password);

	void registerCustomerForAccountWithEmail(String username, String email, String password);

	void regsiterCustomerForAccount(String username, String password);

	void registerPartnerForAccount(String username, String password);

	void registerPartnerForAccountWithEmail(String username, String email, String password);

}
