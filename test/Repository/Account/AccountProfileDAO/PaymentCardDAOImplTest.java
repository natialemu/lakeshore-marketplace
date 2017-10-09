package Repository.Account.AccountProfileDAO;

import Domain.Account.AccountProfile.Finance.PaymentCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class PaymentCardDAOImplTest {

    @InjectMocks
    private PaymentCardDAOImpl paymentCardDAO;

    @BeforeEach
    public void setUp(){
        paymentCardDAO = new PaymentCardDAOImpl();
    }

    @Test
    void createPaymentCardProfile() {

        //name
        //card number
        //expiration date
        //security code

        String name = "John oliver";
        String cardNumbr = "0978465837";
        String expirationDate = "09032019";
        int securityCode = 334;

        paymentCardDAO.createPaymentCardProfile(name,cardNumbr,expirationDate,securityCode);

    }

    @Test
    void updatePaymentCard() {
        String name = "John Test";
        String cardNumbr = "097849058";
        String expirationDate = "09032020";
        int securityCode = 334;

        paymentCardDAO.updatePaymentCard(cardNumbr,expirationDate,name,securityCode);

    }

    @Test
    void getPaymentCard() {
        String name = "John Test";
        String cardNumbr = "097849058";
        String expirationDate = "09032020";
        int securityCode = 334;
        PaymentCard paymentCard = paymentCardDAO.getPaymentCard("097849058");
        assertEquals(paymentCard.getCardExpirationDate(),expirationDate);
        assertEquals(paymentCard.getCardHolderName(),name);
        assertEquals(paymentCard.getCardNumber(),cardNumbr);
        assertEquals(paymentCard.getCardSecurityNumber(),securityCode);


    }

}