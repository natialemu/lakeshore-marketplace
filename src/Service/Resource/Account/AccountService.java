package Service.Resource.Account;

import javax.jws.WebService;

import Service.Representation.Account.Representation.AccountRepresentation;
import Service.Representation.Account.Request.AccountRequest;
import Service.Representation.Account.Request.BasicAccountRequest;
import Service.Representation.Account.Request.BasicEmailAccountRequest;
@WebService
public interface AccountService {
	
	void registerForAccount(String username, String password);
	void registerForAccountWithEmail(AccountRequest accountRequest);

	boolean loginWithEmail(BasicEmailAccountRequest basicEmailAccountRequest);
	boolean loginWithUsername(BasicAccountRequest basicAccountRequest);
	
	
	void updateUsername(String oldUsername, String newUnsername);
	void updatePassword(String username, String oldPassword, String newPassword);
	void updateAccount(String oldUsername, String newUsername, String oldPassowrd, String newPassword);
	
	AccountRepresentation getAccount(String username);
	
	void deleteAccount(String username);
	
	

}
