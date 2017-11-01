package Service.Representation.Order;

import java.util.List;

import Service.Representation.Product.ProductRequest;

public interface OrderRequest {
	String getUsername();
	void setUsername(String username);
	String getOrderDate();
	void setOrderDate(String orderDate);
	List<ProductRequest> getProductsInOrder();
	void setProductsInOrder(List<ProductRequest> productsInOrder);
}