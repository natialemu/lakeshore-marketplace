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
    public boolean updateAddress(Location location) {
        boolean inserted = false;
        Connection connection = openConnection();
        try{
            Statement insertSatement = connection.createStatement();

            String insertQuery = "UPDATE table location SET street_address='"+location.getStreetAddress()+"',city='"+location.getCity()+"',state='"+location.getState()+"',country='"+location.getCountry()+"',pobox="+location.getPobox()+" WHERE zipcode="+location.getZipcode();
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
    public boolean createLocation(Location location) {
    	boolean inserted = false;
        Connection connection = openConnection();
        try{
            Statement insertSatement = connection.createStatement();

            String insertQuery = "INSERT INTO location (zipcode,street_address,city,state,country,pobox) VALUES ("+location.getZipcode()+", '"+location.getStreetAddress()+"', '"+location.getCity()+"', '"+location.getState()+"', '"+location.getCountry()+"',"+location.getPobox()+")";
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
	@Override
	public boolean createContactLocation(int zipcode, String email) {
		boolean inserted = false;
        Connection connection = openConnection();
        try{
            Statement insertSatement = connection.createStatement();

            String insertQuery = "INSERT INTO contact_location (contact_email,contact_zipcode) VALUES('"+email+"',"+zipcode+")";
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
	public boolean updateContactLocation(String email, int zipcode) {
		// TODO Auto-generated method stub
		boolean updated = false;
        Connection connection = openConnection();
        try{
            Statement insertSatement = connection.createStatement();

            String insertQuery = "UPDATE table contact_location SET zipcode="+zipcode+" WHERE email='"+email+"'";
            insertSatement.executeUpdate(insertQuery);

            updated = true;
        }catch (SQLException se){
            se.printStackTrace();

        }finally {
            if(connection != null){
                try {
                    connection.close();

                }catch (Exception e){}

            }
        }
        return updated;	
     }
}
