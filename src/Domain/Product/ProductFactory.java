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
    List<Product> sortProductsByName(List<Product> products);
    List<Product> sortProductsByPrice(List<Product> products);
    List<Product> sortProductsByRating(List<Product> products);
    void createProduct(Product product);





}
