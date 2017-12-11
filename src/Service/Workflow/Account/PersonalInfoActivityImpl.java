package Service.Workflow.Account;

import java.util.ArrayList;
import java.util.List;

import Domain.Account.Account;
import Domain.Account.AccountFactory;
import Domain.Account.AccountFactoryImpl;
import Service.Common.MediaTypes;
import Service.Common.URIs;
import Service.Representation.Link;
import Service.Representation.LinkImpl;
import Service.Representation.Account.Representation.AccountValidationRepresentation;
import Service.Representation.Account.Representation.AccountValidationRepresentationImpl;
import Service.Representation.Account.Representation.PersonalInformationRepresentation;
import Service.Representation.Account.Representation.PersonalInformationRepresentationImpl;
import Service.Representation.Account.Request.BasicAccountRequest;
import Service.Representation.Account.Request.PersonalInformationRequest;
import Service.Representation.Account.Request.PersonalInformationRequestImpl;

public class PersonalInfoActivityImpl implements PersonalInfoActivity {
	private AccountFactory accountFactory;
	
	public PersonalInfoActivityImpl() {
		accountFactory = new AccountFactoryImpl();
	}

	@Override
	public AccountValidationRepresentationImpl createPersonalInformation(String username, PersonalInformationRequestImpl personalInformation) {
		AccountValidationRepresentationImpl avr = new AccountValidationRepresentationImpl();
		String streetAddress = personalInformation.getStreetAddress();
		boolean profileCreated = accountFactory.createPersonalInformation(personalInformation.getBirthDate(),personalInformation.getCellPhone(),personalInformation.getFullName(),personalInformation.getCity(),personalInformation.getState(),streetAddress,personalInformation.getZipcode(),username);
		avr.setIsSuccessful(profileCreated);
		setLinksAfterProfileCreation(avr,username); 
		return avr;
	}

	private void setLinksAfterProfileCreation(AccountValidationRepresentationImpl avr,String username) {
		List<LinkImpl> links = new ArrayList<>();
		
		//link for  retrieving personal information
		LinkImpl getPersonalInfo = new LinkImpl("GET",URIs.PERSONALINFO+"/"+username,"Get personal information", MediaTypes.JSON);
		links.add(getPersonalInfo);
		//link for updating personal information
		
		//link for deleting personal information
		
		LinkImpl[] linkArray = new LinkImpl[links.size()];
		
		links.toArray(linkArray);
		
		avr.setLinks(linkArray);
		
		
		
	}

	@Override
	public void removesecurityAnswer(String email, String newSecurityQuestionAnswer) {
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
		accountFactory.removeEmail(newEmail);
	}

	@Override
	public PersonalInformationRepresentationImpl getPersonalInformation(String username) {
		Account account = accountFactory.getAccount(username);
		PersonalInformationRepresentationImpl pir = new PersonalInformationRepresentationImpl();
		
		pir.setBirthDate(account.getAccountProfile().getContactInfo().getBirthDate());
		pir.setCellPhone(account.getAccountProfile().getContactInfo().getPhone().getCellularPhone());
		pir.setCity(account.getAccountProfile().getContactInfo().getLocation().getCity());
		pir.setFullName(account.getAccountProfile().getContactInfo().getFullName());
		pir.setState(account.getAccountProfile().getContactInfo().getLocation().getState());
		pir.setStreetAddress(account.getAccountProfile().getContactInfo().getLocation().getStreetAddress());
		pir.setZipcode(Integer.toString(account.getAccountProfile().getContactInfo().getLocation().getZipcode()));
		setLinkPersonalInformation(pir);
		return pir;
		
	}

	private void setLinkPersonalInformation(PersonalInformationRepresentation pir) {
		List<LinkImpl> links = new ArrayList<>();
		
		//Update personal info
		LinkImpl createPersonalInfo = new LinkImpl("POST",URIs.PERSONALINFO,"update personal information: NEEDS CHANGE",MediaTypes.JSON);
		links.add(createPersonalInfo);
		
		//Delete personal info
		
		
		
		LinkImpl[] linkArray = new LinkImpl[links.size()];
		pir.setLinks(links.toArray(linkArray));
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
		accountFactory.updateAddress(email,streetAddress, state, city, zipcode, country);
	}

	@Override
	public void updateBirthDate(String email, String birthDate) {
		accountFactory.updateBirthDate(email,birthDate);
	}

	@Override
	public void updateFullName(String email, String newFullName) {
		accountFactory.updateFullName(email,newFullName);
		
	}

	@Override
	public AccountValidationRepresentationImpl updatePersonalInformation(String username,
			PersonalInformationRequestImpl personalInformation) {
		// TODO Auto-generated method stub
		return null;
	}

}
