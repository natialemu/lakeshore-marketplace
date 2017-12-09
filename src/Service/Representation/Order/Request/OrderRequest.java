package Service.Representation.Order.Request;

import java.util.List;
import java.util.Set;

import Service.Representation.Product.Request.ProductRequest;
import Service.Representation.Product.Request.ProductRequestImpl;

public interface OrderRequest {
	String getUsername();
	void setUsername(String username);
	String getOrderDate();
	void setOrderDate(String orderDate);
	Set<ProductRequestImpl> getProductsInOrder();
	void setProductsInOrder(Set<ProductRequestImpl> productsInOrder);
}