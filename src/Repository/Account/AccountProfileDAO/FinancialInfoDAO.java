package Repository.Account.AccountProfileDAO;

import Domain.Account.AccountProfile.Contact.Location;
import Domain.Account.AccountProfile.Finance.FinancialInfo;

public interface FinancialInfoDAO {
    boolean createAccountFinancialProfile(String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode);

    boolean createPaymentCardProfile(String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber);

    boolean updatePaymentCard(String cardNumber, String expirationDate, String cardHolderName, int securityCode);

    boolean updateBankInformation(String bankName, String accountNumber, String routingNumber);

    FinancialInfo getFinancialInfo(int fin_profile_id);

}
