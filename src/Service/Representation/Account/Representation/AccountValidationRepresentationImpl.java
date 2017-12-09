package Service.Representation.Account.Representation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import Service.Representation.AbstractRepresentation;
import Service.Representation.LinkImpl;

@XmlRootElement(name ="AccountValidation")
@XmlSeeAlso(LinkImpl.class)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class AccountValidationRepresentationImpl extends AbstractRepresentation implements AccountValidationRepresentation{

	private boolean isSuccessful;
	
	public AccountValidationRepresentationImpl() {}
	
	public void setIsSuccessful(boolean isSuccessful) {
		this.isSuccessful = isSuccessful;
	}
	
	public boolean getIsSuccessful() {
		return isSuccessful;
	}
}
