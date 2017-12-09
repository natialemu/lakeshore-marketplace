package Domain.Account;

import Domain.Account.AccountManagement.AccountManagement;
import Domain.Account.AccountManagement.AccountManagementImpl;
import Domain.Account.AccountProfile.AccountProfile;
import Domain.Account.AccountProfile.Contact.Location;
import Domain.Account.AccountProfile.Contact.LocationImpl;
import Domain.Account.AccountSettings.AccountSettings;
import Domain.Account.AccountState.AccountState;
public class AccountFactoryImpl implements AccountFactory {


    private AccountManagement accountManagement;
    //private  Account account;//set when logging in

    public AccountFactoryImpl(){

        accountManagement = new AccountManagementImpl();

    }

    @Override
    public boolean updateUserName(String username,String password) {
        //if(account != null && account.updateUserName(username)){
            return accountManagement.updateUserName(username,password);
        //}
        //return false;
    }

    @Override
    public boolean updatePassword(String username, String password) {
        //if(account != null && account.updatePassword(username, password)){
            return accountManagement.updatePassword(username, password);
        //}
        //return false;
    }

    @Override
    public boolean updateDateOfBirth(String dateOfBirth) {
       // if(account != null && account.updateDateOfBirth(dateOfBirth)){
            return accountManagement.updateDateOfBirth(dateOfBirth);
        //}
        //return false;
    }

    @Override
    public boolean updateEmail(String email,String password) {
        //if(account != null && account.updateEmail(email)){
            return accountManagement.updateEmail(email,password);
        //}
        //return false;
    }

    @Override
    public boolean updatePaymentCard(String cardNumber, String expirationDate, String cardHolderName, int securityCode) {
        //if(account != null && account.updatePaymentCard(cardNumber,expirationDate,cardHolderName,securityCode)){
            return accountManagement.updatePaymentCard(cardNumber,expirationDate,cardHolderName,securityCode);
        //}
        //return false;
    }

    @Override
    public boolean updateBankInformation(String bankName, String accountNumber, String routingNumber) {
       // if(account != null && account.updateBankInformation(bankName,accountNumber,routingNumber)){
            return accountManagement.updateBankInformation(bankName,accountNumber,routingNumber);
        //}
        //return false;
    }

    @Override
    public boolean updateAddress(String username,String streetAddress, String state, String city, int zipcode, String country, int pobox) {
        //if(account != null && account.updateAddress(streetAddress,state,city,zipcode,country,pobox)){
            return accountManagement.updateAddress(username, streetAddress,state,city,zipcode,country,pobox);
        //}
        //return false;
    }

    @Override
    public boolean deleteAccount(int accountID) {
        //if(account != null && account.deleteAccount(accountID)){
            return accountManagement.deleteAccount(accountID);
        //}
        //return false;
    }

    @Override
    public boolean deleteAccountAccount(String email, String password) {
        //if(account != null && account.deleteAccountAccount(email,password)){
            return accountManagement.deleteAccountAccount(email,password);
        //}
        //return false;
    }

    @Override
    public boolean deleteAccountWithUsername(String username, String password) {
        //if(account != null && account.deleteAccountWithUsername(username,password)){
            return accountManagement.deleteAccountWithUsername(username,password);
        //}
        //return false;
    }

    @Override
    public String getPassowrd(String username, String securityQuestion, String securityQuestionAnswer) {
        return accountManagement.getPassowrd(username, securityQuestion,securityQuestionAnswer);

    }

    @Override
    public boolean getPasswordThroughEmail(String email) {

        return accountManagement.getPasswordThroughEmail(email);
    }

    @Override
    public void setDefaultLocation(Location location) {
    	//TODO: will need login information
        //if(account != null){
           // account.setDefaultLocation(location);
            //accountManagement.setDefaultLocation(location);
        //}

    }

    @Override
    public void setDefaultPaymentCard(String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber) {
        /*if(account != null){
            account.setDefaultPaymentCard(cardHolderName,cardNumber,cardExpirationDate,securityNumber);
            accountManagement.setDefaultPaymentCard(cardHolderName,cardNumber,cardExpirationDate,securityNumber);
        }*/

    }

    @Override
    public void setDefaultBankAccount(String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode) {
        //if(account != null){
          //  account.setDefaultBankAccount(bankName,routingNumber,accountType,billingAddress,swiftCode);
            //accountManagement.setDefaultBankAccount(bankName,routingNumber,accountType,billingAddress,swiftCode);
       // }
    }

    @Override
    public boolean logInToAccount(String username, String password) {
        //if(account == null && accountManagement.validateAccount(username,password)){

          Account account = accountManagement.getAccount(username);

            return account != null;
        //}
        //return false;
    }

    @Override
    public boolean logInToAccountWithEmail(String email, String password) {
        //if(account == null && accountManagement.validateAccountWithEmail(email,password)){

          Account account = accountManagement.getAccountWithEmail(email);

            return account != null;
        //}
        //return false;
    }

    @Override
    public boolean ReactivateAccount(String oldUsername, String oldPassword) {
    	Account account = accountManagement.getAccount(oldUsername);
    	
        if(account != null && account.ReactivateAccount(oldUsername,oldPassword)){
            return accountManagement.ReactivateAccount(oldUsername,oldPassword);

        }
        return false;
    }

    @Override
    public boolean createBasicAccount(Account account) {
        return accountManagement.createBasicAccount(account);
    }

    @Override
    public boolean createAccountContactProfile(String username,String email, String fullName, Location location, String dateOfBirth, String securityQuestion, String securityQuestionAnswer) {
        return accountManagement.createAccountContactProfile(username,email,fullName,location,dateOfBirth,securityQuestion,securityQuestionAnswer);
    }

    @Override
    public boolean createAccountFinancialProfile(String username,String cardNumber, String accountNumber, String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode) {
        return accountManagement.createAccountFinancialProfile(username,cardNumber,accountNumber,bankName,routingNumber,accountType,billingAddress,swiftCode);
    }

    @Override
    public boolean createPaymentCardProfile(String accountNumber, String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber) {
        return accountManagement.createPaymentCardProfile(accountNumber, cardHolderName,cardNumber,cardExpirationDate,securityNumber);
    }

    @Override
    public Account getNewAccount(String email, String username, String password) {

        return new AccountImpl(email,username,password);
    }

	@Override
	public Account getAccount(String username, String password) {
		// TODO Auto-generated method stub
		if(accountManagement.validateAccount(username, password)) {
			return accountManagement.getAccount(username);
		}
		return null;
	}

	@Override
	public void updateBankName(String bankAccountNumber, String newBankName) {
		System.out.println("Update Successful!");
		
	}

	@Override
	public void updateAccountNumber(String oldAccountNumber, String newAccountNumber) {
		// TODO Auto-generated method stub
		System.out.println("Update Successful!");
		
	}

	@Override
	public void updateRoutingNumber(String accountNumber, String newRoutingNumber) {
		// TODO Auto-generated method stub
		System.out.println("Update Successful!");
		
	}

	@Override
	public void updateSwiftCode(String accountNumber, int newSwiftCode) {
		// TODO Auto-generated method stub
		System.out.println("Update Successful!");
		
	}

	@Override
	public void updateAccountType(String accountNumber, String newAccountType) {
		// TODO Auto-generated method stub
		System.out.println("Update Successful!");
		
	}

	@Override
	public void updateCardNumber(String cardNumber, String newPaymentCard) {
		// TODO Auto-generated method stub
		System.out.println("Update Successful!");
		
	}

	@Override
	public void updateCardExpirationDate(String cardNumber, String newDate) {
		// TODO Auto-generated method stub
		System.out.println("Update Successful!");
		
	}

	@Override
	public void updateNameOnCard(String cardNumber, String newNameOncard) {
		// TODO Auto-generated method stub
		System.out.println("Update Successful!");
		
	}

	@Override
	public void updateSecurityCode(String cardNumber, String newSecurityCode) {
		// TODO Auto-generated method stub
		System.out.println("Update Successful!");
		
	}

	@Override
	public void deleteBankName(String bankAccountNumber, String bankName) {
		// TODO Auto-generated method stub
		System.out.println("Deletion Successful!");
	}

	@Override
	public void deleteAccountNumber(String accountNumber) {
		// TODO Auto-generated method stub
		System.out.println("Deletion Successful!");
		
	}

	@Override
	public void deleteRoutingNumber(String accountNumber, String routingNumber) {
		// TODO Auto-generated method stub
		System.out.println("Deletion Successful!");
		
	}

	@Override
	public void deleteSwiftCode(String accountNumber, String swiftCode) {
		// TODO Auto-generated method stub
		System.out.println("Deletion Successful!");
		
	}

	@Override
	public void deleteAccountType(String accountNumber, String accountType) {
		// TODO Auto-generated method stub
		System.out.println("Deletion Successful!");
		
	}

	@Override
	public void deleteCardNumber(String cardNumber) {
		// TODO Auto-generated method stub
		System.out.println("Deletion Successful!");
		
	}

	@Override
	public void deleteCardExpirationDate(String cardNumber, String expirationDate) {
		// TODO Auto-generated method stub
		System.out.println("Deletion Successful!");
		
	}

	@Override
	public void deleteNameOnCard(String cardNumber, String cardName) {
		// TODO Auto-generated method stub
		System.out.println("Deletion Successful!");
		
	}

	@Override
	public void deleteSecurityCode(String cardNumber, int securityCode) {
		// TODO Auto-generated method stub
		System.out.println("Deletion Successful!");
	}

	@Override
	public boolean createPersonalInformation(String birthDate, String cellPhone, String fullName, String city,
			String fullName2, String state, String streetAddress, String zipcode,String username) {
		//String streetAddress, String city, int zipcode, String state, String country, int pobo
		Location location = new LocationImpl(streetAddress,city,Integer.parseInt(zipcode),state,"USA",1234);
		
		
		return accountManagement.createPersonalInformation(username,birthDate,cellPhone,fullName,location);
	}

	@Override
	public void removeSecurityAnswer(String email, String newSecurityQuestionAnswer) {
		System.out.println("removal successful!");
		
	}

	@Override
	public void removesecurityQuestion(String email, String newSecurityQuestion) {
		// TODO Auto-generated method stub
		System.out.println("removal successful!");System.out.println("removal successful!");
		
	}

	@Override
	public void removePhone(String email, int areacode, int countrycode, int phoneNumber, int phoneType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeLocation(String email, String streetAddress, String state, String city, int zipcode,
			String country) {
		// TODO Auto-generated method stub
		System.out.println("removal successful!");
	}

	@Override
	public void removeBirthDate(String email, String birthDate) {
		// TODO Auto-generated method stub
		System.out.println("removal successful!");
	}

	@Override
	public void removeFullName(String email, String fullName) {
		// TODO Auto-generated method stub
		System.out.println("removal successful!");
	}

	@Override
	public void removeEmail(String newEmail) {
		// TODO Auto-generated method stub
		System.out.println("removal successful!");
	}

	@Override
	public void updatePhone(String email, int areacode, int countrycode, int phoneNumber, int phoneType) {
		// TODO Auto-generated method stub
		System.out.println("Update successful!");
	}

	@Override
	public void updateAddress(String email, String streetAddress, String state, String city, int zipcode,
			String country) {
		// TODO Auto-generated method stub
		System.out.println("Update successful!");
	}

	@Override
	public void updateBirthDate(String email, String birthDate) {
		// TODO Auto-generated method stub
		System.out.println("Update successful!");
	}

	@Override
	public void updateFullName(String email, String newFullName) {
		// TODO Auto-generated method stub
		System.out.println("Update successful!");
	}

	@Override
	public boolean validateAccount(String username, String password) {
		// TODO Auto-generated method stub
		return accountManagement.validateAccount(username, password);
	}

	@Override
	public Account getAccount(String username) {
		// TODO Auto-generated method stub
		return accountManagement.getAccount(username);
	}

	@Override
	public String getUsername(String password) {
		// TODO Auto-generated method stub
		return accountManagement.getUsername(password);
	
	}
}
