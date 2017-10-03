package Repository.Account.AccountProfileDAO;

import Domain.Account.AccountProfile.Contact.Location;

public class LocationDAOImpl implements LocationDAO{
    @Override
    public boolean updateAddress(String streetAddress, String state, String city, int zipcode, String country, int pobox) {
        return false;
    }

    @Override
    public void createLocation(Location location) {

    }

    @Override
    public Location getLocation(int zipcode) {

        return null;
    }
}
