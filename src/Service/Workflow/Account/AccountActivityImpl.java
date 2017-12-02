package Service.Workflow.Account;

import Domain.Account.Account;
import Domain.Account.AccountFactory;
import Domain.Account.AccountFactoryImpl;
import Domain.Customer.Customer;
import Domain.Customer.CustomerFactory;
import Domain.Customer.CustomerFactoryImpl;
import Domain.Customer.CustomerImpl;
import Domain.Partner.Partner;
import Domain.Partner.PartnerFactory;
import Domain.Partner.PartnerFactoryImpl;
import Domain.Partner.PartnerImpl;
import Domain.ReviewSystem.ReviewSystemImpl;
import Service.Representation.Link;
import Service.Representation.Account.Representation.AccountRepresentation;
import Service.Representation.Account.Representation.AccountRepresentationImpl;
import Service.Representation.Account.Representation.AccountValidationRepresentation;
import Service.Representation.Account.Representation.AccountValidationRepresentationImpl;
import Service.Representation.Account.Request.AccountRequest;

public class AccountActivityImpl implements AccountActivity{
	private AccountFactory accountFactory;
    private CustomerFactory customerFactory;
    private PartnerFactory partnerFactory;
    
    public AccountActivityImpl() {
    	accountFactory = new AccountFactoryImpl();
    	customerFactory = new CustomerFactoryImpl();
    	partnerFactory = new PartnerFactoryImpl();
    }

	@Override
	public void deleteAccount(String username, String passowrd) {
		
		accountFactory.deleteAccountWithUsername(username, passowrd);
		
	}

	@Override
	public AccountRepresentation getAccount(String username, String password) {
		
		Account account = accountFactory.getAccount(username, password);
		AccountRepresentation accountRepresentation = new AccountRepresentationImpl();
		accountRepresentation.setAccountStatus(account.getStringAccountState());
		accountRepresentation.setEmailAddress(account.getAccountProfile().getContactInfo().getEmail());
		accountRepresentation.setUsername(account.getAccountProfile().getUsername());
		return accountRepresentation;
	}

	@Override
	public void updateAccount(String oldUsername, String newUsername, String oldPassowrd, String newPassword) {
		accountFactory.updatePassword(oldUsername, newPassword);
		accountFactory.updateUserName(newUsername, newPassword);
		// TODO: updateUsername in accountFactory is not convenient. needs change!
		
	}

	@Override
	public void updatePassword(String username,String oldPassword, String newPassword) {
		accountFactory.updatePassword(username, newPassword);
		
	}

	@Override
	public void updateUsername(String oldUsername, String newUnsername) {
		//
		// TODO: the corresponding factory method is not working the way it should
		
		
	}

	@Override
	public boolean loginWithUsername(String username, String password) {
		// TODO
		return accountFactory.logInToAccount(username, password);
	}

	@Override
	public AccountValidationRepresentation registerCustomerForAccountWithEmail(AccountRequest accountRequest) {
		// TODO Auto-generated method stub
		Customer customer = new CustomerImpl();
		Account newAccount = accountFactory.getNewAccount(accountRequest.getEmail(),accountRequest.getUsername(),accountRequest.getPassword());
        AccountValidationRepresentation accountRepresentation  = new AccountValidationRepresentationImpl();
		if(accountFactory.createBasicAccount(newAccount)) {
        	accountRepresentation.setIsSuccessful(true);
        }else {
        	accountRepresentation.setIsSuccessful(false);
        }
        customer.setAccount(newAccount);
        customer.setReviewSystem(new ReviewSystemImpl());
        customerFactory.createCustomer(customer);
        setAccountValidationLinks(accountRepresentation);
        return accountRepresentation;
        
		
	}

	private void setAccountValidationLinks(AccountValidationRepresentation accountRepresentation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void regsiterCustomerForAccount(String username, String password) {
		// TODO: no support for account creation with only username and password yet
		
	}

	@Override
	public void registerPartnerForAccount(String username, String password) {
		// TODO: no support for account creation with only username and passowrd yet
		
	}

	@Override
	public AccountValidationRepresentation registerPartnerForAccountWithEmail(String username, String email, String password) {
		// TODO
		
        AccountValidationRepresentation accountRepresentation  = new AccountValidationRepresentationImpl();
		if(partnerFactory.registerPartner(email, username, password)) {
			accountRepresentation.setIsSuccessful(true);
		}else {
			accountRepresentation.setIsSuccessful(false);
		}
		
		//TODO: include links
		return accountRepresentation;
		
	}

	@Override
	public AccountValidationRepresentation loginWithEmail(String email, String password) {
		// TODO Auto-generated method stub
		AccountValidationRepresentation avr = new AccountValidationRepresentationImpl();
		
		if(accountFactory.logInToAccountWithEmail(email, password))
			avr.setIsSuccessful(true);
		else
			avr.setIsSuccessful(false);
		
		//set links
		return avr;
	}

	@Override
	public AccountRepresentation getAccount(String username) {
		// TODO Auto-generated method stub
		Account account =  accountFactory.getAccount(username);
		AccountRepresentation ar = new AccountRepresentationImpl();
		ar.setAccountStatus(account.getStringAccountState());
		ar.setEmailAddress(account.getAccountProfile().getContactInfo().getEmail());
		ar.setUsername(account.getAccountProfile().getUsername());
		return ar;
	}

	@Override
	public void deleteAccount(String username) {

		
		Account account = accountFactory.getAccount(username);
		if(account != null) {
			accountFactory.deleteAccount(account.getAccountID());
		}
	}

}
