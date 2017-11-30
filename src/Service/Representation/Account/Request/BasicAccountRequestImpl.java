package Service.Representation.Account.Request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class BasicAccountRequestImpl implements BasicAccountRequest{
	
	private String username;
	private String password;
	private boolean isCustomer;
	
	public BasicAccountRequestImpl() {}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

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
