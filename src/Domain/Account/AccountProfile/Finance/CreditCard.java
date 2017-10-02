package Domain.Account.AccountProfile.Finance;

public class CreditCard implements PaymentCard{
    private String cardHolderName;
    private String cardNumber;
    private String cardExpirationDate;
    private int cardSecurityNumber;

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardExpirationDate() {
        return cardExpirationDate;
    }

    public void setCardExpirationDate(String cardExpirationDate) {
        this.cardExpirationDate = cardExpirationDate;
    }

    public int getCardSecurityNumber() {
        return cardSecurityNumber;
    }

    public void setCardSecurityNumber(int cardSecurityNumber) {
        this.cardSecurityNumber = cardSecurityNumber;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "cardHolderName='" + cardHolderName + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardExpirationDate='" + cardExpirationDate + '\'' +
                ", cardSecurityNumber=" + cardSecurityNumber +
                '}';
    }
}
