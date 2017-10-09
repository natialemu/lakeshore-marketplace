package Domain.Customer;

import Repository.Customer.CustomerDAO;
import Repository.Customer.CustomerDAOimpl;

public class CustomerFactoryImpl implements CustomerFactory {
    private CustomerDAO customerDAO;

    public CustomerFactoryImpl(){
        customerDAO = new CustomerDAOimpl();
    }
    @Override
    public boolean createCustomer(Customer customer) {
        return customerDAO.createCustomer(customer);
    }
}
