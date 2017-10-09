package Repository.Account.AccountProfileDAO;

import Domain.Account.AccountProfile.Finance.BankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountDAOImplTest {

    private BankAccountDAO bankAccountDAO;
    private String bankName = "Wells fargo";
    private String accountNumber = "9769655";
    private String routingNumber = "9856576";

    @BeforeEach
    public void setUp(){
        bankAccountDAO = new BankAccountDAOImpl();
    }
    @Test
    void updateBankInformation() {
        //bank name
        //account number
        //routing number



        bankAccountDAO.updateBankInformation(bankName,accountNumber,routingNumber);

    }

    @Test
    void getBankAccount() {
        BankAccount bankAccount  = bankAccountDAO.getBankAccount(accountNumber);
        assertEquals(bankAccount.getAccountNumber(),accountNumber);
        assertEquals(bankAccount.getBankName(),bankName);
        assertEquals(bankAccount.getRoutingNumber(),routingNumber);
    }

}