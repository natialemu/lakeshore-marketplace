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
            Statement insertStatement = connection.createStatement();

            String insertQuery = "INSERT INTO partner (partner_id, partner_acct_id,partner_username) VALUES("+partner.getPartnerID()+","+partner.getAccount().getAccountID()+", '"+partner.getPartnerUsername()+"')";
            insertStatement.executeUpdate(insertQuery);

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
        String username = "";



        Connection connection = openConnection();
        try {
            Statement selectStatement = connection.createStatement();

            String selectQuery = "SELECT * from partner where partner_id=" + partner_id;
            ResultSet resultSet = selectStatement.executeQuery(selectQuery);
            resultSet.next();


            account_id = resultSet.getInt("partner_acct_id");
            username = resultSet.getString("partner_username");

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
        partner.setPartnerID(partner_id);
        partner.setPartnerUsername(username);

        return partner;
    }

	@Override
	public Partner getPartner(String username) {
		// TODO Auto-generated method stub
		int account_id = 0;
        int partner_id = 0;



        Connection connection = openConnection();
        try {
            Statement selectStatement = connection.createStatement();

            String selectQuery = "SELECT * from partner where partner_username='" + username+"'";
            ResultSet resultSet = selectStatement.executeQuery(selectQuery);
            resultSet.next();


            account_id = resultSet.getInt("partner_acct_id");
            partner_id = resultSet.getInt("partner_id");

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

        assert(account != null);
        Partner partner = new PartnerImpl();
        partner.setAccount(account);
        partner.setPartnerID(partner_id);
        partner.setPartnerUsername(username);

        return partner;
	}

	@Override
	public int getPartnerID(String username) {
        int partner_id = 0;



        Connection connection = openConnection();
        try {
            Statement selectStatement = connection.createStatement();

            String selectQuery = "SELECT * from partner where partner_username='" + username+"'";
            ResultSet resultSet = selectStatement.executeQuery(selectQuery);
            resultSet.next();


            partner_id = resultSet.getInt("partner_id");

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }


        

        return partner_id;
	}
}
