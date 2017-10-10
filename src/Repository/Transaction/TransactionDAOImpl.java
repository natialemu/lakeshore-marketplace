package Repository.Transaction;

import Domain.Order.Order;
import Domain.Order.OrderDetail;
import Domain.Transaction.Transaction;
import Domain.Transaction.TransactionImpl;
import Repository.Order.OrderDAO;
import Repository.Order.OrderDAOImpl;

import java.sql.*;

public class TransactionDAOImpl implements TransactionDAO {
    private OrderDAO orderDAO;

    public TransactionDAOImpl(){
        orderDAO = new OrderDAOImpl();
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
    public void createTransaction(Transaction transaction) {
        boolean inserted = false;

        Connection connection = openConnection();
        try{
            Statement insertSatement = connection.createStatement();

            String insertQuery = "INSERT INTO TRANSACTION (transaction_id, order_id,transaction_date) VALUES("+transaction.getTransactionID()+","+transaction.getOrder().getOrderID()+", "+", "+transaction.getTransactionDate()+")";
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

    @Override
    public Transaction getTransaction(int transactionId) {
        int order_id = 0;
        Date transactionDate = null;



        Connection connection = openConnection();
        try {
            Statement selectStatement = connection.createStatement();

            String selectQuery = "SELECT * from TRANSACTION where transaction_id=" + transactionId;
            ResultSet resultSet = selectStatement.executeQuery(selectQuery);
            resultSet.next();

            order_id = resultSet.getInt("order_id");
            transactionDate = resultSet.getDate("transaction_date");

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }


        Order order = orderDAO.retrieveOrder(order_id);

        Transaction transaction = new TransactionImpl();
        transaction.setOrder(order);
        transaction.setTransactionDate(transactionDate);
        transaction.setTransactionID(transactionId);
        return transaction;
    }
}
