package Repository.Account.AccountProfileDAO;

import Domain.Account.AccountProfile.Contact.Location;
import Domain.Account.AccountProfile.Contact.LocationImpl;
import Domain.Account.AccountProfile.Finance.FinancialInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FinancialInfoDAOImplTest {
    private FinancialInfoDAO financialInfoDAO;

    private String accountNumber = "54344";
    private String bankName = "Test bank";
    private String routingNumbe = "12121212";
    private String accountType = "checking";
    private Location billingAddress = new LocationImpl("test loc",":city",202,"il");
    private String swiftCode = "ADG4";
    private int fin_id  = 8;


    @BeforeEach
    public void setUp(){

        financialInfoDAO = new FinancialInfoDAOImpl();

    }

    @Test
    void createAccountFinancialProfile() {

       // financialInfoDAO.createAccountFinancialProfile(fin_id,accountNumber,bankName,routingNumbe,accountType,billingAddress,swiftCode);

    }

    @Test
    void createPaymentCardProfile() {
        financialInfoDAO.createPaymentCardProfile(accountNumber,"Nati","123456","89898989",347);
        //Tested
    }
 
    @Test
    void updatePaymentCard() {

        //financialInfoDAO.updatePaymentCard()
    }

    @Test
    void updateBankInformation() {
    }

    @Test
    void getFinancialInfo() {
        FinancialInfo financialInfo = financialInfoDAO.getFinancialInfo(4);
        assertEquals(financialInfo.getBillingAddress().getZipcode(),242);
        assertEquals(financialInfo.getBankAccount().getAccountNumber(),accountNumber);
        assertEquals(financialInfo.getPaymentCard().getCardNumber(),"123456");
        assertEquals(financialInfo.getBankAccount().getRoutingNumber(),routingNumbe);
        assertEquals(financialInfo.getBankAccount().getBankName(),bankName);
    }

}