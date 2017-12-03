package Service.Workflow.Account;

import Service.Representation.Account.Representation.AccountRepresentation;
import Service.Representation.Account.Representation.AccountValidationRepresentation;
import Service.Representation.Account.Request.AccountRequest;

public interface AccountActivity {

	void deleteAccount(String username, String passowrd);

	AccountRepresentation getAccount(String username, String password);

	void updateAccount(String oldUsername, String newUsername, String oldPassowrd, String newPassword);

	void updatePassword(String username, String oldPassword, String newPassword);

	void updateUsername(String oldUsername, String newUnsername);

	boolean loginWithUsername(String username, String password);

	AccountValidationRepresentation registerCustomerForAccountWithEmail(AccountRequest accountRequest);

	void regsiterCustomerForAccount(String username, String password);

	void registerPartnerForAccount(String username, String password);

	AccountValidationRepresentation registerPartnerForAccountWithEmail(String username, String email, String password);

	AccountValidationRepresentation loginWithEmail(String email, String password);

	AccountRepresentation getAccount(String username);

	void deleteAccount(String username);

	AccountValidationRepresentation loginPartnerWithEmail(String email, String password);

}
