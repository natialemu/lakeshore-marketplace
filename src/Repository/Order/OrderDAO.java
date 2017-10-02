package Repository.Order;

import Domain.Order.Order;

import java.util.List;

public interface OrderDAO {
    List<Order> getAllOrders(int customerID);

}
