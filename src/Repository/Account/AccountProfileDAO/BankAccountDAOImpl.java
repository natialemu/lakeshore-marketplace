package Repository.Account.AccountProfileDAO;

import Domain.Account.AccountProfile.Finance.BankAccount;
import Domain.Account.AccountProfile.Finance.BankAccountImpl;
import Domain.Account.AccountProfile.Finance.CreditCard;
import Domain.Account.AccountProfile.Finance.PaymentCard;

import java.sql.*;

public class BankAccountDAOImpl implements BankAccountDAO{
    @Override
    public boolean updateBankInformation(String bankName, String accountNumber, String routingNumber) {
        boolean inserted = false;
        Connection connection = openConnection();
        try{
            Statement insertSatement = connection.createStatement();

            String insertQuery = "INSERT INTO bank_account (account_number,routing_number,bank_name) VALUES("+accountNumber+", "+routingNumber+", "+bankName+")";
            insertSatement.executeQuery(insertQuery);

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
    public BankAccount getBankAccount(String accountNumber) {
        String bankName = null;
        String routingNumber = null;
        String swiftCode = null;
        String accountType = null;

        Connection connection = openConnection();
        try {
            Statement selectStatement = connection.createStatement();

            String selectQuery = "SELECT * from bank_account where account_number=" + Integer.parseInt(accountNumber);
            ResultSet resultSet = selectStatement.executeQuery(selectQuery);
            resultSet.next();
            bankName = resultSet.getString("bank_name");
            routingNumber = Integer.toString(resultSet.getInt("security_code"));
            swiftCode = resultSet.getString("swift_code");
            accountType = resultSet.getString("account_type");


        } catch (SQLException se) {
            se.printStackTrace();
        } finally {

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }


        BankAccount bankAccount = new BankAccountImpl();
        bankAccount.setAccountType(accountType);
        bankAccount.setSwiftCode(swiftCode);
        bankAccount.setAccountNumber(accountNumber);
        bankAccount.setRoutingNumber(routingNumber);
        bankAccount.setBankName(bankName);
        return bankAccount;
    }
}
