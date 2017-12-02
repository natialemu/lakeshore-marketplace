package Domain.Product;

import Repository.Product.ProductDAO;

import java.util.List;

public interface ProductFactory {
    void setProductFilter(ProductFilter productFilter);
    ProductSearch getProductSearch();
    void setProductSearch(ProductSearch productSearch);
    ProductDAO getProductDAO();
    void setProductDAO(ProductDAO productDAO);
    ProductFilter getProductFilter();

    List<Product> getAllProducts();
    Product searchProductByID(int productID);
    List<Product> searchProductsByName(String productName);
    List<Product> searchProductByType(String productType);
    List<Product> filterProductByTag(List<Product> products);
    List<Product> sortProductsByName(List<Product> products,boolean order);
    List<Product> sortProductsByPrice(List<Product> products);
    List<Product> sortProductsByRating(List<Product> products);
    void createProduct(Product product);
	List<Product> filterProductByCost(List<Product> productList, double minCost, double maxCost);
	List<Product> filterProductByRating(List<Product> productList, int minRating, int maxRating);
	List<Product> filterProductByDate(List<Product> productList, String date1, String date2);
	List<Product> filterProductBySeller(List<Product> productList, String sellerName);
	List<Product> getProduct(int productID);
	List<Product> getProductBySeller(String sellerName);
	List<Product> getProductByType(String productType);
	List<Product> getProductsBySellerAndType(String sellerName, String productType);
	List<Product> getProductsByName(String productType);
	List<Product> getRecentlyAddedProducts(int numOrders);

	
	





}
