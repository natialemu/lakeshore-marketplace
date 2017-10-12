package Domain.Customer;

import Domain.Account.Account;
import Domain.Account.AccountFactory;
import Domain.Partner.Partner;
import Domain.ReviewSystem.ReviewSystem;

public interface Customer {
    int getCustomerID();
    Account getAccount();
    void setAccount(Account account);
    ReviewSystem getReviewSystem();
    void setReviewSystem(ReviewSystem reviewSystem);
    void setCustomerID(int customerID);
}
