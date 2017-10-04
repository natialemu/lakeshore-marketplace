package Domain.Order.OrderValidation;

import Domain.Order.Order;
import Domain.Product.Product;

import java.util.List;

public interface OrderValidation {
    boolean validateOrderContent(Order order);
    boolean productExists(Product product);
    boolean productsExit(List<Product> products);

}
