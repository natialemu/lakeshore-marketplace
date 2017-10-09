package Repository.Account.AccountProfileDAO;

import Domain.Account.AccountProfile.Contact.Location;
import Domain.Account.AccountProfile.Contact.LocationImpl;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
class LocationDAOImplTest {
    @InjectMocks
    private LocationDAOImpl locationDAO;

    @BeforeEach
    public void setUp(){
        locationDAO = new LocationDAOImpl();
    }
    @Test
    void updateAddress() {
        String streetAddress = "6317 N Broadway";
        String state = "IL";
        String city = "Chicago";
        String country = "USA";
        int zipcode = 60661;
        int pobox = 8088;

        locationDAO.updateAddress(streetAddress,state,city,zipcode,country,pobox);


    }

    @Test
    void createLocation() {
        //street address, state, city, zipcode, country, pobox
        String streetAddress = "6317 N Broadway";
        String state = "IL";
        String city = "Chicago";
        String country = "USA";
        int zipcode = 60660;
        int pobox = 8088;

        Location location = new LocationImpl(streetAddress,city,zipcode,state,country,pobox);
        locationDAO.createLocation(location);
    }

    @Test
    void getLocation() {

        Location location = locationDAO.getLocation(60660);
        assertEquals (location.getZipcode(),60660);
        assertEquals(location.getCity(),"Chicago");
        assertEquals(location.getState(),"IL");
        assertEquals(location.getCountry(),"USA");
        assertEquals(location.getPobox(),8088);

    }

}