package Domain.Product;

import Domain.Partner.Partner;

public interface Product {
	Partner getParner();

	void setPartner(Partner partner);

	void setProductName(String productName);

	void setProductID(int productID);

	void setProductCost(double productCost);

	void setProductType(String productType);

	void setProductTag(String productTag);

	void setProductPhoto(String Photo);

	String getProductName();

	int getProductID();

	double getProductCost();

	String getProductType();

	String getProductTag();

	String getProductPhoto();
}
