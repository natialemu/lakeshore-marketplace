package Repository.Product;

import Domain.Product.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> getProducts(int order_id);

}
