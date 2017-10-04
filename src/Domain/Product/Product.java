package Domain.Product;

public interface Product {
	public Partner getParner();
	public void setPartner(Partner partner)
	public ProductDetail getProductDetail();
	public void setProductDetail(String productName, long productID, double productCost, String productType, String productTag, String productPhoto);
