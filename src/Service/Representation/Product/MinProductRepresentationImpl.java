package Service.Representation.Product;

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
	@Override
	public double getProductCost() {
		// TODO Auto-generated method stub
		return productCost;
	}

	@Override
	public void setProductCost(double productCost) {
		// TODO Auto-generated method stub
		this.productCost = productCost; 
		
	}

	@Override
	public void setProductName(String productName) {
		// TODO Auto-generated method stub
		this.productName = productName;
		
	}

	@Override
	public String getProductName() {
		// TODO Auto-generated method stub
		return productName;
	}

	@Override
	public void setProductType(String productType) {
		// TODO Auto-generated method stub
		this.productType = productType;
		
	}

	@Override
	public String getProductType() {
		// TODO Auto-generated method stub
		return productType;
	}

	@Override
	public void setRating(String rating) {
		// TODO Auto-generated method stub
		this.rating = rating;
		
	}

	@Override
	public String getRating() {
		// TODO Auto-generated method stub
		return rating;
	}



}
