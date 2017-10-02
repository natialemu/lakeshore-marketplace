package Domain.Account.AccountProfile;

import Domain.Account.AccountProfile.Contact.ContactInfo;
import Domain.Account.AccountProfile.Contact.ContactInfoImpl;
import Domain.Account.AccountProfile.Finance.FinancialInfo;

public class AccountProfileImpl implements AccountProfile{
    private String username;
    private String password;
    private ContactInfo contactInfo;
    private FinancialInfo financialInfo;

    public AccountProfileImpl(String username, String password){
        this.username = username;
        this.password = password;
    }
    public AccountProfileImpl(String username, String password, String fullName, String email, String securityQuestion, String securityQuestionAnswer){
        this.username = username;
        this.password = password;

        contactInfo = new ContactInfoImpl();
    }
}
