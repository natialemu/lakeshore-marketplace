package Domain.Product;

import java.util.List;

public interface ProductSearch {
    List<Product> getAllProducts();


    Product searchProductByID(int productID);

    List<Product> searchProductsByName(String productName);

    List<Product> searchProductByType(String productType);
}
