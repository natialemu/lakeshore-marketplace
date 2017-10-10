package Domain.Account.AccountProfile;

import Domain.Account.AccountProfile.Contact.ContactInfo;
import Domain.Account.AccountProfile.Contact.ContactInfoImpl;
import Domain.Account.AccountProfile.Finance.FinancialInfo;

public class AccountProfileImpl implements AccountProfile{
    private String username;
    private String password;
    private ContactInfo contactInfo;
    private FinancialInfo financialInfo;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public FinancialInfo getFinancialInfo() {
        return financialInfo;
    }

    public void setFinancialInfo(FinancialInfo financialInfo) {
        this.financialInfo = financialInfo;
    }


    public AccountProfileImpl(String username, String email, String password){
        this.username = username;
        this.password = password;
        this.contactInfo = new ContactInfoImpl(email);
    }
    public AccountProfileImpl(String username, String password, String fullName, String email, String securityQuestion, String securityQuestionAnswer, String birthDate){
        this.username = username;
        this.password = password;

        contactInfo = new ContactInfoImpl(fullName,email,securityQuestion,securityQuestionAnswer,birthDate);
    }
}
