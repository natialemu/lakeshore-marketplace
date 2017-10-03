package Domain.Order;

import Domain.Customer.Customer;
import Domain.Customer.CustomerImpl;
import Repository.Order.OrderDAO;
import Repository.Order.OrderDAOImpl;

import java.util.List;

public class OrderLogImpl implements OrderLog{
    private OrderDAO orderDAO;
    private Customer customer;

    @Override
    public String toString() {
        return "OrderLogImpl{" +
                "orderDAO=" + orderDAO +
                ", customer=" + customer +
                '}';
    }

    public OrderDAO getOrderDAO() {
        return orderDAO;
    }

    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public OrderLogImpl(Customer customer){
        orderDAO = new OrderDAOImpl();
        this.customer = new CustomerImpl();
    }
    @Override
    public List<Order> getOrderHistory() {
        return orderDAO.getAllOrders(customer.getCustomerID());
    }

    @Override
    public List<Order> getOrderHistory(int n) {
        List<Order> allOrders = orderDAO.getAllOrders(customer.getCustomerID());
        return getMostNOrders(allOrders);
    }

    private List<Order> getMostNOrders(List<Order> allOrders) {
        //TODO: implement this
        return allOrders;
    }
}
