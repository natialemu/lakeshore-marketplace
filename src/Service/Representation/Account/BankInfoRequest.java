package Service.Representation.Account;


public interface BankInfoRequest {
	String getCardNumber();

	void setCardNumber(String cardNumber);

	String getNameOnCard();

	void setNameOnCard(String nameOnCard);

	String getCardExpirationDate();

	void setCardExpirationDate(String cardExpirationDate);

	String getCardSecurityCode();

	void setCardSecurityCode(String cardSecurityCode);
}
