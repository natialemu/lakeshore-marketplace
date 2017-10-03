package Repository.Account.AccountProfileDAO;

import Domain.Account.AccountProfile.Contact.Location;

public interface LocationDAO {
    boolean updateAddress(String streetAddress, String state, String city, int zipcode, String country, int pobox);

    void createLocation(Location location);

    Location getLocation(int zipcode);


}
