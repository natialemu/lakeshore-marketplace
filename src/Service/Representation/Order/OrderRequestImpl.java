package Service.Representation.Order;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import Service.Representation.Product.ProductRepresentation;
import Service.Representation.Product.ProductRequest;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class OrderRequestImpl implements OrderRequest{
	private String username;
	private String orderDate;
	private List<ProductRequest> productsInOrder;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public List<ProductRequest> getProductsInOrder() {
		return productsInOrder;
	}

	public void setProductsInOrder(List<ProductRequest> productsInOrder) {
		this.productsInOrder = productsInOrder;
	}

	public OrderRequestImpl() {}
	
	
}