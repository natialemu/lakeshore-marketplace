package Repository.Delivery;

import Domain.Delivery.DeliveryConfirmation;
import Domain.Delivery.DeliveryConfirmationImpl;
import Domain.Delivery.DeliveryStatus;
import Domain.Delivery.DeliveryStatusImpl;

import java.sql.*;

public class DeliveryStatusDAOImpl implements DeliveryStatusDAO {

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
    public void insertDeliveryStatusWithJustTrackingNo(int deliveryID, int trackingnumber) {
        boolean inserted = false;

        Connection connection = openConnection();
        try{
            Statement insertSatement = connection.createStatement();

            String insertQuery = "INSERT INTO delivery_status (tracking_number) VALUES("+trackingnumber+")";

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
    public void insertDeliveryStatus(int deliveryId, int trackingNumber, String deliveryMethod, String deliveryCarrier) {

        boolean inserted = false;

        Connection connection = openConnection();
        try{
            Statement insertSatement = connection.createStatement();

            String insertQuery = "INSERT INTO delivery_status (tracking_number,delivery_carrier,delivery_method) VALUES("+trackingNumber+", "+deliveryCarrier+", "+deliveryMethod+")";

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
    public DeliveryStatus getDeliveryStatus(int tracking_number) {
        String delivery_carrier = null;
        String delivery_method  = null;



        Connection connection = openConnection();
        try {
            Statement selectStatement = connection.createStatement();

            String selectQuery = "SELECT * from delivery_status where tracking_number=" + tracking_number;
            ResultSet resultSet = selectStatement.executeQuery(selectQuery);
            resultSet.next();

            delivery_carrier = resultSet.getString("delivery_carrier");
            delivery_method = resultSet.getString("delivery_method");


        } catch (SQLException se) {
            se.printStackTrace();
        } finally {

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }



        DeliveryStatus status = new DeliveryStatusImpl(tracking_number,delivery_carrier,delivery_method);

        return status;
    }


}
