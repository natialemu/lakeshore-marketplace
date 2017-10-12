package Repository.Account.AccountProfileDAO;

import Domain.Account.AccountProfile.Contact.Location;
import Domain.Account.AccountProfile.Finance.BankAccount;
import Domain.Account.AccountProfile.Finance.FinancialInfo;
import Domain.Account.AccountProfile.Finance.FinancialInfoImpl;
import Domain.Account.AccountProfile.Finance.PaymentCard;

import java.sql.*;

public class FinancialInfoDAOImpl implements FinancialInfoDAO {
    private PaymentCardDAO paymentCardDAO;
    private LocationDAO locationDAO;
    private BankAccountDAO bankAccountDAO;

    public FinancialInfoDAOImpl(){
        paymentCardDAO = new PaymentCardDAOImpl();
        bankAccountDAO = new BankAccountDAOImpl();
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
    public boolean createAccountFinancialProfile(int financial_id, String accountNumber, String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode) {
        boolean inserted = false;
        Connection connection = openConnection();
        try{
            Statement insertSatement = connection.createStatement();

            String insertQuery = "INSERT INTO financial_info (fin_profile_id, zip_code,account_no) VALUES("+financial_id+", "+billingAddress.getZipcode()+", "+Integer.parseInt(accountNumber)+")";
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
            //Only if it doesnt exist
            locationDAO.createLocation(billingAddress);
            bankAccountDAO.updateBankInformation(bankName,accountNumber,routingNumber);
            return true;
        }

        return false;
    }

    @Override
    public boolean createPaymentCardProfile(String accountNumber, String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber) {
        updateCardNumber(cardNumber, accountNumber);
        return paymentCardDAO.createPaymentCardProfile(cardHolderName,cardNumber,cardExpirationDate,securityNumber);
    }

    private void updateCardNumber(String cardNumber, String accountNumber) {
        Connection connection = openConnection();
        try {
            Statement updateSqlStatement = connection.createStatement();
            String updateQuery = "UPDATE financial_info SET card_no=" + Integer.parseInt(cardNumber) + " WHERE account_no=" + Integer.parseInt(accountNumber);
            updateSqlStatement.executeUpdate(updateQuery);

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
    public boolean updatePaymentCard(String cardNumber, String expirationDate, String cardHolderName, int securityCode) {
        //TODO: update the card number foreign key in financial_info table
        return paymentCardDAO.updatePaymentCard(cardNumber,expirationDate,cardHolderName,securityCode);
    }

    @Override
    public boolean updateBankInformation(String bankName, String accountNumber, String routingNumber) {
        //TODO: update the account number foreign key in financial_info table
        return bankAccountDAO.updateBankInformation(bankName,accountNumber,routingNumber);
    }

    @Override
    public FinancialInfo getFinancialInfo(int fin_profile_id) {
        //TODO
        int zipcode = 0;
        String cardNumber = null;
        String accountNumber = null;
        String securityQuestionAnswer = null;

        Connection connection = openConnection();
        try {
            Statement selectStatement = connection.createStatement();

            String selectQuery = "SELECT * from financial_info where fin_profile_id=" + fin_profile_id;
            ResultSet resultSet = selectStatement.executeQuery(selectQuery);
            resultSet.next();

            zipcode = resultSet.getInt("zip_code");
            cardNumber = Integer.toString(resultSet.getInt("card_no"));
            accountNumber = Integer.toString(resultSet.getInt("account_no"));

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }

        PaymentCard paymentCard = paymentCardDAO.getPaymentCard(cardNumber);
        BankAccount bankAccount = bankAccountDAO.getBankAccount(accountNumber);
        Location billingAddress = locationDAO.getLocation(zipcode);
        FinancialInfo financialInfo = new FinancialInfoImpl();
        financialInfo.setFinancialInfoID(fin_profile_id);
        financialInfo.setBankAccount(bankAccount);
        financialInfo.setBillingAddress(billingAddress);
        financialInfo.setPaymentCard(paymentCard);

        return financialInfo;
    }

    @Override
    public void createBasicFinProfile(int fin_profile_id) {
        Connection connection = openConnection();
        Statement sqlStatement = null;
        try {


            sqlStatement = connection.createStatement();
            String insertAccountProfile = "INSERT INTO financial_info (fin_profile_id) VALUE (" +fin_profile_id+")";
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
}
