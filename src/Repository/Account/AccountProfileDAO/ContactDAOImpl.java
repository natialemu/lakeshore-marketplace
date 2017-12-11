package Repository.Account.AccountProfileDAO;

import Domain.Account.AccountProfile.AccountProfile;
import Domain.Account.AccountProfile.AccountProfileImpl;
import Domain.Account.AccountProfile.Contact.ContactInfo;
import Domain.Account.AccountProfile.Contact.ContactInfoImpl;
import Domain.Account.AccountProfile.Contact.Location;
import Domain.Account.AccountProfile.Contact.Phone;
import Domain.Account.AccountProfile.Contact.PhoneImpl;
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

            String insertQuery = "INSERT INTO contact (email,birthdate,security_question,security_question_answer,full_name) VALUES('"+email+"', '"+dateOfBirth+"', '"+securityQuestion+"', '"+securityQuestionAnswer+"', '"+fullName+"')";
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
        	locationDAO.createContactLocation(location.getZipcode(),email);
            locationDAO.createLocation(location);
            return true;
        }
        return false;
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
        String securityQuestion = null;
        String fullName = "";
        String securityQuestionAnswer = null;
        String cellularPhone = null;

        Connection connection = openConnection();
        try {
            Statement selectStatement = connection.createStatement();

            String selectQuery = "SELECT * from contact where email='" + email+"'";
            ResultSet resultSet = selectStatement.executeQuery(selectQuery);
            resultSet.next();
            birthDate = resultSet.getString("birthdate");
            securityQuestion = resultSet.getString("security_question");
            fullName = resultSet.getString("fullName");
            securityQuestionAnswer = resultSet.getString("security_question_answer");
            cellularPhone = resultSet.getString("cellular_phone");
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }

        Location location = locationDAO.getLocation(email);
        ContactInfo contactInfo = new ContactInfoImpl(fullName,email,securityQuestion,securityQuestionAnswer,birthDate);
        contactInfo.setLocation(location);
        Phone phone = new PhoneImpl();
        phone.setCellularPhone(cellularPhone);
        
        contactInfo.setPhone(phone);

        return contactInfo;
    }

    @Override
    public void createBasicContact(String email) {
        Connection connection = openConnection();
        Statement sqlStatement = null;
        try {

 
            sqlStatement = connection.createStatement();
            String insertAccountProfile = "INSERT INTO contact (email) VALUE ('" + email + "')";
            sqlStatement.executeUpdate(insertAccountProfile);

        } catch (SQLException exception) {
            exception.printStackTrace();

        } finally {

            if (sqlStatement != null) {
                try {
                    sqlStatement.close();
                } catch (SQLException e) { /* ignored */}
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
    }
	@Override
	public boolean updateLocation(String email, Location location) {
		
		
        return locationDAO.updateContactLocation(email,location.getZipcode()) && locationDAO.updateAddress(location);
        
		
	}
	
	@Override
	public boolean createLocation(String email, Location location) {
		
		
        return locationDAO.createContactLocation(location.getZipcode(),email) && locationDAO.createLocation(location);
        
		
	}
	@Override
	public boolean updateNameAndBirth(String email, String fullName, String birthDate) {
		Connection connection = openConnection();
        try {
            Statement updateSqlStatement = connection.createStatement();
            String updateQuery = "UPDATE contact SET birthDate='" + birthDate + "',fullName='"+fullName +"' WHERE email='" + email+"'";
            updateSqlStatement.executeUpdate(updateQuery);
            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
        return false;
	}
	@Override
	public boolean updatePhone(String email, String cellPhone) {
		// TODO Auto-generated method stub
		Connection connection = openConnection();
		boolean updated = false;
        try {
            Statement updateSqlStatement = connection.createStatement();
            String updateQuery = "UPDATE contact SET cellular_phone='" + cellPhone + "' WHERE email='" + email+"'";
            updateSqlStatement.executeUpdate(updateQuery);
            updated = true;

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
        return updated;
		
	}
}
