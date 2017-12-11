package Service.Resource.Account;

import javax.jws.WebService;


import Service.Representation.Account.Representation.AccountValidationRepresentation;
import Service.Representation.Account.Representation.AccountValidationRepresentationImpl;
import Service.Representation.Account.Representation.PersonalInformationRepresentation;
import Service.Representation.Account.Representation.PersonalInformationRepresentationImpl;
import Service.Representation.Account.Request.BasicAccountRequest;
import Service.Representation.Account.Request.PersonalInformationRequest;
import Service.Representation.Account.Request.PersonalInformationRequestImpl;

@WebService
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
	PersonalInformationRepresentationImpl getPersonalInformation(String username);
	
	
	//DElETE
	void removeEmail(String newEmail);
	void removeFullName(String email, String FullName);
	void removeBirthDate(String email, String birthDate);
	void removeLocation(String email, int zipcode, String streetAddress, String city, String country, String state);
	void removePhone(String email, int areacode, int countrycode, int phoneNumber, int phoneType);
	
	
	void removesecurityQuestion(String email, String newSecurityQuestion);
	void removesecurityAnswer(String email, String newSecurityQuestionAnswer);
	
	
	
	//CREATE
	
	AccountValidationRepresentationImpl createPersonalInformation(String username, PersonalInformationRequestImpl personalInformation);
	
	//UPDATE
	AccountValidationRepresentationImpl updatePersonalInformation(String username, PersonalInformationRequestImpl personalInformation);
	

}
