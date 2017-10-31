package Service.Workflow.Account;

import Service.Representation.Account.BankInfoRepresentation;
import Service.Representation.Account.BankInfoRequest;

public class BankInfoActivityImpl implements BankInfoActivity{

	@Override
	public void updateBankName(String bankAccountNumber, String newBankName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAccountNumber(String oldAccountNumber, String newAccountNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRoutingNumber(String accountNumber, String newRoutingNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSwiftCode(String accountNumber, int newSwiftCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAccountType(String accountNumber, String newAccountType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCardNumber(String cardNumber, String newPaymentCard) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCardExpirationDate(String cardNumber, String newDate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateNameOnCard(String cardNumber, String newNameOncard) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSecurityCode(String cardNumber, String newSecurityCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BankInfoRepresentation getBankInfo(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteBankName(String bankAccountNumber, String bankName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAccountNumber(String accountNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRoutingNumber(String accountNumber, String routingNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSwiftCode(String accountNumber, String swiftCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAccountType(String accountNumber, String accountType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCardNumber(String cardNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCardExpirationDate(String cardNumber, String expirationDate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteNameOnCard(String cardNumber, String cardName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSecurityCode(String cardNumber, int securityCode) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createBankInformation(BankInfoRequest bankInformation) {
		// TODO Auto-generated method stub
		
	}

}
