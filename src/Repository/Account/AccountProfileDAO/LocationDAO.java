package Repository.Account.AccountProfileDAO;

import Domain.Account.AccountProfile.Contact.Location;

public interface LocationDAO {
    boolean updateAddress(Location location);

    boolean createLocation(Location location);

    Location getLocation(int zipcode);

	boolean createContactLocation(int zipcode, String email);

	boolean updateContactLocation(String email, int zipcode);


}
