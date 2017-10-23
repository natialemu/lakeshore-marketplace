package Service.Representation.Account;

public interface AccountRepresentation {
	
	void setUsername(String username);
	void setAccountStatus(String accountStatus);
	void setEmailAddress(String emailAddress);
	String getEmailAddress();
	String getUsername();
	String getAccountStatus();
	

}
