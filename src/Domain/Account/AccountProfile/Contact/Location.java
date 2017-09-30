package Domain.Account.AccountProfile.Contact;

public interface Location {
    String getStreetAddress();
    String getCity();
    int getZipcode();
    String getState();
    String getCountry();
    int getPobox();
    void setStreetAddress(String streetAddess);
    void setCity(String city);
    void setZipcode(int zipcode);
    void setState(String state);
    void setCountry(String country);
    void setPobox(int pobox);
}
