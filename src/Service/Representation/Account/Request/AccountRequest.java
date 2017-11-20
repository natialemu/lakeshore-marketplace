package Service.Representation.Account.Request;

public interface AccountRequest {

	String getUsername();

	void setUsername(String username);

	String getPassword();

	void setPassword(String password); 

	String getEmail();

	void setEmail(String email);
	
	void setIsCustomer(boolean isCustomer);
	
	boolean getIsCustomer();
}
