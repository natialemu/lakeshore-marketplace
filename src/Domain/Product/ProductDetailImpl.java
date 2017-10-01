package Domain.Product;

public class ProductDetailImpl implements ProductDetail {
	private String productName;
	private long productID;
	private double productCost;
	private String productType;
	private String productTag;
	private String productPhoto;
	
	public String getProductName() {
		return this.productName = productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public long getProductID() {
		return this.productID;
	}
	
	public void setProductID(long productID) {
		this.productID = productID;
	}
	
	public double getProductCost() {
		return this.productCost;
	}
	
	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}
	
	public String getProductType() {
		return this.productType;
	}
	
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	public String getProductTag() {
		return this.productTag;
	}
	
	public void setProductTag(String productTag) {
		this.productTag = productTag;
	}
	
	public String getProductPhoto() {
		return this.productPhoto;
	}

	public void setProductPhoto(String productPhoto) {
		this.productPhoto = productPhoto;
	}
	
	@Override
	public String toString() {
		return "ProductDetail{" + 
				"productName='" + productName + '\'' +
				", productID='" + productID + '\'' +
				", productCost'" + productCost + '\'' +
				", productType'" + productType + '\'' +
				", productTag'" + productTag + '\'' +
				", productPhoto'" + productPhoto + '\'' +
				'}';
	}
}