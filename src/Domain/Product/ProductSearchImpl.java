package Domain.Product;

import Repository.Product.ProductDAO;
import Repository.Product.ProductDAOImpl;

import java.util.ArrayList;
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
	@Override
	public List<Product> getProduct(int productID) {
		// TODO Auto-generated method stub
		List<Product> result = new ArrayList<>();
		Product returnedProduct = productDAO.getProductByID(productID);
		if(returnedProduct != null) {
			result.add(returnedProduct);
		}
		return result;
	}
	@Override
	public List<Product> getProductBySeller(String sellerName) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}
	@Override
	public List<Product> getProductByType(String productType) {
		return productDAO.getProductWithType(productType);
	}
	@Override
	public List<Product> getProductsBySellerAndType(String sellerName, String productType) {
		// TODO Auto-generated method stub
		return new ArrayList<>();
	}
	@Override
	public List<Product> getProductByName(String productName) {
		return productDAO.getProductsWithName(productName);

	}
	@Override
	public List<Product> getRecentlyAddedProducts(int numOrders) {
		return productDAO.getRecentlyAddedProducts(numOrders);
	}
	@Override
	public List<Product> getInventory(String username) {
		return productDAO.getInventory(username);
	}
}
