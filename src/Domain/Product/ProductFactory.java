package Domain.Product;

public interface ProductFactory {
	public boolean createProduct(String productName, double productCost, long productID, 
	String productType, String productTag, String productPhoto);
	
	public boolean deleteProduct(productID);
	
	public boolean updateProductName(long productID, String productName);
	
	public boolean updateProductCost(long productID, double productCost);
	
	public boolean updateProductType(long productID, String productType);
	
	public boolean updateProductTag(long productID, String productTag);
	
	public boolean updateProductPhoto(long productID, String productPhoto);
	
	public List<Product> retrieveProductList();
	
	public List<Product> sortProductListByProductName(List<Product> product, boolean order);
	
	public List<Product> sortProductListByProductID(List<Product> product, boolean order);
	
	public List<Product> sortProductListByProductType(List<Product> product, boolean order);
	
	public List<Product> sortProductListByProductTag(List<Product> product, boolean order);
	
	public List<Product> sortProductListByProductCost(List<Product> product, boolean order);
	
}
