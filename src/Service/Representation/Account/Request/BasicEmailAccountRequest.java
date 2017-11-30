package Service.Representation.Account.Request;

public interface BasicEmailAccountRequest {
	
	String getEmail();
	void setEmail(String email);
	String getPassword();
	void setPassword(String password);
    void setIsCustomer(boolean isCustomer);
	boolean getIsCustomer();
	

}
