package Domain.Account.AccountProfile.Contact;

public class PhoneImpl implements Phone{
    private String workPhone;
    private String homePhone;
    private String cellularPhone;

    public String getWorkPhone() {
        return workPhone;
    }

    @Override
    public String toString() {
        return "PhoneImpl{" +
                "workPhone='" + workPhone + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", cellularPhone='" + cellularPhone + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getCellularPhone() {
        return cellularPhone;
    }

    public void setCellularPhone(String cellularPhone) {
        this.cellularPhone = cellularPhone;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    private String areaCode;
    private String countryCode;


}
