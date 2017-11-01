package Service.Workflow.Account;

import Domain.Account.AccountFactory;
import Domain.Account.AccountFactoryImpl;
import Domain.Account.AccountProfile.Contact.Location;
import Domain.Account.AccountProfile.Contact.LocationImpl;
import Domain.Account.AccountProfile.Finance.FinancialInfo;
import Service.Representation.Account.BankInfoRepresentation;
import Service.Representation.Account.BankInfoRepresentationImpl;
import Service.Representation.Account.BankInfoRequest;
import Service.Representation.Account.BasicAccountRequest;

public class BankInfoActivityImpl implements BankInfoActivity{
	private AccountFactory accountFactory;
	
	public BankInfoActivityImpl() {
		accountFactory = new AccountFactoryImpl();
	}

	@Override
	public void updateBankName(String bankAccountNumber, String newBankName) {
		// TODO Auto-generated method stub
		accountFactory.updateBankName(bankAccountNumber, newBankName);
		
	}

	@Override
	public void updateAccountNumber(String oldAccountNumber, String newAccountNumber) {
		// TODO Auto-generated method stub
		accountFactory.updateAccountNumber(oldAccountNumber,newAccountNumber);
		
	}

	@Override
	public void updateRoutingNumber(String accountNumber, String newRoutingNumber) {
		// TODO Auto-generated method stub
		accountFactory.updateRoutingNumber(accountNumber,newRoutingNumber);
		
	}

	@Override
	public void updateSwiftCode(String accountNumber, int newSwiftCode) {
		// TODO Auto-generated method stub
		accountFactory.updateSwiftCode(accountNumber,newSwiftCode);
		
	}

	@Override
	public void updateAccountType(String accountNumber, String newAccountType) {
		accountFactory.updateAccountType(accountNumber,newAccountType);

		
	}

	@Override
	public void updateCardNumber(String cardNumber, String newPaymentCard) {
		// TODO Auto-generated method stub
		accountFactory.updateCardNumber(cardNumber,newPaymentCard);
	}

	@Override
	public void updateCardExpirationDate(String cardNumber, String newDate) {
		// TODO Auto-generated method stub
		accountFactory.updateCardExpirationDate(cardNumber,newDate);
	}

	@Override
	public void updateNameOnCard(String cardNumber, String newNameOncard) {
		// TODO Auto-generated method stub
		accountFactory.updateNameOnCard(cardNumber,newNameOncard);
	}

	@Override
	public void updateSecurityCode(String cardNumber, String newSecurityCode) {
		// TODO Auto-generated method stub
		accountFactory.updateSecurityCode(cardNumber,newSecurityCode);
	}

	@Override
	public BankInfoRepresentation getBankInfo(BasicAccountRequest basicAccount) {
		// TODO Auto-generated method stub
		
		 FinancialInfo finInfo = accountFactory.getAccount(basicAccount.getUsername(), basicAccount.getPassword()).getAccountProfile().getFinancialInfo();
		 BankInfoRepresentation bir = new BankInfoRepresentationImpl();
		 bir.setAccountNumber(finInfo.getBankAccount().getAccountNumber());
		 bir.setAccountType(finInfo.getBankAccount().getAccountType());
		 bir.setBankName(finInfo.getBankAccount().getBankName());
		 bir.setBillingCity(finInfo.getBillingAddress().getCity());
		 bir.setBillingState(finInfo.getBillingAddress().getState());
		 bir.setBillingStreetAddress(finInfo.getBillingAddress().getStreetAddress());
		 bir.setBillingZipcode(Integer.toString(finInfo.getBillingAddress().getZipcode()));
		 bir.setCardExpirationDate(finInfo.getPaymentCard().getCardExpirationDate().toString());
		 bir.setCardNumber(finInfo.getPaymentCard().getCardNumber());
		 bir.setNameOnCard(finInfo.getPaymentCard().getCardHolderName());
		 bir.setCardSecurityCode(Integer.toString(finInfo.getPaymentCard().getCardSecurityNumber()));
		 return bir;
		 
		 
	}

	@Override
	public void deleteBankName(String bankAccountNumber, String bankName) {
		// TODO Auto-generated method stub
		accountFactory.deleteBankName(bankAccountNumber,bankName);
	}

	@Override
	public void deleteAccountNumber(String accountNumber) {
		// TODO Auto-generated method stub
		accountFactory.deleteAccountNumber(accountNumber);
		
	}

	@Override
	public void deleteRoutingNumber(String accountNumber, String routingNumber) {
		// TODO Auto-generated method stub
		accountFactory.deleteRoutingNumber(accountNumber,routingNumber);
		
	}

	@Override
	public void deleteSwiftCode(String accountNumber, String swiftCode) {
		// TODO Auto-generated method stub
		accountFactory.deleteSwiftCode(accountNumber,swiftCode);
		
	}

	@Override
	public void deleteAccountType(String accountNumber, String accountType) {
		// TODO Auto-generated method stub
		accountFactory.deleteAccountType(accountNumber,accountType);

		
	}

	@Override
	public void deleteCardNumber(String cardNumber) {
		// TODO Auto-generated method stub
		accountFactory.deleteCardNumber(cardNumber);

	}

	@Override
	public void deleteCardExpirationDate(String cardNumber, String expirationDate) {
		// TODO Auto-generated method stub
		accountFactory.deleteCardExpirationDate(cardNumber,expirationDate);

		
	}

	@Override
	public void deleteNameOnCard(String cardNumber, String cardName) {
		// TODO Auto-generated method stub
		accountFactory.deleteNameOnCard(cardNumber,cardName);

		
	}

	@Override
	public void deleteSecurityCode(String cardNumber, int securityCode) {
		// TODO Auto-generated method stub
		accountFactory.deleteSecurityCode(cardNumber,securityCode);

		
	}

	@Override
	public void createBankInformation(String username,BankInfoRequest bankInformation) {
		// TODO Auto-generated method stub
		String defaultRoutingNumber = "123456";
		String defaultSwiftCode = "12345";
		Location location = new LocationImpl();
		location.setCity(bankInformation.getBillingCity());
		location.setState(bankInformation.getBillingState());
		location.setStreetAddress(bankInformation.getBillingStreetAddress());
		location.setZipcode(Integer.parseInt(bankInformation.getBillingZipcode()));
		
		accountFactory.createAccountFinancialProfile(username, bankInformation.getAccountNumber(), bankInformation.getBankName(), defaultRoutingNumber, bankInformation.getAccountType(), location, defaultSwiftCode);
		accountFactory.createPaymentCardProfile(bankInformation.getAccountNumber(), bankInformation.getNameOnCard(), bankInformation.getCardNumber(), bankInformation.getCardExpirationDate(), Integer.parseInt(bankInformation.getCardSecurityCode()));
		

	}

}
