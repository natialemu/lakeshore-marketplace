package Service.Representation.Account;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "User Information")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class PersonalInformationRequestImpl implements PersonalInformationRequest {
	private String birthDate;
	private String fullName;
	private String cellPhone;
	
	public PersonalInformationRequestImpl() {}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
}