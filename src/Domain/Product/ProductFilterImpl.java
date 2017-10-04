package Domain.Product;

import Repository.Product.ProductDAO;
import Repository.Product.ProductDAOImpl;

import java.util.List;

public class ProductFilterImpl implements ProductFilter {
	private ProductDAO productDAO;

	public ProductFilterImpl(){
		productDAO = new ProductDAOImpl();
	}

	@Override
	public List<Product> filterProductByTag(List<Product> products) {
		return products;
	}

	@Override
	public List<Product> sortProductsByName(List<Product> products) {
		return products;
	}

	@Override
	public List<Product> sortProductsByPrice(List<Product> products) {
		return products;
	}

	@Override
	public List<Product> sortProductsByRating(List<Product> products) {
		return products;
	}
}

