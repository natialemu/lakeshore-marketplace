package Domain.Product;
import Domain.Partner.Partner;
import Domain.Tools.IDGenerator;

import java.util.Comparator;

public class ProductImpl implements Product {
	private Partner partner;
	private int productID;
	private String productName;
	private double productCost;

	public ProductImpl(double productCost, String productName, String productPhoto, String productTag, String productType){
	    this.productPhoto = productPhoto;
	    this.productID = IDGenerator.getId();
	    this.productCost = productCost;
	    this.productName = productName;
	    this.productTag = productTag;
	    this.productType = productType;
    }


    public ProductImpl(){
	    //Does nothing
    }
    @Override
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    @Override
    public String getProductName() {
        return productName;
    }

    @Override
    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public double getProductCost() {
        return productCost;
    }

    @Override
    public void setProductCost(double productCost) {
        this.productCost = productCost;
    }

    @Override
    public String getProductType() {
        return productType;
    }

    @Override
    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Override
    public String getProductPhoto() {
        return productPhoto;
    }

    @Override
    public void setProductPhoto(String productPhoto) {
        this.productPhoto = productPhoto;
    }

    @Override
    public String getProductTag() {
        return productTag;
    }

    @Override
    public void setProductTag(String productTag) {
        this.productTag = productTag;
    }

    private String productType;
	private String productPhoto;
	private String productTag;

	
	public Partner getParner(){
		return this.partner;
	}
	
	public void setPartner(Partner partner){
		this.partner = partner;
	}

}

