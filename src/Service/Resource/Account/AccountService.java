package Service.Resource.Account;

import Service.Representation.Account.AccountRepresentation;

public interface AccountService {
	
	void registerAccount(String username, String password);
	void registerAccount(String username, String email, String password);
	
	boolean loginWithEmail(String email, String password);
	boolean loginWithUsername(String username, String password);
	
	
	void updateUsername(String oldUsername, String newUnsername);
	void updatePassword(String oldPassword, String newPassword);
	void updateAccount(String oldUsername, String newUsername, String oldPassowrd, String newPassword);
	
	AccountRepresentation getAccount();
	
	void deleteAccount(String username, String passowrd);
	
	

}
