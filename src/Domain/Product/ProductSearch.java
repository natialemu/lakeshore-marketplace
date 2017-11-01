package Domain.Product;

import java.util.List;

public interface ProductSearch {
    List<Product> getAllProducts();


    Product searchProductByID(int productID);

    List<Product> searchProductsByName(String productName);

    List<Product> searchProductByType(String productType);


	List<Product> getProduct(int productID);


	List<Product> getProductBySeller(String sellerName);


	List<Product> getProductByType(String productType);


	List<Product> getProductsBySellerAndType(String sellerName, String productType);
}
