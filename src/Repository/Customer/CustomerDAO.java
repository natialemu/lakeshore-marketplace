package Repository.Customer;

import Domain.Customer.Customer;

public interface CustomerDAO {
    boolean createCustomer(Customer customer);

    Customer getCustomer(int customer_id);
}
