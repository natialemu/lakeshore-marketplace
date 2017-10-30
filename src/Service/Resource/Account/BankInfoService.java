package Service.Resource.Account;

import Service.Representation.Account.BankInfoRepresentation;
import Service.Representation.Account.BankInfoRequest;

public interface BankInfoService {
	
	//Update
	void updateBankName(String bankAccountNumber, String newBankName);
	void updateAccountNumber(String oldAccountNumber, String newAccountNumber);
	void updateRoutingNumber(String accountNumber, String newRoutingNumber);
	void updateSwiftCode(String accountNumber, int newSwiftCode);
	void updateAccountType(String accountNumber, String newAccountType);
	
	void updateCardNumber(String cardNumber, String newPaymentCard);
	void updateCardExpirationDate(String cardNumber, String newDate);
	void updateNameOnCard(String cardNumber, String newNameOncard);
	void updateSecurityCode(String cardNumber, String newSecurityCode);
	
	
	//GET
	BankInfoRepresentation getBankInfo(String username);	
	
	
	//DELETE
	void deleteBankName(String bankAccountNumber);
	void deleteAccountNumber(String accountNumber);
	void deleteRoutingNumber(String accountNumber);
	void deleteSwiftCode(String accountNumber);
	void deleteAccountType(String accountNumber);
	
	void deleteCardNumber(String cardNumber);
	void deleteCardExpirationDate(String cardNumber);
	void deleteNameOnCard(String cardNumber);
	void deleteSecurityCode(String cardNumber);
	
	
	//CREATE
	
	void createBankInformation(BankInfoRequest bankInformation);

}
