package Service.Representation.Product.Representation;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import Service.Representation.AbstractRepresentation;
import Service.Representation.Link;

@XmlRootElement(name = "Product")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class MinProductRepresentationImpl extends AbstractRepresentation implements MinProductRepresentation {

	private double productCost;
    private String productName;
    private String productType;
    private String rating;
    private int productID;
	@Override
	public double getProductCost() {
		return productCost;
	}

	@Override
	public void setProductCost(double productCost) {
		this.productCost = productCost; 
		
	}

	@Override
	public void setProductName(String productName) {
		this.productName = productName;
		
	}

	@Override
	public String getProductName() {
		return productName;
	}

	@Override
	public void setProductType(String productType) {
		this.productType = productType;
		
	}

	@Override
	public String getProductType() {
		return productType;
	}

	@Override
	public void setRating(String rating) {
		this.rating = rating;
		
	}

	@Override
	public String getRating() {
		return rating;
	}

	@Override
	public int getProductID() {
		return productID;
	}

	@Override
	public void setProductID(int productID) {
		this.productID = productID;
	}



}
