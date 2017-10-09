package Repository.Partner;

import Domain.Account.Account;
import Domain.Partner.Partner;
import Domain.Partner.PartnerImpl;
import Repository.Account.AccountDAO;
import Repository.Account.AccountDAOImpl;

import java.sql.*;

public class PartnerDAOImpl implements PartnerDAO {
    private AccountDAO accountDAO;

    public PartnerDAOImpl(){
        accountDAO = new AccountDAOImpl();
    }

    private Connection openConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/lakeshore_market", "root", "Natlocus13");


        } catch (SQLException exception) {
            exception.printStackTrace();
            //exception.printStackTrace();

        } catch (ClassNotFoundException es) {

            //es.printStackTrace();
        }

        return connection;

    }
    @Override
    public void createPartner(Partner partner) {

        boolean inserted = false;

        Connection connection = openConnection();
        try{
            Statement insertSatement = connection.createStatement();

            String insertQuery = "INSERT INTO partner (partner_id, partner_acct_id,partner_delivery_id) VALUES("+partner.getPartnerID()+","+partner.getAccount().getAccountID()+", "+partner.getDelivery().getDeliveryID()+", "+")";
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
    }

    @Override
    public Partner getPartner(int partner_id) {
        int account_id = 0;



        Connection connection = openConnection();
        try {
            Statement selectStatement = connection.createStatement();

            String selectQuery = "SELECT * from partner where partner_id=" + partner_id;
            ResultSet resultSet = selectStatement.executeQuery(selectQuery);
            resultSet.next();


            account_id = resultSet.getInt("partner_account_id");

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }


        Account account = accountDAO.getAccount(account_id);

        Partner partner = new PartnerImpl();
        partner.setAccount(account);

        return partner;
    }
}
