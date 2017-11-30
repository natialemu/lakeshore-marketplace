package Service.Representation.Product.Representation;

import Service.Representation.AbstractRepresentationInterface;

public interface ProductRepresentation extends AbstractRepresentationInterface{
	
	double getProductCost();
	void setProductCost(double productCost);
	void setProductName(String productName);
	String getProductName();
	void setProductTag(String productTag);
	String getProductTag();
	void setProductType(String productType);
	String getProductType();
	void setPartnerName(String partnerName);
	String getPartnerName();
	

}
