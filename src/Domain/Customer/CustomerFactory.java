package Domain.Customer;

public interface CustomerFactory {
    boolean createCustomer(Customer customer);
    Customer createCustomer();
	Customer getCustomer(int accountID);
	Customer getCustomerWithCustomerID(int customerID);
}
