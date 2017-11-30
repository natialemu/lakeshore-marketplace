package Service.Representation.Order.Representation;

import java.util.List;
import java.util.Set;

import Service.Representation.AbstractRepresentationInterface;
import Service.Representation.Product.Representation.ProductRepresentation;

public interface OrderRepresentation extends AbstractRepresentationInterface {
	
	void setProductsInOrder(Set<ProductRepresentation> productsInOrder);
	Set<ProductRepresentation> getProductsInOrder();
	void setOrderDate(String orderDate);
	String getOrderDate();
	void setOrderCost(double orderCost);
	double getOrderCost();
	void setCustomerName(String customerName);
	String getCustomerName();
	void setOrderConfirmationNumber(int orderConfirmationNumber);
	int getOrderConfirmationNumber();

}
