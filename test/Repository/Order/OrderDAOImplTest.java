package Repository.Order;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;

import Domain.Order.*;
import Domain.Product.*;
import Repository.Customer.CustomerDAO;
import Repository.Customer.CustomerDAOimpl;

import java.util.*;
import Domain.Customer.*;




class OrderDAOImplTest {
	
	private OrderDAO orderDAO;
	private CustomerDAO customerDAO;
	
	@BeforeEach
	public void setUp() {
		orderDAO = new OrderDAOImpl();
		customerDAO = new CustomerDAOimpl();
	}


    @Test
    void getAllOrders() {
    	
    }

    @Test
    void createOrder() {
      
      List<Product> products = new ArrayList<>();
    	//First product
      double product1Cost = 2000.0;
      String product1Name = "Surface book";
      String product1Type = "Laptop";
      String product1Tag = "expensive";
      String product1Photo = "surface.png";

      Product product1 = new ProductImpl(product1Cost,product1Name,product1Photo,product1Tag,product1Type);

      products.add(product1);

      // Second product
      double product2Cost = 1700.0;
      String product2Name = "Dell xps";
      String product2Type = "Laptop";
      String product2Tag = "High end";
      String product2Photo = "dell.png";

      Product product2 = new ProductImpl(product2Cost,product2Name,product2Photo,product2Tag,product2Type);

      products.add(product2);

      // Third product
      double product3Cost = 600.0;
      String product3Name = "Nokia Lumia 1520";
      String product3Type = "Smartphone";
      String product3Tag = "Premium";
      String product3Photo = "lumia.png";

      Product product3 = new ProductImpl(product3Cost,product3Name,product3Photo,product3Tag,product3Type);

      products.add(product3);
      
      Customer customer = customerDAO.getCustomer(66);
      
     
      OrderDetail orderDetail = new OrderDetailImpl(products,customer);
      Order order  = new OrderImpl(orderDetail);
    	
      orderDAO.createOrder(order);
    }

    @Test
    void retrieveOrder() {
    }

    @Test
    void updateStatus() {
    }

}