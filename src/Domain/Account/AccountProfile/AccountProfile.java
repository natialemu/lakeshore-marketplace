package Domain.Account.AccountProfile;

import Domain.Account.AccountProfile.Contact.ContactInfo;
import Domain.Account.AccountProfile.Finance.FinancialInfo;

public interface AccountProfile {
    void setUsername(String username);
    void setPassword(String password);
    void setContactInfo(ContactInfo contactInfo);
    void setFinancialInfo(FinancialInfo financialInfo);

    String getUsername();
    String getPassword();
    ContactInfo getContactInfo();
    FinancialInfo getFinancialInfo();

}
