package Domain.Order.OrderValidation;

import Domain.Order.Order;
import Domain.Product.Product;

import java.util.List;

public class OrderValidationImpl implements OrderValidation {
    @Override
    public boolean validateOrderContent(Order order) {
        return false;
    }

    @Override
    public boolean productExists(Product product) {
        return false;
    }

    @Override
    public boolean productsExit(List<Product> products) {
        return false;
    }
}
