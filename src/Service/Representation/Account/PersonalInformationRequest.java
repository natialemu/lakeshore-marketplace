package Service.Representation.Account;

public interface PersonalInformationRequest {
	String getBirthDate();

	void setBirthDate(String birthDate);

	String getFullName();

	void setFullName(String fullName);

	String getCellPhone();

	void setCellPhone(String cellPhone);
}