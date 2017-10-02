package Domain.Order;

import java.util.List;

public interface OrderLog {
    List<Order> getOrderHistory();
    List<Order> getOrderHistory(int n);
}
