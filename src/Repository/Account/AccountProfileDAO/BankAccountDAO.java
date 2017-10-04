package Repository.Account.AccountProfileDAO;

import Domain.Account.AccountProfile.Finance.BankAccount;

public interface BankAccountDAO {
    boolean updateBankInformation(String bankName, String accountNumber, String routingNumber);

    BankAccount getBankAccount(String accountNumber);

}
