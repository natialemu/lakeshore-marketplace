package Service.Representation.Account.Request;

public interface BasicAccountRequest {
	String getUsername();
	void setUsername(String username);
	String getPassword();
	void setPassword(String password);
    void setIsCustomer(boolean isCustomer);
	boolean getIsCustomer();

}
