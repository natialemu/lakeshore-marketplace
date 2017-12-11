package Repository.Account.AccountProfileDAO;

import Domain.Account.AccountProfile.Contact.Location;
import Domain.Account.AccountProfile.Finance.FinancialInfo;

public interface FinancialInfoDAO {
    boolean createAccountFinancialProfile(int financial_id, String cardNumber, String accountNumber, String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode);

    boolean createPaymentCardProfile(String accountNumber, String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber);

    boolean updatePaymentCard(String cardNumber, String expirationDate, String cardHolderName, int securityCode);

    boolean updateBankInformation(String bankName, String accountNumber, String routingNumber);

    FinancialInfo getFinancialInfo(int fin_profile_id);

    void createBasicFinProfile(int fin_profile_id);

	boolean updateBankProfile(int finProfileID, String accountNumber, String accountType, String bankName,
			String routingNumber);

	boolean createPaymentCardProfile(int finacialProfileID, String cardHolderName, String cardNumber,
			String cardExpirationDate, int securityNumber);

}
