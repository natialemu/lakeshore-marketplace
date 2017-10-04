package Repository.Account;

import Domain.Account.Account;
import Domain.Account.AccountImpl;
import Domain.Account.AccountProfile.AccountProfile;
import Domain.Account.AccountProfile.Contact.Location;
import Domain.Account.AccountSettings.AccountSettings;
import Repository.Account.AccountProfileDAO.AccountProfileDAO;
import Repository.Account.AccountProfileDAO.AccountProfileDAOImpl;
import Repository.Account.AccountSettingsDAO.AccountSettingsDAO;
import Repository.Account.AccountSettingsDAO.AccountSettingsDAOImpl;

import java.sql.*;

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
            connection = DriverManager.getConnection("jdbc:mysql://localhost/lakeshore_market", "root", "Natlocus13");


        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
            //exception.printStackTrace();

        } catch (SQLException es) {

            es.printStackTrace();
        }

        return connection;

    }

    @Override
    public boolean createBasicAccount(String username, String password) {
        Connection connection = openConnection();
        Statement sqlStatement = null;
        try {


            sqlStatement = connection.createStatement();
            String insertAccountProfile = "INSERT INTO account_profile (username, password) VALUES (" + username + "," + password + ")";
            sqlStatement.executeQuery(insertAccountProfile);

            String insertAccount = "INSERT INTO account (account_state,acct_username) VALUES ('ActiveAccount'," + username + ")";
            sqlStatement.executeQuery(insertAccount);
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
        return true;
    }

    @Override
    public boolean createAccountContactProfile(String email, String fullName, Location location, String dateOfBirth, String securityQuestion, String securityQuestionAnswer) {
        return accountProfileDAO.createAccountContactProfile(email, fullName, location, dateOfBirth, securityQuestion, securityQuestionAnswer);

    }

    @Override
    public boolean createAccountFinancialProfile(String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode) {

        return accountProfileDAO.createAccountFinancialProfile(bankName, routingNumber, accountType, billingAddress, swiftCode);

    }

    @Override
    public boolean createPaymentCardProfile(String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber) {

        return accountProfileDAO.createPaymentCardProfile(cardHolderName, cardNumber, cardExpirationDate, securityNumber);


    }

    @Override
    public boolean deleteAccount(int accountID) {
        if (accountExists(accountID)) {
            Connection connection = openConnection();

            try {
                Statement sqlStatement = connection.createStatement();
                String deleteQuery = "DELETE FROM account WHERE account_id=" + accountID;
                sqlStatement.executeQuery(deleteQuery);
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
            String deleteQuery = "DELETE FROM account WHERE acct_username=" + username;
            sqlStatement.executeQuery(deleteQuery);
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
    public boolean updateAddress(String streetAddress, String state, String city, int zipcode, String country, int pobox) {
        return accountProfileDAO.updateAddress(streetAddress, state, city, zipcode, country, pobox);
    }

    @Override
    public boolean activateStatusOfAccount(String oldUsername, String oldPassword) {
        Connection connection = openConnection();

        try {
            Statement sqlStatement = connection.createStatement();

            String updateQuery = "UPDATE account SET account_state='ActiveAccount' where acct_username=" + oldUsername;

            sqlStatement.executeQuery(updateQuery);
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
            String selectQuery = "SELECT * from account where username=" + username;
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
        AccountProfile accountProfile = accountProfileDAO.getAccountProfile(username);
        Connection connection = openConnection();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * from account where acct_username=" + username;
            ResultSet resultSet = statement.executeQuery(query);
            assert (resultSet.isLast());
            resultSet.next();
            int account_id = resultSet.getInt(0);
            account_state = resultSet.getString(1);
            acct_settings_id = resultSet.getString(3);

        } catch (SQLException exception) {

        } finally {
            try {
                connection.close();

            } catch (Exception e) {

            }
        }

        AccountSettings accountSettings = accountSettingsDAO.getAccountSettings(acct_settings_id);
        account = new AccountImpl(username, accountProfile.getPassword());
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
            assert (resultSet.isLast());
            resultSet.next();
            username = resultSet.getString("username");


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
}
