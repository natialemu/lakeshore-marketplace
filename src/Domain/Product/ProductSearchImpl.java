package Domain.Product;

import Repository.Product.ProductDAO;
import Repository.Product.ProductDAOImpl;

import java.util.List;

public class ProductSearchImpl implements ProductSearch{
    private ProductDAO productDAO;

    public ProductSearchImpl(){
        productDAO = new ProductDAOImpl();
    }
    @Override
    public List<Product> getAllProducts() {
        return productDAO.getProducts();
    }

    @Override
    public Product searchProductByID(int productID) {
        return productDAO.getProductByID(productID);
    }

    @Override
    public List<Product> searchProductsByName(String productName) {
        return productDAO.getProductsWithName(productName);
    }

    @Override
    public List<Product> searchProductByType(String productType) {
        return productDAO.getProductWithType(productType);
    }
}
