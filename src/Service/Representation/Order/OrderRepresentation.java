package Service.Representation.Order;

import java.util.List;

import Service.Representation.Product.ProductRepresentation;

public interface OrderRepresentation {
	
	void setProductsInOrder(List<ProductRepresentation> productsInOrder);
	List<ProductRepresentation> getProductsInOrder();
	void setOrderDate(String orderDate);
	String getOrderDate();
	void setOrderCost(double orderCost);
	double getOrderCost();
	void setCustomerName(String customerName);
	String getCustomerName();
	void setOrderConfirmationNumber(int orderConfirmationNumber);
	int getOrderConfirmationNumber();

}
