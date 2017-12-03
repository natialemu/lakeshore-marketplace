package Repository.Delivery;

import Domain.Delivery.Delivery;
import Domain.Delivery.DeliveryConfirmation;
import Domain.Delivery.DeliveryImpl;
import Domain.Delivery.DeliveryStatus;
import Domain.Order.Order;
import Domain.Transaction.Transaction;
import Domain.Transaction.TransactionImpl;
import Repository.Order.OrderDAO;
import Repository.Order.OrderDAOImpl;

import java.sql.*;
import java.text.SimpleDateFormat;

public class DeliveryDAOImpl implements DeliveryDAO {
    private DeliveryConfirmationDAO deliveryConfirmationDAO;
    private DeliveryStatusDAO deliveryStatusDAO;

    public DeliveryDAOImpl(){
        deliveryConfirmationDAO = new DeliveryConfirmationDAOImpl();
        deliveryStatusDAO = new DeliveryStatusDAOImpl();
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
    public Delivery getDelivery(int delivery_tracking_id) {
        int tracking_number = 0;
        int confirmation_id  = 0;
        int order_id = 0;
        Date deliveryCreationDate = null;



        Connection connection = openConnection();
        try {
            Statement selectStatement = connection.createStatement();

            String selectQuery = "SELECT * from delivery where delivery_id=" + delivery_tracking_id;
            ResultSet resultSet = selectStatement.executeQuery(selectQuery);
            resultSet.next();

            tracking_number = resultSet.getInt("delivery_tracking_no");
            order_id = resultSet.getInt("order_id");
            confirmation_id = resultSet.getInt("delivery_conf_number");
            deliveryCreationDate = resultSet.getDate("delivery_date");

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }

        OrderDAO orderDAO = new OrderDAOImpl();

        DeliveryStatus status = deliveryStatusDAO.getDeliveryStatus(tracking_number);
        DeliveryConfirmation confirmation = deliveryConfirmationDAO.getConfirmation(confirmation_id);
        Order order = orderDAO.retrieveOrder(order_id);
        Delivery delivery = new DeliveryImpl(order);
        delivery.setDeliveryStatus(status);
        delivery.setDeliveryConfirmation(confirmation);

        return delivery;
    }

    @Override
    public void createDelivery(Delivery delivery) {
        boolean inserted = false;

        Connection connection = openConnection();
        try{
            Statement insertSatement = connection.createStatement();

            String insertQuery = "INSERT INTO delivery (delivery_id,delivery_conf_number,order_id,delivery_date) VALUES("+delivery.getDeliveryID()+", "+delivery.getDeliveryConfirmation().getDeliveryID()+", "+delivery.getOrder().getOrderID()+","+getDateSring(delivery.getDeliveryCreationDate())+")";
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




    }

    private String getDateSring(java.util.Date date) {
        String stringDate =  new SimpleDateFormat("yyyyMMdd").format(date);
        return stringDate;
    }

    @Override
    public void insertDeliveryStatusWithJustTrackingNo(int deliveryID, int trackingnumber) {

        deliveryStatusDAO.insertDeliveryStatusWithJustTrackingNo(deliveryID,trackingnumber);
    }

    @Override
    public void insertDeliveryStatus(int deliveryId,int trackingNumber, String deliveryMethod, String deliveryCarrier) {

        deliveryStatusDAO.insertDeliveryStatus(deliveryId,trackingNumber,deliveryMethod,deliveryCarrier);
    }

	@Override
	public DeliveryStatus getDeliveryStatus(int tracking_number) {
		return deliveryStatusDAO.getDeliveryStatus(tracking_number);
	}
}
