package Repository.Account.AccountProfileDAO;

import Domain.Account.AccountProfile.Contact.ContactInfo;
import Domain.Account.AccountProfile.Contact.ContactInfoImpl;
import Domain.Account.AccountProfile.Contact.Location;
import Domain.Account.AccountProfile.Contact.LocationImpl;

import java.sql.*;

public class LocationDAOImpl implements LocationDAO{

    private Connection openConnection() {
        Connection connection = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/lakeshore_market", "root", "Natlocus13");


        } catch (Exception exception) {
            exception.printStackTrace();
            //exception.printStackTrace();

        }

        return connection;

    }
    @Override
    public boolean updateAddress(String streetAddress, String state, String city, int zipcode, String country, int pobox) {
        boolean inserted = false;
        Connection connection = openConnection();
        try{
            Statement insertSatement = connection.createStatement();

            String insertQuery = "INSERT INTO location (zipcode,street_address,city,state,country,pobox) VALUES ("+zipcode+", '"+streetAddress+"', '"+city+"', '"+state+"', '"+country+"',"+pobox+")";
            insertSatement.executeUpdate(insertQuery);

            inserted = true;
        }catch (SQLException se){
            se.printStackTrace();

        }finally {
            if(connection != null){
                try {
                    connection.close();

                }catch (Exception e){}

            }
        }
        return inserted;
    }

    @Override
    public void createLocation(Location location) {
        updateAddress(location.getStreetAddress(),location.getState(),location.getCity(),location.getZipcode(),location.getCountry(),location.getPobox());

    }

    @Override
    public Location getLocation(int zipcode) {

        String street_address = null;
        int pobox = 0;
        String city = null;
        String state = null;
        String country = null;

        Connection connection = openConnection();
        try {
            Statement selectStatement = connection.createStatement();

            String selectQuery = "SELECT * from location where zipcode=" + zipcode;
            ResultSet resultSet = selectStatement.executeQuery(selectQuery);
            resultSet.next();
            state = resultSet.getString("state");
            pobox = resultSet.getInt("pobox");
            city = resultSet.getString("city");
            country = resultSet.getString("country");
            street_address = resultSet.getString("street_address");

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }


        Location location = new LocationImpl(street_address,city,zipcode,state,country,pobox);

        return location;
    }
}
