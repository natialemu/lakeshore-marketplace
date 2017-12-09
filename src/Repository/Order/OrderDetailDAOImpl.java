package Repository.Order;

import Domain.Customer.Customer;
import Domain.Order.OrderConfirmation;
import Domain.Order.OrderConfirmationImpl;
import Domain.Order.OrderDetail;
import Domain.Order.OrderDetailImpl;
import Domain.Product.Product;
import Repository.Customer.CustomerDAO;
import Repository.Customer.CustomerDAOimpl;
import Repository.Product.ProductDAO;
import Repository.Product.ProductDAOImpl;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO{
    private CustomerDAO customerDAO;
    private ProductDAO productDAO;
    public OrderDetailDAOImpl(){
        customerDAO = new CustomerDAOimpl();
        
        productDAO = new ProductDAOImpl();
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
    public OrderDetail getOrderDetail(Date orderCreated, int detailID) {
        int customer_id = 0;
        int num_products = 0;
        double total_cost = 0;


        Connection connection = openConnection();
        try {
            Statement selectStatement = connection.createStatement();

            String selectQuery = "SELECT * from ordeR_detail where order_detail_id=" + detailID;
            ResultSet resultSet = selectStatement.executeQuery(selectQuery);
            resultSet.next();

            customer_id = resultSet.getInt("customer_id");
            num_products = resultSet.getInt("num_products");
            total_cost = (double)resultSet.getInt("total_cost");

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }


        Customer customer = customerDAO.getCustomer(customer_id);



        List<Product> productList = productDAO.getProducts();
        OrderDetail orderDetail = new OrderDetailImpl(productList,customer);
        return orderDetail;
    }

    @Override
    public boolean createOrderDAO(OrderDetail orderDetail, int order_id) {
        boolean inserted = false;

        Connection connection = openConnection();
        try{
            Statement insertSatement = connection.createStatement();

            String insertQuery = "INSERT INTO order_detail (order_detail_id, customer_id,total_cost,order_creation_Date) VALUES("+orderDetail.getDetailID()+","+orderDetail.getCustomer().getCustomerID()+", "+orderDetail.getTotalCost()+", "+getDateSring(orderDetail.getOrderCreated())+")";
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

        return inserted;
    }
    private String getDateSring(java.util.Date date) {
        String stringDate =  new SimpleDateFormat("yyyyMMdd").format(date);
        return stringDate;
    }
}
