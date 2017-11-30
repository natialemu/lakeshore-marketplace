package Service.Workflow.Account;

import Domain.Account.Account;
import Domain.Account.AccountFactory;
import Domain.Account.AccountFactoryImpl;
import Service.Representation.Account.Representation.PersonalInformationRepresentation;
import Service.Representation.Account.Representation.PersonalInformationRepresentationImpl;
import Service.Representation.Account.Request.BasicAccountRequest;
import Service.Representation.Account.Request.PersonalInformationRequest;

public class PersonalInfoActivityImpl implements PersonalInfoActivity {
	private AccountFactory accountFactory;
	
	public PersonalInfoActivityImpl() {
		accountFactory = new AccountFactoryImpl();
	}

	@Override
	public void createPersonalInformation(String username, PersonalInformationRequest personalInformation) {
		// TODO Auto-generated method stub
		
		accountFactory.createPersonalInformation(username,personalInformation.getBirthDate(),personalInformation.getCellPhone(),personalInformation.getFullName(),personalInformation.getCity(),personalInformation.getFullName(),personalInformation.getState(),personalInformation.getStreetAddress(),personalInformation.getZipcode());
		
	}

	@Override
	public void removesecurityAnswer(String email, String newSecurityQuestionAnswer) {
		// TODO Auto-generated method stub
		accountFactory.removeSecurityAnswer(email,newSecurityQuestionAnswer);
		
	}

	@Override
	public void removesecurityQuestion(String email, String newSecurityQuestion) {
		// TODO Auto-generated method stub
		accountFactory.removesecurityQuestion(email,newSecurityQuestion);
		
	}

	@Override
	public void removePhone(String email, int areacode, int countrycode, int phoneNumber, int phoneType) {
		// TODO Auto-generated method stub
		accountFactory.removePhone(email,areacode,countrycode,phoneNumber,phoneType);
		
	}

	@Override
	public void removeLocation(String email, int zipcode, String streetAddress, String city, String country,
			String state) {
		// TODO Auto-generated method stub
		accountFactory.removeLocation(email,streetAddress, state, city, zipcode, country);
		
	}

	@Override
	public void removeBirthDate(String email, String birthDate) {
		// TODO Auto-generated method stub
		accountFactory.removeBirthDate(email,birthDate);
	}

	@Override
	public void removeFullName(String email, String fullName) {
		// TODO Auto-generated method stub
		accountFactory.removeFullName(email,fullName);
	}

	@Override
	public void removeEmail(String newEmail) {
		// TODO Auto-generated method stub
		accountFactory.removeEmail(newEmail);
	}

	@Override
	public PersonalInformationRepresentation getPersonalInformation(BasicAccountRequest basicAccountRequest) {
		// TODO Auto-generated method stub
		Account account = accountFactory.getAccount(basicAccountRequest.getUsername(), basicAccountRequest.getPassword());
		PersonalInformationRepresentation pir = new PersonalInformationRepresentationImpl();
		
		pir.setBirthDate(account.getAccountProfile().getContactInfo().getBirthDate());
		pir.setCellPhone(account.getAccountProfile().getContactInfo().getPhone().getCellularPhone());
		pir.setCity(account.getAccountProfile().getContactInfo().getLocation().getCity());
		pir.setFullName(account.getAccountProfile().getContactInfo().getFullName());
		pir.setState(account.getAccountProfile().getContactInfo().getLocation().getState());
		pir.setStreetAddress(account.getAccountProfile().getContactInfo().getLocation().getStreetAddress());
		pir.setZipcode(Integer.toString(account.getAccountProfile().getContactInfo().getLocation().getZipcode()));
		
		return pir;
		
	}

	@Override
	public void updateEmail(String email, String newSecurityQuestionAnswer) {
		// TODO Auto-generated method stub
		accountFactory.updateEmail(email,newSecurityQuestionAnswer);
	}

	@Override
	public void updatePhone(String email, int areacode, int countrycode, int phoneNumber, int phoneType) {
		// TODO Auto-generated method stub
		accountFactory.updatePhone(email,areacode,countrycode,phoneNumber,phoneType);
	
	}

	@Override
	public void updateLocation(String email, int zipcode, String streetAddress, String city, String country,
			String state) {
		// TODO Auto-generated method stub
		accountFactory.updateAddress(email,streetAddress, state, city, zipcode, country);
	}

	@Override
	public void updateBirthDate(String email, String birthDate) {
		// TODO Auto-generated method stub
		accountFactory.updateBirthDate(email,birthDate);
	}

	@Override
	public void updateFullName(String email, String newFullName) {
		// TODO Auto-generated method stub
		accountFactory.updateFullName(email,newFullName);
		
	}

}
