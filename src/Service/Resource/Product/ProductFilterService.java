package Service.Resource.Product;

import java.util.*;

import Service.Representation.Product.*;

public interface ProductFilterService {
	
	
	
	
	Set<ProductRepresentation> filterProductByCost(Set<ProductRequest> products, double minCost, double maxCost);
	
	
	Set<ProductRepresentation> filterProductByRating(Set<ProductRequest> products, int minRating, int maxRating);
	Set<ProductRepresentation> sortInAscendingOrder(Set<ProductRequest> products);
	Set<ProductRepresentation> sortInDescendingOrder(Set<ProductRequest> products);
	Set<ProductRepresentation> filterProductByDate(Set<ProductRequest> products, String date1, String date2);
	Set<ProductRepresentation> filterProductBySeller(Set<ProductRequest> products, String sellerName);
	
	


}
