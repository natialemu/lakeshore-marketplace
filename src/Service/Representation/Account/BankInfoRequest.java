package Service.Representation.Account;


public interface BankInfoRequest {
	void setCardSecurityCode(String cardSecurityCode);
	void setCardExpirationDate(String cardExpirationDate);
	void setNameOnCard(String nameOnCard);
	void setCardNumber(String cardNumber);
	void setBillingZipcode(String billingZipcode);
	void setBillingState(String billingState);
	void setBillingCity(String billingCity);
	void setBillingStreetAddress(String billingStreetAddress);
	void setAccountNumber(String accountNumber);
	void setAccountType(String accountType);
	void setBankName(String bankName);
	
	String getCardSecurityCode();
	String getCardExpirationDate();
	String getNameOnCard();
	String getCardNumber();
	String getBillingZipcode();
	String getBillingState();
	String getBillingCity();
	String getBillingStreetAddress();
	String getAccountNumber();
	String getAccountType();
	String getBankName();
}
