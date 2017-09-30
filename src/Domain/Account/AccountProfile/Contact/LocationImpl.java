package Domain.Account.AccountProfile.Contact;


/*
 This class represents the location of users who've created an account
 */
public class LocationImpl implements Location {

    private String streetAddress;
    private String city;
    private int zipcode;
    private String state;
    private String country;
    private int pobox;

    public LocationImpl(String streetAddress, String city, int zipcode, String state){
        this.state = state;
        this.streetAddress = streetAddress;
        this.zipcode = zipcode;
        this.city = city;
    }

    public LocationImpl(String streetAddress, String city, int zipcode, String state, String country, int pobox){
        this(streetAddress,city,zipcode,state);
        this.country = country;
        this.pobox = pobox;
    }

    public LocationImpl(){
        //DEFAULT CONSTRUCTOR
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPobox(int pobox) {
        this.pobox = pobox;
    }



    @Override
    public String getStreetAddress() {
        return streetAddress;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public int getZipcode() {
        return zipcode;
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public int getPobox() {
        return pobox;
    }
}
