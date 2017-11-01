package Service.Workflow.Account;

import Service.Representation.Account.BankInfoRepresentation;
import Service.Representation.Account.BankInfoRequest;
import Service.Representation.Account.BasicAccountRequest;

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

	BankInfoRepresentation getBankInfo(BasicAccountRequest basicAccount);

	void deleteBankName(String bankAccountNumber, String bankName);

	void deleteAccountNumber(String accountNumber);

	void deleteRoutingNumber(String accountNumber, String routingNumber);

	void deleteSwiftCode(String accountNumber, String swiftCode);

	void deleteAccountType(String accountNumber, String accountType);

	void deleteCardNumber(String cardNumber);

	void deleteCardExpirationDate(String cardNumber, String expirationDate);

	void deleteNameOnCard(String cardNumber, String cardName);

	void deleteSecurityCode(String cardNumber, int securityCode);

	void createBankInformation(String username, BankInfoRequest bankInformation);

	

}
