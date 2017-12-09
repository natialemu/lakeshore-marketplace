package Domain.Order;

import Domain.Customer.Customer;
import Domain.Partner.Partner;
import Domain.Product.Product;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface OrderDetail {
    List<Product> getProductByPartner(Partner partner);
    void setCustomer(Customer customer);
    Customer getCustomer();
    void setTotalCost(double totalCost);
    double getTotalCost();
    void setOrderCreated(Date orderCreated);
    Date getOrderCreated();
    void setMapProductCount(Map<Product, Integer> mapProductCount);
    Map<Product, Integer> getMapProductCount();
    void setMapProductInOrder(Map<Partner, List<Product>> mapProductInOrder);
    Map<Partner, List<Product>> getMapProductInOrder();

    List<Product> getAllProducts();

    List<Partner> getAllPartners();
	int getDetailID();


}
