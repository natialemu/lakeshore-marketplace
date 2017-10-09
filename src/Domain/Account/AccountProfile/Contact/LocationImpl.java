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

    @Override
    public String toString() {
        return "LocationImpl{" +
                "streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", zipcode=" + zipcode +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", pobox=" + pobox +
                '}';
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocationImpl location = (LocationImpl) o;

        if (zipcode != location.zipcode) return false;
        if (pobox != location.pobox) return false;
        if (streetAddress != null ? !streetAddress.equals(location.streetAddress) : location.streetAddress != null)
            return false;
        if (city != null ? !city.equals(location.city) : location.city != null) return false;
        if (state != null ? !state.equals(location.state) : location.state != null) return false;
        return country != null ? country.equals(location.country) : location.country == null;
    }

    @Override
    public int hashCode() {
        int result = streetAddress != null ? streetAddress.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + zipcode;
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + pobox;
        return result;
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
