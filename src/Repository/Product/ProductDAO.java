package Repository.Product;

import Domain.Product.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> getProducts();
    List<Product> getProductsWithName(String productName);
    List<Product> getProductWithType(String productType);
    Product getProductByID(int productID);
    void createProduct(Product product);


    void setOrderID(Product p, int orderID);
	List<Product> getRecentlyAddedProducts(int numOrders);
}
