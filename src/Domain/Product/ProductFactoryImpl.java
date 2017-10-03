package Domain.Product;

public class ProductFactoryImpl {
	private Product product;
	private Filter filter;
	private Partner partner;
	
	public boolean createProduct(String productName, double productCost, long productID, 
		String productType, String productTag, String productPhoto){
							
		product = new ProductImpl();
		return true;
		
	}
	
	public boolean deleteProduct(Product product){
		//product delete implementation
		return true;
	}
	
	public boolean updateProduct(Product product, String productName, double productCost, 
		long productID, String productType, String productTag, String productPhoto){
		
		product.setProductDetail(product, productName, productCost, productID, productType, productTag, productPhoto);
		}
	}
}