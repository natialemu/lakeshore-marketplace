package Repository.Account.AccountProfileDAO;

import Domain.Account.AccountProfile.Finance.PaymentCard;

public interface PaymentCardDAO {
    boolean createPaymentCardProfile(String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber);

    boolean updatePaymentCard(String cardNumber, String expirationDate, String cardHolderName, int securityCode);

    PaymentCard getPaymentCard(String cardNumber);
}
