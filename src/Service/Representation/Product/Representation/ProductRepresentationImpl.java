package Service.Representation.Product.Representation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import Service.Representation.AbstractRepresentation;

@XmlRootElement(name = "Product")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class ProductRepresentationImpl extends AbstractRepresentation implements ProductRepresentation {
    
    private double productCost;
    private String productName;
    private String productTag;
    private String productType;
    private String partnerName;
    private int productID;
    private String rating;
    
    @Override
    public int getProductID() {
    	return productID;
    }
    @Override
    public void setProductID(int productID) {
    	this.productID = productID;
    }
    
    
    public ProductRepresentationImpl() {}
    
	public double getProductCost() {
		return productCost;
	}
	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}
	
	public String getPartnerName() {
		return partnerName;
	}
	
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductTag() {
		return productTag;
	}
	public void setProductTag(String productTag) {
		this.productTag = productTag;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	@Override
	public void setRating(String rating) {

		this.rating = rating;
	}
	@Override
	public String getRating() {
		return rating;
	}
    
    
    
    
    
    

}
