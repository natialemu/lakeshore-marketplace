package Domain.Account.AccountProfile.Contact;


/*
  Class that represents the contact information of a user
 */
public class ContactInfoImpl implements ContactInfo{

    private String fullName;
    private Phone phone;
    private String email;
    private String securityQuestion;
    private Location location;
    private String birthDate;
    private String securityQuestionAnswer;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public void setLocation(String city, String streetAddress, String state, int zipcode, String country, int pobox) {
        this.location = new LocationImpl(streetAddress,city,zipcode,state,country,pobox);
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getSecurityQuestionAnswer() {
        return securityQuestionAnswer;
    }

    public void setSecurityQuestionAnswer(String securityQuestionAnswer) {
        this.securityQuestionAnswer = securityQuestionAnswer;
    }

    @Override
    public String toString() {
        return "ContactInfoImpl{" +
                "fullName='" + fullName + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", securityQuestion='" + securityQuestion + '\'' +
                ", location=" + location +
                ", birthDate='" + birthDate + '\'' +
                ", securityQuestionAnswer='" + securityQuestionAnswer + '\'' +
                '}';
    }





}
