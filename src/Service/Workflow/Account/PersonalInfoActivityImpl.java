package Service.Workflow.Account;

public class PersonalInfoActivityImpl implements PersonalInfoActivity {
	private AccountFactory accountFactory;
			
	void PersonalInfoActivityImpl(){
		this.accountFactory = new accountFactoryImpl();
	}
	@Override
	public void updateEmail(String oldEmail, String newEmail) {}
	
	@Override
	public void updateFullName(String email, String newFullName){}
	
	@Override
	public void updateBirthDate(String email, String birthDate) {}
	
	@Override
	public void updateLocation(String email, int zipcode,String streetAddress,String city, String country, String state){}
	
	@Override
	public void updatePhone( String email,  int areacode,  int countrycode,  int phoneNumber,  int phoneType){}
	
	@Override
	public void updateSecurityQuestion(String email,String newSecurityQuestion){}
	
	@Override
	public void updateSecurityAnswer(String email,String newSecurityQuestionAnswer){}
	
	@Override
	public PersonalInformationRepresentation getPersonalInformation(){return null;}
	
	@Override
	public void removeEmail(String newEmail){}
	
	@Override
	public void removeFullName(String email, String FullName){}
	
	@Override
	public void removeBirthDate(String email, String birthDate){}
	
	@Override
	public void removeLocation(String email, int zipcode, String streetAddress, String city, String country, String state){}
	
	@Override
	public void removePhone(String email, int areacode, int countrycode, int phoneNumber, int phoneType){}
	
	@Override
	public void removesecurityQuestion(String email, String newSecurityQuestion){}
	
	@Override
	public void removesecurityAnswer(String email, String newSecurityQuestionAnswer){}
	
	@Override
	public void createPersonalInformation(PersonalInformationRequest personalInformation){}
	
	
}
