package Service.Representation.Account.Representation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import Service.Representation.AbstractRepresentation;

@XmlRootElement(name = "Account")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class AccountRepresentationImpl extends AbstractRepresentation implements AccountRepresentation{
	
	private String username;
	private String accountStatus;
	private String emailAddress;
	
	public AccountRepresentationImpl() {}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	

	
}
