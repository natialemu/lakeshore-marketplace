package Domain.Product;

import java.util.List;

public interface ProductFilter {
    List<Product> filterProductByTag(List<Product> products);

    List<Product> sortProductsByName(List<Product> products);

    List<Product> sortProductsByPrice(List<Product> products);

    List<Product> sortProductsByRating(List<Product> products);

}
