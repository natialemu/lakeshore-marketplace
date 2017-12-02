package Service.Representation.Product.Representation;

import Service.Representation.AbstractRepresentationInterface;

public interface MinProductRepresentation extends AbstractRepresentationInterface {
	double getProductCost();
	void setProductCost(double productCost);
	void setProductName(String productName);
	String getProductName();
	void setProductType(String productType);
	String getProductType();
	void setRating(String rating);
	String getRating();
	int getProductID();
	void setProductID(int productID);

}
