package Service.Representation.Account.Request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class BasicBankInfoRequestImpl implements BasicBankInfoRequest {
	private String bankName;
	private String accountType;
	private String accountNumber;
	private String routingNumber;
	
	
	
	@Override
	public String getBankName() {
		return bankName;
	}



	@Override
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}



	@Override
	public String getAccountType() {
		return accountType;
	}



	@Override
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}



	@Override
	public String getAccountNumber() {
		return accountNumber;
	}



	@Override
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}



	@Override
	public String getRoutingNumber() {
		return routingNumber;
	}



	@Override
	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}



	public BasicBankInfoRequestImpl() {}
	
	

}
