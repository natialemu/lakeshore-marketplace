package Service.Representation.Account.Request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class AccountRequestImpl implements AccountRequest {
	private String username;
	private String password;
	private String email;
	private boolean isCustomer;
	
	public AccountRequestImpl() {}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void setIsCustomer(boolean isCustomer) {
		// TODO Auto-generated method stub
		this.isCustomer = isCustomer;
		
	}

	@Override
	public boolean getIsCustomer() {
		// TODO Auto-generated method stub
		return isCustomer;
	}
	
	
	

}
