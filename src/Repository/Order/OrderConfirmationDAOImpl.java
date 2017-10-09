package Repository.Order;

import Domain.Order.OrderConfirmation;
import Domain.Order.OrderConfirmationImpl;

import java.sql.*;

public class OrderConfirmationDAOImpl implements OrderConfirmationDAO{

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
    public OrderConfirmation getOrderConfirmation(int confirmationID) {
        String body = null;
        String header = null;

        Connection connection = openConnection();
        try {
            Statement selectStatement = connection.createStatement();

            String selectQuery = "SELECT * from order_confirmation where confirmation_id=" + confirmationID;
            ResultSet resultSet = selectStatement.executeQuery(selectQuery);
            resultSet.next();

            body = resultSet.getString("body");
            header = resultSet.getString("header");

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }


        OrderConfirmation confirmation = new OrderConfirmationImpl();
        confirmation.setConfirmationID(confirmationID);
        confirmation.setMessageBody(body);
        confirmation.setMessageHeader(header);
        return confirmation;
    }

    @Override
    public boolean createOrderConfirmation(OrderConfirmation orderConfirmation) {
        //TODO
        boolean inserted = false;

        Connection connection = openConnection();
        try{
            Statement insertSatement = connection.createStatement();

            String insertQuery = "INSERT INTO order_confirmation (confirmation_id,total_cost,order_creation_Date) VALUES("+orderConfirmation.getConfirmationID()+", "+orderConfirmation.getMessageHeader()+", "+orderConfirmation.getMessageBody()+")";
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
}
