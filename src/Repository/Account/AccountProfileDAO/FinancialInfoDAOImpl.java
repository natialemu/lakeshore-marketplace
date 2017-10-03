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
    public boolean createAccountFinancialProfile(String bankName, String routingNumber, String accountType, Location billingAddress, String swiftCode) {
        //TODO
        return false;
    }

    @Override
    public boolean createPaymentCardProfile(String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber) {
        return paymentCardDAO.createPaymentCardProfile(cardHolderName,cardNumber,cardExpirationDate,securityNumber);
    }

    @Override
    public boolean updatePaymentCard(String cardNumber, String expirationDate, String cardHolderName, int securityCode) {
        return paymentCardDAO.updatePaymentCard(cardNumber,expirationDate,cardHolderName,securityCode);
    }

    @Override
    public boolean updateBankInformation(String bankName, String accountNumber, String routingNumber) {
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
        financialInfo.setBankAccount(bankAccount);
        financialInfo.setBillingAddress(billingAddress);
        financialInfo.setPaymentCard(paymentCard);

        return financialInfo;
    }
}
