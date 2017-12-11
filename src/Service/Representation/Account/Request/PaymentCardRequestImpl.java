package Service.Representation.Account.Request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class PaymentCardRequestImpl implements PaymentCardRequest{
	private String billingStreetAddress;
	private String billingCity;
	private String billingState;
	private String billingZipcode;
	private String cardNumber;
	private String nameOnCard;
	private String cardExpirationDate;
	private String cardSecurityCode;
	
	public PaymentCardRequestImpl() {}
	
	@Override
	public String getBillingStreetAddress() {
		return billingStreetAddress;
	}
	@Override
	public void setBillingStreetAddress(String billingStreetAddress) {
		this.billingStreetAddress = billingStreetAddress;
	}
	
	@Override
	public String getBillingCity() {
		return billingCity;
	}
	
	@Override
	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}
	
	@Override
	public String getBillingState() {
		return billingState;
	}
	
	@Override
	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}
	
	@Override
	public String getBillingZipcode() {
		return billingZipcode;
	}
	
	@Override
	public void setBillingZipcode(String billingZipcode) {
		this.billingZipcode = billingZipcode;
	}
	
	@Override
	public String getCardNumber() {
		return cardNumber;
	}
	
	@Override
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	@Override
	public String getNameOnCard() {
		return nameOnCard;
	}
	
	@Override
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	
	@Override
	public String getCardExpirationDate() {
		return cardExpirationDate;
	}
	
	@Override
	public void setCardExpirationDate(String cardExpirationDate) {
		this.cardExpirationDate = cardExpirationDate;
	}
	
	@Override
	public String getCardSecurityCode() {
		return cardSecurityCode;
	}
	
	@Override
	public void setCardSecurityCode(String cardSecurityCode) {
		this.cardSecurityCode = cardSecurityCode;
	}
	
	

}
