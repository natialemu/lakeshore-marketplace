package Repository.Customer;

import Domain.Account.Account;
import Domain.Customer.Customer;
import Domain.Customer.CustomerImpl;
import Domain.Order.Order;
import Domain.ReviewSystem.ReviewSystem;
import Domain.Transaction.Transaction;
import Domain.Transaction.TransactionImpl;
import Repository.Account.AccountDAO;
import Repository.Account.AccountDAOImpl;
import Repository.ReviewSystem.ReviewSystemDAO;
import Repository.ReviewSystem.ReviewSystemDAOImpl;

import java.sql.*;

public class CustomerDAOimpl implements CustomerDAO {
    private AccountDAO accountDAO;
    private ReviewSystemDAO reviewSystemDAO;

    public CustomerDAOimpl(){
        accountDAO = new AccountDAOImpl();
        reviewSystemDAO = new ReviewSystemDAOImpl();
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
    public boolean createCustomer(Customer customer) {
        boolean inserted = false;

        Connection connection = openConnection();
        try{
            Statement insertSatement = connection.createStatement();

            String insertQuery = "INSERT INTO customer (customer_id, account_id,review_system_id) VALUES("+customer.getCustomerID()+","+customer.getAccount().getAccountID()+", "+", "+customer.getReviewSystem().getReviewSystemID()+")";
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

    @Override
    public Customer getCustomer(int customer_id) {
        int account_id = 0;
        int review_system_id = 0;



        Connection connection = openConnection();
        try {
            Statement selectStatement = connection.createStatement();

            String selectQuery = "SELECT * from customer where customer_id=" + customer_id;
            ResultSet resultSet = selectStatement.executeQuery(selectQuery);
            resultSet.next();

            account_id = resultSet.getInt("account_id");
            review_system_id = resultSet.getInt("review_system_id");

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
        ReviewSystem reviewSystem = reviewSystemDAO.getReviewSystem(review_system_id);

        Customer customer = new CustomerImpl();
        customer.setAccount(account);
        customer.setReviewSystem(reviewSystem);

        return customer;
    }
}
