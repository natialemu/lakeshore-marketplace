package Service;

import Domain.Customer.Customer;
import Domain.Product.Product;

import java.util.List;

public interface CustomerFaccade {

    Customer createCustomer();
    void registerACustomer(Customer customer,String email,String username, String password);
    void placeOrder(List<Product> productList, Customer customer);
    void cancelOrder(int orderConfirmationID);
    String getOrderStatus();
}
