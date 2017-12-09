package Repository.Account.AccountProfileDAO;

import Domain.Account.AccountProfile.Contact.Location;
import Domain.Account.AccountProfile.Contact.LocationImpl;
import Domain.Account.AccountProfile.Finance.CreditCard;
import Domain.Account.AccountProfile.Finance.PaymentCard;

import java.sql.*;

public class PaymentCardDAOImpl implements PaymentCardDAO {
    @Override
    public boolean createPaymentCardProfile(String cardHolderName, String cardNumber, String cardExpirationDate, int securityNumber) {
        boolean inserted = false;
        Connection connection = openConnection();
        try{ 
            Statement insertSatement = connection.createStatement();

            String insertQuery = "INSERT INTO payment_card (card_number,card_holder_name,security_code,expriation_date) VALUES("+Long.parseLong(cardNumber)+", '"+cardHolderName+"', "+securityNumber+", '"+cardExpirationDate+"')";
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

    private Connection openConnection() {
        Connection connection = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/lakeshore_market", "root", "Natlocus13");


        } catch (Exception exception) {
            exception.printStackTrace();
            //exception.printStackTrace();

        }

        return connection;

    }

    @Override
    public boolean updatePaymentCard(String cardNumber, String expirationDate, String cardHolderName, int securityCode) {
        return createPaymentCardProfile(cardHolderName,cardNumber,expirationDate,securityCode);
    }

    @Override
    public PaymentCard getPaymentCard(String cardNumber) {
        int securityCode = 0;
        String cardHolderName = null;
        String expirationDate = null;

        Connection connection = openConnection();
        try {
            Statement selectStatement = connection.createStatement();

            String selectQuery = "SELECT * from payment_card where card_number=" + cardNumber;
            ResultSet resultSet = selectStatement.executeQuery(selectQuery);
            resultSet.next();
            cardHolderName = resultSet.getString("card_holder_name");
            securityCode = resultSet.getInt("security_code");
            expirationDate = resultSet.getString("expriation_date");


        } catch (SQLException se) {
            se.printStackTrace();
        } finally {

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }


        PaymentCard paymentCard = new CreditCard();
        paymentCard.setCardSecurityNumber(securityCode);
        paymentCard.setCardExpirationDate(expirationDate);
        paymentCard.setCardNumber(cardNumber);
        paymentCard.setCardHolderName(cardHolderName);

        return paymentCard;
    }
}
