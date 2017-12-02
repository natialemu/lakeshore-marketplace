package Service.Resource.Account;

import javax.jws.WebService;

import Service.Representation.Account.Representation.AccountRepresentation;
import Service.Representation.Account.Representation.AccountValidationRepresentation;
import Service.Representation.Account.Request.AccountRequest;
import Service.Representation.Account.Request.BasicAccountRequest;
import Service.Representation.Account.Request.BasicEmailAccountRequest;
@WebService
public interface AccountService {
	
	AccountValidationRepresentation registerForAccount(String username, String password);
	AccountValidationRepresentation registerForAccountWithEmail(AccountRequest accountRequest);

	AccountValidationRepresentation loginWithEmail(BasicEmailAccountRequest basicEmailAccountRequest);
	AccountValidationRepresentation loginWithUsername(BasicAccountRequest basicAccountRequest);
	
	
	void updateUsername(String oldUsername, String newUnsername);
	void updatePassword(String username, String oldPassword, String newPassword);
	void updateAccount(String oldUsername, String newUsername, String oldPassowrd, String newPassword);
	
	AccountRepresentation getAccount(String username);
	
	void deleteAccount(String username);
	
	

}
