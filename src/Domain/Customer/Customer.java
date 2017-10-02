package Domain.Customer;

import Domain.Account.AccountFactory;
import Domain.Partner.Partner;
import Domain.ReviewSystem.ReviewSystem;

public interface Customer {
    int getCustomerID();
    AccountFactory getAccountFactory();
    void setAccountFactory(AccountFactory accountFactory);
    Partner getPartner();
    void setPartner(Partner partner);
    ReviewSystem getReviewSystem();
    void setReviewSystem(ReviewSystem reviewSystem);
}
