package Repository.Account.AccountProfileDAO;

import Domain.Account.AccountProfile.AccountProfile;
import Domain.Account.AccountProfile.AccountProfileImpl;
import Domain.Account.AccountProfile.Contact.ContactInfo;
import Domain.Account.AccountProfile.Contact.ContactInfoImpl;
import Domain.Account.AccountProfile.Contact.Location;
import Domain.Account.AccountProfile.Finance.FinancialInfo;

import java.sql.*;

public class ContactDAOImpl implements ContactDAO {
    private PhoneDAO phoneDAO;
    private LocationDAO locationDAO;

    public ContactDAOImpl(){
        phoneDAO = new PhoneDAOImpl();
        locationDAO = new LocationDAOImpl();
    }
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
    public boolean createAccountContactProfile(String email, String fullName, Location location, String dateOfBirth, String securityQuestion, String securityQuestionAnswer) {

        boolean inserted = false;
        Connection connection = openConnection();
        try{
            Statement insertSatement = connection.createStatement();

            String insertQuery = "INSERT INTO contact (email,birthdate,security_question,security_question_answer,full_name,location_zipcode) VALUES('"+email+"', '"+dateOfBirth+"', '"+securityQuestion+"', '"+securityQuestionAnswer+"', '"+fullName+"',"+location.getZipcode()+")";
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
        if(inserted){
            locationDAO.createLocation(location);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateAddress(String streetAddress, String state, String city, int zipcode, String country, int pobox) {
        return locationDAO.updateAddress(streetAddress,state,city,zipcode,country,pobox);
    }

    @Override
    public String getActualAnswer(String email, String securityQuestion) {
        String actualAnswer = null;
        Connection connection = openConnection();
        try {
            Statement selectStatement = connection.createStatement();

            String selectQuery = "SELECT * from contact where email='" + email+"'";
            ResultSet resultSet = selectStatement.executeQuery(selectQuery);
            resultSet.next();
            actualAnswer = resultSet.getString("security_question_answer");

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }

        return actualAnswer;
    }

    @Override
    public ContactInfo getContactInfo(String email) {
        String birthDate = null;
        int zipcode = 0;
        String securityQuestion = null;
        String fullName = null;
        String securityQuestionAnswer = null;

        Connection connection = openConnection();
        try {
            Statement selectStatement = connection.createStatement();

            String selectQuery = "SELECT * from contact where email='" + email+"'";
            ResultSet resultSet = selectStatement.executeQuery(selectQuery);
            resultSet.next();
            birthDate = resultSet.getString("birthdate");
            zipcode = resultSet.getInt("location_zipcode");
            securityQuestion = resultSet.getString("security_question");
            fullName = resultSet.getString("full_name");
            securityQuestionAnswer = resultSet.getString("security_question_answer");

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }

        Location location = locationDAO.getLocation(zipcode);
        ContactInfo contactInfo = new ContactInfoImpl(fullName,email,securityQuestion,securityQuestionAnswer,birthDate);
        contactInfo.setLocation(location);

        return contactInfo;
    }
}
