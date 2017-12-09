package Service.Representation.Account.Representation;

import Service.Representation.AbstractRepresentationInterface;

public interface AccountRepresentation extends AbstractRepresentationInterface{
	
	void setUsername(String username);
	void setAccountStatus(String accountStatus);
	void setEmailAddress(String emailAddress);
	String getEmailAddress();
	String getUsername();
	String getAccountStatus();
	String getPassword();
	void setPassword(String password);
	

}
