package Service.Representation.Product.Request;

public interface ProductRequest {
	double getProductCost();
	void setProductCost(double productCost);
	void setProductName(String productName);
	String getProductName();
	void setProductTag(String productTag);
	String getProductTag();
	void setProductType(String productType);
	String getProductType();
}