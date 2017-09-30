package Domain.Account.AccountProfile.Contact;

public interface Phone {

    void setWorkPhone(String workPhone);
    void setHomePhone(String homePhone);
    void setCellularPhone(String cellularPhone);
    void setAreaCode(String areaCode);
    void setCountryCode(String countryCode);

    String getWorkPhone();
    String getHomePhone();
    String getCellularPhone();
    String getAreaCode();
    String getCountryCode();

}
