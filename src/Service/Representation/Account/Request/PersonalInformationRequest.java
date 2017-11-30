package Service.Representation.Account.Request;

public interface PersonalInformationRequest {
	void setBirthDate(String birthDate);
	void setFullName(String fullName);
	void setStreetAddress(String streetAddress);
	void setZipcode(String zipcode);
	void setCity(String city);
	void setState(String state);
	void setCellPhone(String cellPhone);
	
	String getBirthDate();
	String getFullName();
	String getStreetAddress();
	String getZipcode();
	String getCity();
	String getState();
	String getCellPhone();
}