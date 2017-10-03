package Domain.Customer;

import Domain.Account.AccountFactory;
import Domain.Partner.Partner;
import Domain.ReviewSystem.ReviewSystem;

public class CustomerImpl implements Customer {
    private int customerID;
    private AccountFactory accountFactory;
    private Partner partner;
    private ReviewSystem reviewSystem;



    @Override
    public int getCustomerID() {
        return customerID;
    }

    public AccountFactory getAccountFactory() {
        return accountFactory;
    }

    public void setAccountFactory(AccountFactory accountFactory) {
        this.accountFactory = accountFactory;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public ReviewSystem getReviewSystem() {
        return reviewSystem;
    }

    public void setReviewSystem(ReviewSystem reviewSystem) {
        this.reviewSystem = reviewSystem;
    }

    @Override
    public String toString() {
        return "CustomerImpl{" +
                "customerID=" + customerID +
                ", accountFactory=" + accountFactory +
                ", partner=" + partner +
                ", reviewSystem=" + reviewSystem +
                '}';
    }
}
