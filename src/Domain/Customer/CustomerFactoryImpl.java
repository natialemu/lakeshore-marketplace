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
    
    @Override
    public Customer createCustomer() {
        return new CustomerImpl();
    }
	@Override
	public Customer getCustomer(int accountID) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomerwithAccount(accountID);
	}
	@Override
	public Customer getCustomerWithCustomerID(int customerID) {
		// TODO Auto-generated method stub
		return customerDAO.getCustomer(customerID);
	}
}
