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

	
	public List<Product> retrieveAllProductList();

	
	public List<Product> sortProductListByProductName(List<Product> products, boolean order);
	
	public List<Product> sortProductListByProductID(List<Product> products, boolean order);
	
	public List<Product> sortProductListByProductType(List<Product> products, boolean order);
	
	public List<Product> sortProductListByProductTag(List<Product> products, boolean order);
	
	public List<Product> sortProductListByProductCost(List<Product> products, boolean order);
	
	
	public List<Product> filterProductListByProductName(List<Product> products, String productName, boolean order);
	
	public List<Product> filterProductListByProductID(List<Product> products, long productID, boolean order);
	
	public List<Product> filterProductListByProductType(List<Product> products, String productType, boolean order);
	
	public List<Product> filterProductListByProductTag(List<Product> products, String productTag, boolean order);
	
	public List<Product> filterProductListByProductCost(List<Product> products, double productCost, boolean order);
	
	
	public List<Product> searchProductListByProductName(List<Product> products, String productName);
	
	public Product searchProductListByProductID(List<Product> products, long productID);
	
	public List<Product> searchProductListByProductType(List<Product> products, String productType);
	
	public List<Product> searchProductListByProductTag(List<Product> products, String productTag);
	
	public List<Product> searchProductListByProductCost(List<Product> products, double productCost);
}
