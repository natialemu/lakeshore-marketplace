package Domain.Partner;

import Domain.Product.Product;

import java.util.List;

public interface Inventory {
    List<Product> getProductList();
    void setProductList(List<Product> productList);
    void addProduct(Product product);
    void addProducts(List<Product> products);
    void removeProduct(Product product);
}
