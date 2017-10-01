package Domain.Product;

public interface ProductDetail {
	
	void setProductName(String productName);
	void setProductID(long productID);
	void setProductCost(double cost);
	void setProductType(String productType);
	void setProductTag(String productTag);
	void setProductPhoto(String Photo);
	
	String getProductName();
	long getProductID();
	double getProductCost();
	String getProductType();
	String getProductTag();
	String getProductPhoto();
	
}