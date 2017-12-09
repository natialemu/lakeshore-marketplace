package Service.Workflow.Account;

import Service.Representation.Account.Representation.AccountRepresentation;
import Service.Representation.Account.Representation.AccountRepresentationImpl;
import Service.Representation.Account.Representation.AccountValidationRepresentation;
import Service.Representation.Account.Representation.AccountValidationRepresentationImpl;
import Service.Representation.Account.Request.AccountRequest;
import Service.Representation.Account.Request.AccountRequestImpl;

public interface AccountActivity {

	void deleteAccount(String username, String passowrd);

	AccountRepresentation getAccount(String username, String password);

	void updateAccount(String oldUsername, String newUsername, String oldPassowrd, String newPassword);

	void updatePassword(String username, String oldPassword, String newPassword);

	void updateUsername(String oldUsername, String newUnsername);

	boolean loginWithUsername(String username, String password);

	AccountValidationRepresentationImpl registerCustomerForAccountWithEmail(AccountRequestImpl accountRequest);

	void regsiterCustomerForAccount(String username, String password);

	void registerPartnerForAccount(String username, String password);

	AccountValidationRepresentationImpl registerPartnerForAccountWithEmail(String username, String email, String password);

	AccountValidationRepresentationImpl loginWithEmail(String email, String password);

	AccountRepresentationImpl getAccount(String username);

	void deleteAccount(String username);

	AccountValidationRepresentationImpl loginPartnerWithEmail(String email, String password);

}
