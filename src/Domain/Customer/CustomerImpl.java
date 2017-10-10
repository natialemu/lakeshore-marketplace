package Domain.Customer;

import Domain.Account.Account;
import Domain.Account.AccountFactory;
import Domain.Partner.Partner;
import Domain.ReviewSystem.ReviewSystem;
import Domain.Tools.IDGenerator;

public class CustomerImpl implements Customer {
    private int customerID;
    private Account account;
    private Partner partner;
    private ReviewSystem reviewSystem;

    public CustomerImpl(){
        customerID = IDGenerator.getId();
    }



    @Override
    public int getCustomerID() {
        return customerID;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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
                ", account=" + account +
                ", partner=" + partner +
                ", reviewSystem=" + reviewSystem +
                '}';
    }
}
