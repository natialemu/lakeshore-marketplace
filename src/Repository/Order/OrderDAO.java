package Repository.Order;

import Domain.Order.Order;

import java.util.List;

public interface OrderDAO {
    List<Order> getAllOrders(int customerID);

    boolean createOrder(Order order);

    Order retrieveOrder(int confirmationID);

    void updateStatus(Order retrievedOrder, int confirmation_id);

	List<Order> getMostRecentOrders(int i);
}
