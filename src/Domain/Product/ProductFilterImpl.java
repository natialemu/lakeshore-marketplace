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
	public List<Product> sortProductsByName(List<Product> products,boolean order) {
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

	@Override
	public List<Product> filterProductByCost(List<Product> productList, double minCost, double maxCost) {
		// TODO Auto-generated method stub
		return productList;
	}

	@Override
	public List<Product> filterProductByRating(List<Product> productList, int minRating, int maxRating) {
		// TODO Auto-generated method stub
		return productList;
	}

	@Override
	public List<Product> filterProductByDate(List<Product> productList, String date1, String date2) {
		// TODO Auto-generated method stub
		return productList;
	}

	@Override
	public List<Product> filterProductBySeller(List<Product> productList, String sellerName) {
		// TODO Auto-generated method stub
		return productList;
	}
}

