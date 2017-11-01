package Service.Resource.Account;

import Service.Representation.Account.AccountRepresentation;

public interface AccountService {
	
	void registerCustomerForAccount(String username, String password);
	void registerCustomerForAccountWithEmail(String username, String email, String password);
	
	void registerPartnerForAccount(String username, String password);
	void registerPartnerForAccountWithEmail(String username, String email, String password);
	
	boolean loginWithEmail(String email, String password);
	boolean loginWithUsername(String username, String password);
	
	
	void updateUsername(String oldUsername, String newUnsername);
	void updatePassword(String username, String oldPassword, String newPassword);
	void updateAccount(String oldUsername, String newUsername, String oldPassowrd, String newPassword);
	
	AccountRepresentation getAccount(String username, String password);
	
	void deleteAccount(String username, String passowrd);
	
	

}
