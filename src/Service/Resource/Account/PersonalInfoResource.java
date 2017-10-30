package Service.Resource.Account;

import Service.Representation.Account.PersonalInformationRepresentation;
import Service.Representation.Account.PersonalInformationRequest;

public class PersonalInfoResource implements PersonalInfoService {

	@Override
	public void updateEmail(String oldEmail, String newEmail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateFullName(String email, String newFullName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBirthDate(String email, String birthDate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateLocation(String email, int zipcode, String streetAddress, String city, String country,
			String state) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePhone(String email, int areacode, int countrycode, int phoneNumber, int phoneType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void securityQuestion(String email, String newSecurityQuestion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void securityAnswer(String email, String newSecurityQuestionAnswer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PersonalInformationRepresentation getPersonalInformation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeEmail(String newEmail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeFullName(String email, String FullName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeBirthDate(String email, String birthDate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeLocation(String email, int zipcode, String streetAddress, String city, String country,
			String state) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePhone(String email, int areacode, int countrycode, int phoneNumber, int phoneType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removesecurityQuestion(String email, String newSecurityQuestion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removesecurityAnswer(String email, String newSecurityQuestionAnswer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createPersonalInformation(PersonalInformationRequest personalInformation) {
		// TODO Auto-generated method stub
		
	}

}
