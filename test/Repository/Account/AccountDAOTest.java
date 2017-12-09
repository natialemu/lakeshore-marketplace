package Repository.Account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Domain.Account.Account;

public class AccountDAOTest {
	
	private AccountDAO accountDAO;
	
	 @BeforeEach
	    public void setUp(){
	        accountDAO = new AccountDAOImpl();
	    }
	 
	 @Test
	 public void createBasicAccount() {
		 //accountDAO.createBasicAccount("testUsername", "eml", "psd", 12, 13, 14);
	 }
	 
	 @Test
	 public void getAccount() {
		 Account account = accountDAO.getAccount(75);
		 assert(account.getAccountSate().equals("ActiveAccount"));
		 assert(account.getAccountProfile().getUsername().equals("testUsername5"));
		 
		 
	 }

}
