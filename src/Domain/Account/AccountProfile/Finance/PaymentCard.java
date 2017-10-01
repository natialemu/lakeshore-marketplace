package Domain.Account.AccountProfile.Finance;

public interface PaymentCard {

    void setCardHolderName(String cardHolderName);
    void setCardNumber(String cardNumber);
    void setCardExpirationDate(String cardExpirationDate);
    void setCardSecurityNumber(int cardSecurityNumber);

    String getCardHolderName();
    String getCardNumber();
    String getCardExpirationDate();
    int getCardSecurityNumber();

}
