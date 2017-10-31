package Service.Workflow.Account;

import Domain.Account.AccountFactory;
import Domain.Account.AccountFactoryImpl;
import Domain.Customer.CustomerFactory;
import Domain.Customer.CustomerFactoryImpl;
import Domain.Partner.Partner;
import Domain.Partner.PartnerImpl;
import Service.Representation.Account.AccountRepresentation;

public class AccountActivityImpl implements AccountActivity{
	private AccountFactory accountFactory;
    private CustomerFactory customerFactory;
    private Partner partnerFactory;
    
    public AccountActivityImpl() {
    	accountFactory = new AccountFactoryImpl();
    	customerFactory = new CustomerFactoryImpl();
    	partnerFactory = new PartnerImpl();
    }

	@Override
	public void deleteAccount(String username, String passowrd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AccountRepresentation getAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateAccount(String oldUsername, String newUsername, String oldPassowrd, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUsername(String oldUsername, String newUnsername) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean loginWithUsername(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void registerCustomerForAccountWithEmail(String username, String email, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void regsiterCustomerForAccount(String username, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerPartnerForAccount(String username, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerPartnerForAccountWithEmail(String username, String email, String password) {
		// TODO Auto-generated method stub
		
	}

}
