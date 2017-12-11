package Service.Workflow.Account;

import Service.Representation.Account.Representation.AccountValidationRepresentation;
import Service.Representation.Account.Representation.AccountValidationRepresentationImpl;
import Service.Representation.Account.Representation.PersonalInformationRepresentation;
import Service.Representation.Account.Representation.PersonalInformationRepresentationImpl;
import Service.Representation.Account.Request.BasicAccountRequest;
import Service.Representation.Account.Request.PersonalInformationRequest;
import Service.Representation.Account.Request.PersonalInformationRequestImpl;

public interface PersonalInfoActivity {

	AccountValidationRepresentationImpl createPersonalInformation(String username, PersonalInformationRequestImpl personalInformation);

	void removesecurityAnswer(String email, String newSecurityQuestionAnswer);

	void removesecurityQuestion(String email, String newSecurityQuestion);

	void removePhone(String email, int areacode, int countrycode, int phoneNumber, int phoneType);

	void removeLocation(String email, int zipcode, String streetAddress, String city, String country, String state);

	void removeBirthDate(String email, String birthDate);

	void removeFullName(String email, String fullName);

	void removeEmail(String newEmail);

	PersonalInformationRepresentationImpl getPersonalInformation(String username);

	void updateEmail(String email, String newSecurityQuestionAnswer);

	void updatePhone(String email, int areacode, int countrycode, int phoneNumber, int phoneType);

	void updateLocation(String email, int zipcode, String streetAddress, String city, String country, String state);

	void updateBirthDate(String email, String birthDate);

	void updateFullName(String email, String newFullName);

	AccountValidationRepresentationImpl updatePersonalInformation(String username,
			PersonalInformationRequestImpl personalInformation);

}
