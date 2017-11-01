package Domain.Product;

import java.util.List;

public interface ProductFilter {
    List<Product> filterProductByTag(List<Product> products);

    List<Product> sortProductsByName(List<Product> products,boolean order);

    List<Product> sortProductsByPrice(List<Product> products);

    List<Product> sortProductsByRating(List<Product> products);

	List<Product> filterProductByCost(List<Product> productList, double minCost, double maxCost);

	List<Product> filterProductByRating(List<Product> productList, int minRating, int maxRating);

	List<Product> filterProductByDate(List<Product> productList, String date1, String date2);

	List<Product> filterProductBySeller(List<Product> productList, String sellerName);
	

}
