package Repository.Account.AccountProfileDAO;

import Domain.Account.AccountProfile.AccountProfile;
import Domain.Account.AccountProfile.AccountProfileImpl;
import Domain.Account.AccountProfile.Contact.ContactInfo;
import Domain.Account.AccountProfile.Contact.Location;
import Domain.Account.AccountProfile.Finance.FinancialInfo;

import java.sql.*;

public class AccountProfileDAOImpl implements AccountProfileDAO {
    private ContactDAO contactDAO;
    private FinancialInfoDAO financialInfoDAO;

    public AccountProfileDAOImpl() {
        contactDAO = new ContactDAOImpl();
        financialInfoDAO = new FinancialInfoDAOImpl();
    }

    @Override
    public boolean createAccountContactProfile(String email, String fullName, Location location, String dateOfBirth, String securityQuestion, String securityQuestionAnswer) {
        return contactDAO.createAccountContactProfile(email, fullName, location, dateOfBirth, securityQuestion, securityQuestionAnswer);
    }

    @Override
    public boolean createAccountFinancialProfile(String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode) {
        return financialInfoDAO.createAccountFinancialProfile(bankName, routingNumber, accountType, billingAddress, swiftCode);
    }

    @Override
    public boolean createPaymentCardProfile(String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber) {
        return financialInfoDAO.createPaymentCardProfile(cardHolderName, cardNumber, cardExpirationDate, securityNumber);
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
    public void updateUserName(String username, String password) {
        Connection connection = openConnection();
        try {
            Statement updateSqlStatement = connection.createStatement();
            String updateQuery = "UPDATE account_profile SET username=" + username + " WHERE password=" + password;
            updateSqlStatement.executeQuery(updateQuery);

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }

    }

    @Override
    public boolean updatePassword(String username, String password) {
        Connection connection = openConnection();
        try {
            Statement updateSqlStatement = connection.createStatement();
            String updateQuery = "UPDATE account_profile SET password=" + password + " WHERE username=" + username;
            updateSqlStatement.executeQuery(updateQuery);

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
    public boolean updateEmail(String email, String password) {
        Connection connection = openConnection();
        try {
            Statement updateSqlStatement = connection.createStatement();
            String updateQuery = "UPDATE account_profile SET email=" + email + " WHERE password=" + password;
            updateSqlStatement.executeQuery(updateQuery);

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
    public boolean updatePaymentCard(String cardNumber, String expirationDate, String cardHolderName, int securityCode) {

        return financialInfoDAO.updatePaymentCard(cardNumber, expirationDate, cardHolderName, securityCode);
    }

    @Override
    public boolean updateBankInformation(String bankName, String accountNumber, String routingNumber) {
        return financialInfoDAO.updateBankInformation(bankName, accountNumber, routingNumber);
    }

    @Override
    public boolean updateAddress(String streetAddress, String state, String city, int zipcode, String country, int pobox) {
        return contactDAO.updateAddress(streetAddress, state, city, zipcode, country, pobox);
    }

    @Override
    public boolean logIntoAccountWithEmail(String email, String password) {

        return validateAccountWithEmail(email, password);
    }

    @Override
    public boolean validateAccountWithEmail(String email, String password) {
        Connection connection = openConnection();
        try {
            Statement selectSqlStatement = connection.createStatement();
            String selectQuery = "SELECT * from account_profile WHERE email=" + email;
            ResultSet resultSet = selectSqlStatement.executeQuery(selectQuery);

            boolean empty = true;
            while (resultSet.next()) {
                // ResultSet processing here
                empty = false;
            }

            if (empty) {
                return false;
            }
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
    public String getPassword(String username, String securityQuestion, String securityQuestionAnswer) {
        String email = getAccountProfile(username).getContactInfo().getEmail();
        String actualAnswer = contactDAO.getActualAnswer(email, securityQuestion);
        if (!securityQuestionAnswer.equals(actualAnswer)) {
            return null;
        }
        Connection connection = openConnection();
        try {
            Statement selectSqlStatement = connection.createStatement();
            String selectQuery = "SELECT * from account_profile WHERE username=" + username;
            ResultSet resultSet = selectSqlStatement.executeQuery(selectQuery);
            resultSet.next();
            String password = resultSet.getString("password");
            return password;

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
        return null;
    }

    @Override
    public boolean getPasswordThroughEmail(String email) {

        Connection connection = openConnection();
        try {
            Statement selectSqlStatement = connection.createStatement();
            String selectQuery = "SELECT * from account_profile WHERE email=" + email;
            ResultSet resultSet = selectSqlStatement.executeQuery(selectQuery);
            resultSet.next();
            String password = resultSet.getString("password");
            sendPasswordToEmail(password);
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

    private void sendPasswordToEmail(String password) {
        System.out.println("Your password has been sent through your email: ");
    }

    @Override
    public AccountProfile getAccountProfile(String username) {


        String email = "";
        int fin_profile_id = 0;
        String password = "";

        Connection connection = openConnection();
        try {
            Statement selectStatement = connection.createStatement();

            String selectQuery = "SELECT * from account_profile where username=" + username;
            ResultSet resultSet = selectStatement.executeQuery(selectQuery);
            resultSet.next();
            email = resultSet.getString("email");
            fin_profile_id = resultSet.getInt("fin_profile_id");
            password = resultSet.getString("password");

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }

        ContactInfo contactInfo = contactDAO.getContactInfo(email);
        FinancialInfo financialInfo = financialInfoDAO.getFinancialInfo(fin_profile_id);
        AccountProfile accountProfile = new AccountProfileImpl(username, password);
        accountProfile.setContactInfo(contactInfo);
        accountProfile.setFinancialInfo(financialInfo);

        return accountProfile;
    }

    @Override
    public AccountProfile getAccountProfilewithEmail(String email) {
        String username = "";
        Connection connection = openConnection();
        try {
            Statement selectStatement = connection.createStatement();
            String selectQuery = "SELECT * from account_profile where email=" + email;
            ResultSet resultSet = selectStatement.executeQuery(selectQuery);
            resultSet.next();
            username = resultSet.getString("username");


        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
        if (!username.equals("")) {
            return getAccountProfile(username);
        }
        return null;
    }

    @Override
    public boolean logInToAccount(String username, String password) {
        String email = null;
        Connection connection = openConnection();
        try {
            Statement selectStatement = connection.createStatement();
            String selectQuery = "SELECT * from account_profile where username=" + username;
            ResultSet resultSet = selectStatement.executeQuery(selectQuery);
            resultSet.next();
            email = resultSet.getString("email");


        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
        if (email == null) {
            return false;
        }

        return validateAccountWithEmail(email, password);

    }
}
