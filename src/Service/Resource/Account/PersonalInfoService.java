package Service.Resource.Account;

import Service.Representation.Account.PersonalInformationRepresentation;
import Service.Representation.Account.PersonalInformationRequest;

public interface PersonalInfoService {
	
	//Update
	void updateEmail(String oldEmail, String newEmail);
	void updateFullName(String email, String newFullName);
	void updateBirthDate(String email, String birthDate);
	void updateLocation(String email, int zipcode, String streetAddress, String city, String country, String state);
	void updatePhone(String email, int areacode, int countrycode, int phoneNumber, int phoneType);
	
	
	void updateSecurityQuestion(String email, String newSecurityQuestion);
	void updateSecurityAnswer(String email, String newSecurityQuestionAnswer);
	
	//GET
	PersonalInformationRepresentation getPersonalInformation();
	
	
	//DElETE
	void removeEmail(String newEmail);
	void removeFullName(String email, String FullName);
	void removeBirthDate(String email, String birthDate);
	void removeLocation(String email, int zipcode, String streetAddress, String city, String country, String state);
	void removePhone(String email, int areacode, int countrycode, int phoneNumber, int phoneType);
	
	
	void removesecurityQuestion(String email, String newSecurityQuestion);
	void removesecurityAnswer(String email, String newSecurityQuestionAnswer);
	
	
	
	//CREATE
	
	void createPersonalInformation(PersonalInformationRequest personalInformation);
	

}
