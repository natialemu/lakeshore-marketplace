package Service.Representation.Account.Request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class BasicEmailAccountRequestImpl implements BasicEmailAccountRequest {

	private String email;
	private String password;
	private boolean isCustomer;
	
	public BasicEmailAccountRequestImpl() {}
	@Override
	public String getEmail() {

		return email;
	}

	@Override
	public void setEmail(String email) {


		this.email = email;
		
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {

		this.password = password;
	}

	@Override
	public void setIsCustomer(boolean isCustomer) {

		this.isCustomer = isCustomer;
	}

	@Override
	public boolean getIsCustomer() {
		return isCustomer;
	}

}
