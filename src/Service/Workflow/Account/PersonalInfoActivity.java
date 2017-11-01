package Service.Workflow.Account;

import Service.Representation.Account.BasicAccountRequest;
import Service.Representation.Account.PersonalInformationRepresentation;
import Service.Representation.Account.PersonalInformationRequest;

public interface PersonalInfoActivity {

	void createPersonalInformation(PersonalInformationRequest personalInformation);

	void removesecurityAnswer(String email, String newSecurityQuestionAnswer);

	void removesecurityQuestion(String email, String newSecurityQuestion);

	void removePhone(String email, int areacode, int countrycode, int phoneNumber, int phoneType);

	void removeLocation(String email, int zipcode, String streetAddress, String city, String country, String state);

	void removeBirthDate(String email, String birthDate);

	void removeFullName(String email, String fullName);

	void removeEmail(String newEmail);

	PersonalInformationRepresentation getPersonalInformation(BasicAccountRequest basicAccountRequest);

	void updateEmail(String email, String newSecurityQuestionAnswer);

	void updatePhone(String email, int areacode, int countrycode, int phoneNumber, int phoneType);

	void updateLocation(String email, int zipcode, String streetAddress, String city, String country, String state);

	void updateBirthDate(String email, String birthDate);

	void updateFullName(String email, String newFullName);

}
