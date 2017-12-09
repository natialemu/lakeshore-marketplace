package Repository.Account;

import Domain.Account.Account;
import Domain.Account.AccountImpl;
import Domain.Account.AccountProfile.AccountProfile;
import Domain.Account.AccountProfile.Contact.Location;
import Domain.Account.AccountProfile.Contact.LocationImpl;
import Domain.Account.AccountSettings.AccountSettings;
import Repository.Account.AccountProfileDAO.AccountProfileDAO;
import Repository.Account.AccountProfileDAO.AccountProfileDAOImpl;
import Repository.Account.AccountSettingsDAO.AccountSettingsDAO;
import Repository.Account.AccountSettingsDAO.AccountSettingsDAOImpl;

import java.sql.*;
import javax.sql.*;
import com.mysql.jdbc.Driver;

public class AccountDAOImpl implements AccountDAO {
    AccountProfileDAO accountProfileDAO;
    AccountSettingsDAO accountSettingsDAO;

    public AccountDAOImpl() {
        accountProfileDAO = new AccountProfileDAOImpl();
        accountSettingsDAO = new AccountSettingsDAOImpl();

    }

    private Connection openConnection() {
        Connection connection = null;
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lakeshore_market?useSSL=false", "root", "Natlocus13");


        } catch(ClassNotFoundException ce) {
        	ce.printStackTrace();
        	}
        catch (SQLException es) {

            es.printStackTrace();
        }

        return connection;

    }

    @Override
    public boolean createBasicAccount(String username, String email, String password,int account_id, int account_Settings_id, int fin_profile_id) {
        Connection connection = openConnection();
        Statement sqlStatement = null;
        boolean inserted = false;
        try {


            sqlStatement = connection.createStatement();
            String insertAccountProfile = "INSERT INTO account (account_id, acct_settings_id,account_state, acct_username) VALUES (" + account_id +"," +account_Settings_id +", 'ActiveAccount','"+username+"')";
            sqlStatement.executeUpdate(insertAccountProfile);
            inserted = true;

        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
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
        accountProfileDAO.createBasicProfile(username,email,fin_profile_id,password);
        accountSettingsDAO.createBasicSettings(account_Settings_id);


        return true;
    }

    @Override
    public boolean createAccountContactProfile(String username, String email, String fullName, Location location, String dateOfBirth, String securityQuestion, String securityQuestionAnswer) {
        return accountProfileDAO.createAccountContactProfile(username, email, fullName, location, dateOfBirth, securityQuestion, securityQuestionAnswer);

    }

    @Override
    public boolean createAccountFinancialProfile(String username, String cardNumber, String accountNumber, String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode) {

        return accountProfileDAO.createAccountFinancialProfile(username, cardNumber, accountNumber, bankName, routingNumber, accountType, billingAddress, swiftCode);

    }

    @Override
    public boolean createPaymentCardProfile(String accountNumber, String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber) {

        return accountProfileDAO.createPaymentCardProfile(accountNumber,cardHolderName, cardNumber, cardExpirationDate, securityNumber);


    }

    @Override
    public boolean deleteAccount(int accountID) {
        if (accountExists(accountID)) {
            Connection connection = openConnection();

            try {
                Statement sqlStatement = connection.createStatement();
                String deleteQuery = "DELETE FROM account WHERE account_id=" + accountID;
                sqlStatement.executeUpdate(deleteQuery);
                return true;

            } catch (SQLException se) {
                se.printStackTrace();
            }finally {


                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) { /* ignored */}
                }
            }
        }
        return false;
    }

    private boolean accountExists(int accountID) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/lakeshore_market", "root", "Natlocus13");
            Statement sqlStatement = connection.createStatement();

            String selectSql = "Select * from account where account_id=" + accountID + "";
            ResultSet rows = sqlStatement.executeQuery(selectSql);
            boolean empty = true;
            while (rows.next()) {
                // ResultSet processing here
                empty = false;
            }

            if (empty) {
                return false;
            }
            return true;

        } catch (ClassNotFoundException exception) {

            exception.printStackTrace();

        } catch (SQLException se) {

            se.printStackTrace();
        }finally {


            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
        return false;

    }

    @Override
    public boolean deleteAccountAccount(String email, String password) {
        Connection connection = openConnection();

        AccountProfile accountProfile = accountProfileDAO.getAccountProfilewithEmail(email);
        String username = accountProfile.getUsername();
        return deleteAccountWithUsername(username, password);


    }

    @Override
    public boolean deleteAccountWithUsername(String username, String password) {
        Connection connection = openConnection();

        try {
            Statement sqlStatement = connection.createStatement();
            String deleteQuery = "DELETE FROM account WHERE acct_username='" + username+"'";
            sqlStatement.executeUpdate(deleteQuery);
            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        }finally {


            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }

        return false;
    }

    @Override
    public boolean updateUserName(String username,String password) {
        accountProfileDAO.updateUserName(username,password);
        return false;
    }

    @Override
    public boolean updatePassword(String username, String password) {
        return accountProfileDAO.updatePassword(username, password);
    }

    @Override
    public boolean updateEmail(String email,String password) {
        return accountProfileDAO.updateEmail(email,password);
    }

    @Override
    public boolean updatePaymentCard(String cardNumber, String expirationDate, String cardHolderName, int securityCode) {
        return accountProfileDAO.updatePaymentCard(cardNumber, expirationDate, cardHolderName, securityCode);
    }

    @Override
    public boolean updateBankInformation(String bankName, String accountNumber, String routingNumber) {
        return accountProfileDAO.updateBankInformation(bankName, accountNumber, routingNumber);
    }

    @Override
    public boolean updateAddress(String username, String streetAddress, String state, String city, int zipcode, String country, int pobox) {
        Location location = new LocationImpl(streetAddress,city,zipcode,state,country,pobox);
        Account account = getAccount(username);
    	return accountProfileDAO.updateAddress(account.getAccountProfile().getContactInfo().getEmail(),location);
    }

    @Override
    public boolean activateStatusOfAccount(String oldUsername, String oldPassword) {
        Connection connection = openConnection();

        try {
            Statement sqlStatement = connection.createStatement();

            String updateQuery = "UPDATE account SET account_state='ActiveAccount' where acct_username='" + oldUsername+"'";

            sqlStatement.executeUpdate(updateQuery);
            return true;

        } catch (SQLException se) {
            se.printStackTrace();
        }finally {


            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }

        return false;
    }

    @Override
    public void setDefaultBankAccount(String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode) {
        accountSettingsDAO.setDefaultBankAccount(bankName, routingNumber, accountType, billingAddress, swiftCode);

    }

    @Override
    public void setDefaultLocation(Location location) {
        accountSettingsDAO.setDefaultLocation(location);

    }

    @Override
    public void setDefaultPaymentCard(String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber) {

        accountSettingsDAO.setDefaultPaymentCard(cardHolderName, cardNumber, cardExpirationDate, securityNumber);
    }

    @Override
    public boolean logIntoAccount(String username, String password) {
        return accountProfileDAO.logInToAccount(username, password);
    }

    @Override
    public boolean logIntoAccountWithEmail(String email, String password) {
        return accountProfileDAO.logIntoAccountWithEmail(email, password);
    }

    @Override
    public boolean validateAccount(String username, String password) {
        Connection connection = openConnection();
        try {
            Statement sqlStatement = connection.createStatement();
            String selectQuery = "SELECT * from account where username='" + username+"'";
            ResultSet resultSet = sqlStatement.executeQuery(selectQuery);
            boolean empty = true;
            while (resultSet.next()) {
                // ResultSet processing here
                empty = false;
            }

            if (empty) {
                return false;
            }
            return true;

        } catch (SQLException es) {
            es.printStackTrace();
        }finally {


            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }


        return false;
    }

    @Override
    public boolean validateAccountWithEmail(String email, String password) {
        return accountProfileDAO.validateAccountWithEmail(email, password);
    }

    @Override
    public Account getAccount(String username) {
        String acct_settings_id = "";
        Account account = null;
        String account_state = "";
        int account_id = 0;
        AccountProfile accountProfile = accountProfileDAO.getAccountProfile(username);
        Connection connection = openConnection();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * from account where acct_username='" + username+"'";
            ResultSet resultSet = statement.executeQuery(query);
            assert (resultSet.isLast());
            resultSet.next();
            account_id = resultSet.getInt("account_id");
            account_state = resultSet.getString("account_state");
            acct_settings_id = resultSet.getString("acct_settings_id");

        } catch (SQLException exception) {

        } finally {
            try {
                connection.close();

            } catch (Exception e) {

            }
        }

        AccountSettings accountSettings = accountSettingsDAO.getAccountSettings(acct_settings_id);
        account = new AccountImpl(username, accountProfile.getContactInfo().getEmail(),accountProfile.getPassword());
        account.setAccountID(account_id);
        account.setAccountProfile(accountProfile);
        account.setAccountSettings(accountSettings);
        if (account_state.equals("ActiveAccount")) {
            account.setAccountState(account.getActiveState());
        } else if (account_state.equals("InactiveAccount")) {
            account.setAccountState(account.getInActiveState());
        }

        return account;
    }

    @Override
    public Account getAccountWithEmail(String email) {

        AccountProfile accountProfile = accountProfileDAO.getAccountProfilewithEmail(email);
        String username = accountProfile.getUsername();
        return getAccount(username);
    }

    @Override
    public String getPassword(String username, String securityQuestion, String securityQuestionAnswer) {
        return accountProfileDAO.getPassword(username, securityQuestion, securityQuestionAnswer);
    }

    @Override
    public boolean getPasswordThroughEmail(String email) {
        return accountProfileDAO.getPasswordThroughEmail(email);
    }

    @Override
    public Account getAccount(int account_id) {
        String username = null;
        Connection connection = openConnection();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * from account where account_id=" + account_id;
            ResultSet resultSet = statement.executeQuery(query);
            //assert (resultSet.isLast());
            resultSet.next();
            username = resultSet.getString("acct_username");


        } catch (SQLException exception) {

        } finally {
            try {
                connection.close();

            } catch (Exception e) {

            }
        }
        if(username != null){
            return getAccount(username);
        }
        return null;

    }

	@Override
	public boolean createAccountContactProfile(String username, String fullName, Location location, String birthDate,
			String cellPhone) {
		// TODO Auto-generated method stub
        return accountProfileDAO.createAccountContactProfile(username, fullName, location, birthDate, cellPhone);

	}

	@Override
	public String getUsername(String password) {
		return accountProfileDAO.getUsername(password);
	}
}
