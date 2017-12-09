package Service.Workflow.Account;

import Service.Representation.Account.Representation.AccountValidationRepresentation;
import Service.Representation.Account.Representation.AccountValidationRepresentationImpl;
import Service.Representation.Account.Representation.*;
import Service.Representation.Account.Request.BankInfoRequest;
import Service.Representation.Account.Request.BankInfoRequestImpl;
import Service.Representation.Account.Request.BasicAccountRequest;

public interface BankInfoActivity {

    void updateBankName(String bankAccountNumber, String newBankName);

	void updateAccountNumber(String oldAccountNumber, String newAccountNumber);

	void updateRoutingNumber(String accountNumber, String newRoutingNumber);

	void updateSwiftCode(String accountNumber, int newSwiftCode);

	void updateAccountType(String accountNumber, String newAccountType);

	void updateCardNumber(String cardNumber, String newPaymentCard);

	void updateCardExpirationDate(String cardNumber, String newDate);

	void updateNameOnCard(String cardNumber, String newNameOncard);

	void updateSecurityCode(String cardNumber, String newSecurityCode);

	BankInfoRepresentationImpl getBankInfo(String username);

	void deleteBankName(String bankAccountNumber, String bankName);

	void deleteAccountNumber(String accountNumber);

	void deleteRoutingNumber(String accountNumber, String routingNumber);

	void deleteSwiftCode(String accountNumber, String swiftCode);

	void deleteAccountType(String accountNumber, String accountType);

	void deleteCardNumber(String cardNumber);

	void deleteCardExpirationDate(String cardNumber, String expirationDate);

	void deleteNameOnCard(String cardNumber, String cardName);

	void deleteSecurityCode(String cardNumber, int securityCode);

	AccountValidationRepresentationImpl createBankInformation(String username, BankInfoRequestImpl bankInformation);

	

}
