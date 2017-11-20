package Service.Resource.Account;

import javax.jws.WebService;

import Service.Representation.Account.BasicAccountRequest;
import Service.Representation.Account.Representation.AccountRepresentation;
import Service.Representation.Account.Request.AccountRequest;
@WebService
public interface AccountService {
	
	void registerForAccount(String username, String password);
	void registerForAccountWithEmail(AccountRequest accountRequest);

	boolean loginWithEmail(String email, String password);
	boolean loginWithUsername(BasicAccountRequest basicAccountRequest);
	
	
	void updateUsername(String oldUsername, String newUnsername);
	void updatePassword(String username, String oldPassword, String newPassword);
	void updateAccount(String oldUsername, String newUsername, String oldPassowrd, String newPassword);
	
	//AccountRepresentation getAccount(String username, String password);
	
	void deleteAccount(String username, String passowrd);
	
	

}
