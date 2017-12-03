package Service.Representation.Product.Representation;

import Service.Representation.AbstractRepresentationInterface;

public interface ProductRepresentation extends MinProductRepresentation{
	

	void setProductTag(String productTag);
	String getProductTag();
	void setPartnerName(String partnerName);
	String getPartnerName();

	

}
