package Service.Resource.Account;

import javax.jws.WebService;

import Service.Representation.Account.AccountRepresentation;
import Service.Representation.Account.AccountRequest;
import Service.Representation.Account.BasicAccountRequest;
@WebService
public interface AccountService {
	
	void registerCustomerForAccount(String username, String password);
	void registerCustomerForAccountWithEmail(AccountRequest accountRequest);
	
	void registerPartnerForAccount(String username, String password);
	void registerPartnerForAccountWithEmail(AccountRequest accountRequest);
	
	boolean loginWithEmail(String email, String password);
	boolean loginWithUsername(BasicAccountRequest basicAccountRequest);
	
	
	void updateUsername(String oldUsername, String newUnsername);
	void updatePassword(String username, String oldPassword, String newPassword);
	void updateAccount(String oldUsername, String newUsername, String oldPassowrd, String newPassword);
	
	AccountRepresentation getAccount(String username, String password);
	
	void deleteAccount(String username, String passowrd);
	
	

}
