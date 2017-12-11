package Service.Representation.Account.Request;

public interface BasicBankInfoRequest {

	String getBankName();

	void setBankName(String bankName);

	String getAccountType();

	void setAccountType(String accountType);

	String getAccountNumber();

	void setAccountNumber(String accountNumber);

	String getRoutingNumber();

	void setRoutingNumber(String routingNumber);

}
