package Domain.Account.AccountProfile.Contact;

public interface ContactInfo {
    void setFullName(String fullName);
    void setPhone(Phone phone);
    void setEmail(String email);
    void setSecurityQuestion(String securityQuestion);
    void setSecurityQuestionAnswer(String securityQuestionAnswer);
    void setLocation(Location location);
    void setLocation(String city, String streetAddress, String state, int zipcode, String country, int pobox);
    void setBirthDate(String birthDate);

    String getFullName();
    Phone getPhone();
    String getEmail();
    String getSecurityQuestion();
    String getSecurityQuestionAnswer();
    Location getLocation();
    String getBirthDate();

}
