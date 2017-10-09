package Repository.Delivery;

import Domain.Delivery.*;
import Domain.Order.Order;

import java.sql.*;

public class DeliveryConfirmationDAOImpl implements DeliveryConfirmationDAO
{
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
    public DeliveryConfirmation getConfirmation(int confirmation_id) {
        String header = null;
        String body  = null;



        Connection connection = openConnection();
        try {
            Statement selectStatement = connection.createStatement();

            String selectQuery = "SELECT * from delivery_confirmation where delivery_confirmation_id=" + confirmation_id;
            ResultSet resultSet = selectStatement.executeQuery(selectQuery);
            resultSet.next();

            header = resultSet.getString("header");
            body = resultSet.getString("body");


        } catch (SQLException se) {
            se.printStackTrace();
        } finally {

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }



        DeliveryConfirmation confirmation = new DeliveryConfirmationImpl();
        confirmation.setBody(body);
        confirmation.setHeader(header);
        confirmation.setDeliveryID(confirmation_id);


        return confirmation;
    }
}
