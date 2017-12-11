package Service.Representation.Account.Request;

public interface PaymentCardRequest {

	String getBillingStreetAddress();

	void setBillingStreetAddress(String billingStreetAddress);

	String getBillingCity();

	void setBillingCity(String billingCity);

	String getBillingState();

	void setBillingState(String billingState);

	String getBillingZipcode();

	void setBillingZipcode(String billingZipcode);

	String getCardNumber();

	void setCardNumber(String cardNumber);

	String getNameOnCard();

	void setNameOnCard(String nameOnCard);

	String getCardExpirationDate();

	void setCardExpirationDate(String cardExpirationDate);

	String getCardSecurityCode();

	void setCardSecurityCode(String cardSecurityCode);

}
