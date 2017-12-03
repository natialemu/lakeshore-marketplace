package Repository.Order;


import Domain.Delivery.Delivery;
import Domain.Order.Order;
import Domain.Order.OrderConfirmation;
import Domain.Order.OrderDetail;
import Domain.Order.OrderImpl;
import Domain.Product.Product;
import Domain.Transaction.Transaction;
import Repository.Delivery.DeliveryDAO;
import Repository.Delivery.DeliveryDAOImpl;
import Repository.Partner.PartnerDAO;
import Repository.Partner.PartnerDAOImpl;
import Repository.Product.ProductDAO;
import Repository.Product.ProductDAOImpl;
import Repository.Transaction.TransactionDAO;
import Repository.Transaction.TransactionDAOImpl;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderDAOImpl implements OrderDAO {
    private OrderConfirmationDAO orderConfirmationDAO;
    private OrderDetailDAO orderDetailDAO;
    private TransactionDAO transactionDAO;
    private DeliveryDAO deliveryDAO;
    private ProductDAO productDAO;
    private PartnerDAO partnerDAO;

    public OrderDAOImpl(){
        orderConfirmationDAO = new OrderConfirmationDAOImpl();
        orderDetailDAO = new OrderDetailDAOImpl();
        transactionDAO = new TransactionDAOImpl();
        deliveryDAO = new DeliveryDAOImpl();
        productDAO = new ProductDAOImpl();
        partnerDAO = new PartnerDAOImpl();
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

            es.printStackTrace();
        }

        return connection;

    }
    @Override
    public List<Order> getAllOrders(int customerID) {
        Connection connection = openConnection();
        List<Order> orders = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * from placed_order";
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                int order_confirmation = resultSet.getInt("order_confirmation_id");
                Order order = retrieveOrder(order_confirmation);
                if(order != null){
                    orders.add(order);
                }

            }


        } catch (SQLException exception) {

        } finally {
            try {
                connection.close();

            } catch (Exception e) {

            }
        }
        return orders;
    }

    @Override
    public boolean createOrder(Order order) {
        boolean inserted = false;
        for(Product p: order.getOrderDetail().getAllProducts()){
            productDAO.setOrderID(p,order.getOrderID());
        }

        Connection connection = openConnection();
        try{
            Statement insertSatement = connection.createStatement();
            java.util.Date date = order.getOrderDetail().getOrderCreated();

            String insertQuery = "INSERT INTO placed_order (placed_order_id, order_status,order_confirmation_id,order_date) VALUES("+order.getOrderID()+",'"+order.getStringOrderState()+"', "+order.getConfirmationID()+", "+getDateSring(date)+")";
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
        int order_id = order.getOrderID();
        if(inserted){
            return orderDetailDAO.createOrderDAO(order.getOrderDetail(),order_id) && orderConfirmationDAO.createOrderConfirmation(order.getOrderConfirmation());

        }
        return false;
    }

    private String getDateSring(java.util.Date date) {
        String stringDate =  new SimpleDateFormat("yyyyMMdd").format(date);
        return stringDate;
    }


    @Override
    public Order retrieveOrder(int confirmationID) {
        int placed_order_id = 0;
        Order order = null;
        String order_status = "";
        int delivery_tracking_id = 0;
        int order_transaction_id = 0;
        Date orderDate = null;
        OrderConfirmation orderConfirmation = orderConfirmationDAO.getOrderConfirmation(confirmationID);
        Connection connection = openConnection();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * from account where order_confirmation_id=" + confirmationID;
            ResultSet resultSet = statement.executeQuery(query);
            assert (resultSet.isLast());
            resultSet.next();
            placed_order_id = resultSet.getInt(0);
            order_status = resultSet.getString(1);
            delivery_tracking_id = resultSet.getInt(2);
            order_transaction_id = resultSet.getInt(3);
            orderDate = resultSet.getDate(5);

        } catch (SQLException exception) {

        } finally {
            try {
                connection.close();

            } catch (Exception e) {

            }
        }
        int order_id = order.getOrderID();


        OrderDetail orderDetail = orderDetailDAO.getOrderDetail(orderDate,order_id);
        order = new OrderImpl(orderDetail);
        order.setOrderConfirmation(orderConfirmation);
        order.setOrderID(order_id);
        if(order_status == "CancelledOrder"){
            order.setState(order.getCancelledState());
        }else if(order_status == "ProcessedOrder"){
            order.setState(order.getProccessedState());
        }
        else if(order_status == "DeliveredOrder"){
            order.setState(order.getDeliveredState());
        }else if(order_status == "UnprocesedOrder"){
            order.setState(order.getUnproccessedState());
        }
        return order;
    }

    @Override
    public void updateStatus(Order retrievedOrder, int confirmation_id) {

        Connection connection = openConnection();
        try {
            Statement updateSqlStatement = connection.createStatement();
            String updateQuery = "UPDATE placed_order SET order_status='" + retrievedOrder.getStringOrderState() + "' WHERE order_confirmation_id=" + confirmation_id;
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
	public List<Order> getMostRecentOrders(int i) {
		
		Connection connection = openConnection();
		List<Integer> ids = new ArrayList<>();
		try {
			Statement getOrderIDs = connection.createStatement();
			String selectQuery = "SELECT TOP" +i+ "placed_order_id \r\n" + 
					"FROM table placed_order \r\n" + 
					"GROUP BY placed_order_id \r\n" + 
					"ORDER BY max(time) desc";
			ResultSet resultSet = getOrderIDs.executeQuery(selectQuery);
	        assert (!resultSet.isLast());
	        while(resultSet.next()) {
	        	int placed_order_id = resultSet.getInt(0);
	        	ids.add(placed_order_id);
	        	
	        	
	        }
		}catch (SQLException se) {
	        se.printStackTrace();
	    } finally {
	
	        if (connection != null) {
	            try {
	                connection.close();
	            } catch (SQLException e) { /* ignored */}
	        }
	    }
		List<Order> orders = new ArrayList<>();
		for(Integer id:ids) {
			Order order = retrieveOrder(id);
			orders.add(order);
		}
		return orders;
	}

	@Override
	public List<Order> getOrdersOfPartner(String partner_username) {
		int order_id = 0;
		int partnerID = partnerDAO.getPartnerID(partner_username);



        List<Order> orders = new ArrayList<>();
        Set<Integer> order_ids = new HashSet<>();
        Connection connection = openConnection();
        try {
            Statement selectStatement = connection.createStatement();

            String selectQuery = "SELECT * from product where partner_id=" + partnerID;
            ResultSet resultSet = selectStatement.executeQuery(selectQuery);

            while(resultSet.next()) {
                 order_id = resultSet.getInt("order_id");
                 order_ids.add(order_id);
            	
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }


        for(Integer id:order_ids) {
        	Order order = retrieveOrder(id);
        	orders.add(order);
        }
        
        return orders;		
	}
}
