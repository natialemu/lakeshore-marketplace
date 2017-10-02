package Repository.Account;

import Domain.Account.Account;
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

    public AccountDAOImpl(){
        accountProfileDAO = new AccountProfileDAOImpl();
        accountSettingsDAO = new AccountSettingsDAOImpl();

    }
    @Override
    public boolean createBasicAccount(String username, String password) {
        //simply create an account with the two fields
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/lakeshore_market","root","Natlocus13");
            Statement sqlStatement = connection.createStatement();
            String insertAccountProfile = "INSERT INTO account_profile (username, password) VALUES ("+username+","+password+")";
            sqlStatement.executeQuery(insertAccountProfile);

            String insertAccount = "INSERT INTO account (account_state,acct_username) VALUES ('ActiveAccount',"+username+")";
            sqlStatement.executeQuery(insertAccount);

        }catch (ClassNotFoundException exception){
            return false;
            //exception.printStackTrace();

        }catch (SQLException se){
            return false;
            //se.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean createAccountContactProfile(String email, String fullName, Location location, String dateOfBirth, String securityQuestion, String securityQuestionAnswer) {
        return accountProfileDAO.createAccountContactProfile(email,fullName,location,dateOfBirth,securityQuestion,securityQuestionAnswer);

    }

    @Override
    public boolean createAccountFinancialProfile(String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode) {

        return accountProfileDAO.createAccountFinancialProfile(bankName,routingNumber,accountType,billingAddress,swiftCode);

    }

    @Override
    public boolean createPaymentCardProfile(String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber) {

        return accountProfileDAO.createPaymentCardProfile(cardHolderName,cardNumber,cardExpirationDate,securityNumber);


    }

    @Override
    public boolean deleteAccount(int accountID) {
        if(accountExists(accountID)){
            //TODO: Delete Account

        }
        return false;
    }

    private boolean accountExists(int accountID) {
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/lakeshore_market","root","Natlocus13");
            Statement sqlStatement = connection.createStatement();

            String selectSql = "Select * from account where account_id="+accountID+"";
            ResultSet rows = sqlStatement.executeQuery(selectSql);
            if (!rows.next() ) {
                return false;
            }

        }catch (ClassNotFoundException exception){

            exception.printStackTrace();
            return false;

        }catch (SQLException se){

            se.printStackTrace();
            return false;
        }
        return true;

    }

    @Override
    public boolean deleteAccountAccount(String email, String password) {
        //TODO
        return false;
    }

    @Override
    public boolean deleteAccountWithUsername(String username, String password) {
        //TODO
        return false;
    }

    @Override
    public boolean updateUserName(String username) {
        accountProfileDAO.updateUserName(username);
        return false;
    }

    @Override
    public boolean updatePassword(String username, String password) {
        return accountProfileDAO.updatePassword(username,password);
    }

    @Override
    public boolean updateEmail(String email) {
        return accountProfileDAO.updateEmail(email);
    }

    @Override
    public boolean updatePaymentCard(String cardNumber, String expirationDate, String cardHolderName, int securityCode) {
        return accountProfileDAO.updatePaymentCard(cardNumber,expirationDate,cardHolderName,securityCode);
    }

    @Override
    public boolean updateBankInformation(String bankName, String accountNumber, String routingNumber) {
        return accountProfileDAO.updateBankInformation(bankName,accountNumber,routingNumber);
    }

    @Override
    public boolean updateAddress(String streetAddress, String state, String city, int zipcode, String country, int pobox) {
        return accountProfileDAO.updateAddress(streetAddress,state,city,zipcode,country,pobox);
    }

    @Override
    public boolean activateStatusOfAccount(String oldUsername, String oldPassword)
    {
        //TODO: perform an update here

        return false;
    }

    @Override
    public void setDefaultBankAccount(String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode) {
        accountSettingsDAO.setDefaultBankAccount(bankName,routingNumber,accountType,billingAddress,swiftCode);

    }

    @Override
    public void setDefaultLocation(Location location) {
        accountSettingsDAO.setDefaultLocation(location);

    }

    @Override
    public void setDefaultPaymentCard(String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber) {

        accountSettingsDAO.setDefaultPaymentCard(cardHolderName,cardNumber, cardExpirationDate,securityNumber);
    }

    @Override
    public boolean logIntoAccount(String username, String password) {
        return false;
    }

    @Override
    public boolean logIntoAccountWithEmail(String email, String password) {
        return accountProfileDAO.logIntoAccountWithEmail(email,password);
    }

    @Override
    public boolean validateAccount(String username, String password) {
        //TODO: select and check
        return false;
    }

    @Override
    public boolean validateAccountWithEmail(String email, String password) {
        return false;
    }

    @Override
    public Account getAccount(String username) {
        return null;
    }

    @Override
    public Account getAccountWithEmail(String email) {
        return null;
    }

    @Override
    public boolean getPassword(String username, String securityQuestion, String securityQuestionAnswer) {
        return false;
    }

    @Override
    public boolean getPasswordThroughEmail(String email) {
        return false;
    }
}
