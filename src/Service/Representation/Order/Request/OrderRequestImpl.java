package Service.Representation.Order.Request;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import Service.Representation.Product.Representation.ProductRepresentation;
import Service.Representation.Product.Request.ProductRequest;
import Service.Representation.Product.Request.ProductRequestImpl;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class OrderRequestImpl implements OrderRequest{
	private String username;
	private String orderDate;
	private Set<ProductRequestImpl> productsInOrder;
	
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

	public Set<ProductRequestImpl> getProductsInOrder() {
		return productsInOrder;
	}

	public void setProductsInOrder(Set<ProductRequestImpl> productsInOrder) {
		this.productsInOrder = productsInOrder;
	}

	public OrderRequestImpl() {
		Date currentDate = new Date();
		orderDate =  new SimpleDateFormat("yyyyMMdd").format(currentDate);
		
	}
	
	
}