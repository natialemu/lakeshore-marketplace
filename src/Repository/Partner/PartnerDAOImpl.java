package Repository.Partner;

import Domain.Partner.Partner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PartnerDAOImpl implements PartnerDAO {

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
        return null;
    }
}
