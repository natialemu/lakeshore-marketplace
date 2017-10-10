package Service;

import Domain.Account.Account;
import Domain.Account.AccountFactory;
import Domain.Account.AccountFactoryImpl;
import Domain.Customer.Customer;
import Domain.Customer.CustomerFactory;
import Domain.Customer.CustomerFactoryImpl;
import Domain.Customer.CustomerImpl;
import Domain.Order.OrderFactory;
import Domain.Order.OrderFactoryImpl;
import Domain.Product.Product;
import Domain.ReviewSystem.ReviewSystemImpl;

import java.util.List;

public class CustomerFacadeImpl implements CustomerFaccade {
    private AccountFactory accountFactory;
    private CustomerFactory customerFactory;
    private OrderFactory orderFactory;

    public CustomerFacadeImpl(){
        accountFactory = new AccountFactoryImpl();
        customerFactory = new CustomerFactoryImpl();
        orderFactory = new OrderFactoryImpl();
    }

    @Override
    public Customer createCustomer() {
        return new CustomerImpl();
    }

    @Override
    public void registerACustomer(Customer customer, String email, String username, String password) {

        Account newAccount = accountFactory.getNewAccount(email,username,password);
        accountFactory.createBasicAccount(newAccount);
        customer.setAccount(newAccount);
        customer.setReviewSystem(new ReviewSystemImpl());
        customerFactory.createCustomer(customer);



    }

    @Override
    public void placeOrder(List<Product> productList, Customer customer) {
        orderFactory.createOrder(productList,customer);
    }

    @Override
    public void cancelOrder(int orderConfirmationID) {
        orderFactory.cancelOrder(orderConfirmationID);
    }

    @Override
    public String getOrderStatus() {
        return orderFactory.getOrderStatus();
    }
}
