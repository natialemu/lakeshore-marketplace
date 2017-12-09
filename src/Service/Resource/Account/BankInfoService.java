package Service.Resource.Account;

import javax.jws.WebService;

import Service.Representation.Account.Representation.AccountValidationRepresentation;
import Service.Representation.Account.Representation.AccountValidationRepresentationImpl;
import Service.Representation.Account.Representation.BankInfoRepresentation;
import Service.Representation.Account.Representation.BankInfoRepresentationImpl;
import Service.Representation.Account.Request.BankInfoRequest;
import Service.Representation.Account.Request.BankInfoRequestImpl;
import Service.Representation.Account.Request.BasicAccountRequest;

@WebService
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
	BankInfoRepresentationImpl getBankInfo(String username);	
	
	
	//DELETE
	void deleteBankName(String bankAccountNumber, String bankName);
	void deleteAccountNumber(String accountNumber);
	void deleteRoutingNumber(String accountNumber, String routingNumber);
	void deleteSwiftCode(String accountNumber, String swiftCode);
	void deleteAccountType(String accountNumber, String accountType);
	
	void deleteCardNumber(String cardNumber);
	void deleteCardExpirationDate(String cardNumber, String expirationDate);
	void deleteNameOnCard(String cardNumber, String cardName);
	void deleteSecurityCode(String cardNumber, int securityCode);
	
	
	//CREATE
	
	AccountValidationRepresentationImpl createBankInformation(String username,BankInfoRequestImpl bankInformation);
	

}
