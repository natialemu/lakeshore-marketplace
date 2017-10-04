package Repository.Order;

import Domain.Order.OrderDetail;

import java.util.Date;

public interface OrderDetailDAO {
    OrderDetail getOrderDetail(Date orderCreated, int order_id);

    boolean createOrderDAO(OrderDetail orderDetail, int order_id);

}
