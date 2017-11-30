package Service.Resource.Product;

import java.util.*;

import javax.jws.WebService;

import Service.Representation.Product.*;
import Service.Representation.Product.Representation.ProductRepresentation;
import Service.Representation.Product.Request.ProductRequest;

@WebService
public interface ProductFilterService {
	
	Set<ProductRepresentation> filterProductByCost(Set<ProductRequest> products, double minCost, double maxCost);
	Set<ProductRepresentation> filterProductByRating(Set<ProductRequest> products, int minRating, int maxRating);
	Set<ProductRepresentation> sortOrders(Set<ProductRequest> products,boolean isAscending);
	Set<ProductRepresentation> filterProductByDate(Set<ProductRequest> products, String date1, String date2);
	Set<ProductRepresentation> filterProductBySeller(Set<ProductRequest> products, String sellerName);
	
	


}
