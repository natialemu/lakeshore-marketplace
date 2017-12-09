package Domain.Order;

import Domain.Customer.Customer;

import Domain.Order.OrderState.OrderState;
import Domain.Product.Product;


import java.util.List;

public interface OrderFactory {

   Order createOrder(List<Product> productList, Customer customer);

    Order cancelOrder(int confirmationID);

    String getOrderStatus(int orderID);

	Order getOrder(int orderID);

	List<Order> getMostRecentOrders(int numOrders);

	List<Order> getOrdersOfPartner(String partner_username);

}
