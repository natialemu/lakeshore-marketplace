package Domain.Product;

public interface ProductFactory {
	public boolean createProduct(String productName, double productCost, long productID, 
	String productType, String productTag, String productPhoto);
	
	public boolean deleteProduct(Product product);
	
	public boolean updateProduct(Product product, String productName, double productCost, 
	long productID, String productType, String productTag, String productPhoto);
	
}