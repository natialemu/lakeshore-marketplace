package Domain.Product;

public class ProductFactoryImpl implements ProductFactory {
	private Product product;
	private List<Product> products;
	private ProductSearch productsearch;
	private ProductFilter productSort;
	
	public boolean createProduct(String productName, double productCost, long productID, 
		String productType, String productTag, String productPhoto){
							
		product = new ProductImpl(productName, productCost, productID, productType. productTag, productPhoto);
		//need DAO implementation
		return true;
	}
	
	public boolean deleteProduct(long productID){
		//need product delete implementation
		return true;
	}
	
	public boolean updateProductName(long productID, String productName){/*retrieve from list using id, replace name*/ return true;}
	
	public boolean updateProductCost(long productID, double productCost){/*retrieve from list using id, replace cost*/ return true;}
	
	public boolean updateProductType(long productID, String productType){/*retrieve from list using id, replace type*/ return true;}
	
	public boolean updateProductTag(long productID, String productTag){/*retrieve from list using id, replace tag*/ return true;}
	
	public boolean updateProductPhoto(long productID, String productPhoto){/*retrieve from list using id, replace photo*/ return true;}
	
	public List<Product> retrieveAllProductList(){/*get data form DAO*/ return products; }
	
	public List<Product> sortProductListByProductName(List<Product> products, boolean order){return products.productSortByName(products, order);}
	
	public List<Product> sortProductListByProductID(List<Product> products, boolean order){return products.productSortByID(products, order);}
	
	public List<Product> sortProductListByProductType(List<Product> products, boolean order){return products.productSortByType(products, order);}
	
	public List<Product> sortProductListByProductTag(List<Product> products, boolean order){return products.productSortByTag(products, order);}
	
	public List<Product> sortProductListByProductCost(List<Product> products, boolean order){return products.productSortByCost(products, order);}
	
	public List<Product> filterProductListByProductName(List<Product> products, String productName, boolean order){return products.productFilterByName(products,productName,order);}
	
	public List<Product> filterProductListByProductID(List<Product> products, long productID, boolean order){return products.productFilterByID(products,productID, order);}
	
	public List<Product> filterProductListByProductType(List<Product> products, String productType, boolean order){return products.productFilterByType(products,productType,order);}
	
	public List<Product> filterProductListByProductTag(List<Product> products, String productTag, boolean order){return products.productFilterByTag(products,productTag, order);}
	
	public List<Product> filterProductListByProductCost(List<Product> products, double productCost, boolean order){return products.productFilterByCost(products,productCost, order);}
	
	
	public List<Product> searchProductListByProductName(List<Product> products, String productName){return products.productSortByCost(products, productName);}
	
	public Product searchProductListByProductID(List<Product> products, long productID){return products.productSortByCost(products, productID);}
	
	public List<Product> searchProductListByProductType(List<Product> products, String productType){return products.productSortByCost(products, productType);}
	
	public List<Product> searchProductListByProductTag(List<Product> products, String productTag){return products.productSortByCost(products, productTag);}
	
	public List<Product> searchProductListByProductCost(List<Product> products, double productCost){return products.productSortByCost(products, productCost);}
}