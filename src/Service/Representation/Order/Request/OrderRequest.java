package Service.Representation.Order.Request;

import java.util.List;
import java.util.Set;

import Service.Representation.Product.Request.ProductRequest;

public interface OrderRequest {
	String getUsername();
	void setUsername(String username);
	String getOrderDate();
	void setOrderDate(String orderDate);
	Set<ProductRequest> getProductsInOrder();
	void setProductsInOrder(Set<ProductRequest> productsInOrder);
}