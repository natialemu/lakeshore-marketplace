package Service.Resource.Product;

import java.util.*;

import javax.jws.WebService;

import Service.Representation.Product.*;
import Service.Representation.Product.Representation.ProductRepresentation;
import Service.Representation.Product.Representation.ProductRepresentationImpl;
import Service.Representation.Product.Request.ProductRequest;
import Service.Representation.Product.Request.ProductRequestImpl;

@WebService
public interface ProductFilterService {
	
	Set<ProductRepresentationImpl> filterProductByCost(Set<ProductRequestImpl> products, double minCost, double maxCost);
	Set<ProductRepresentationImpl> filterProductByRating(Set<ProductRequestImpl> products, int minRating, int maxRating);
	Set<ProductRepresentationImpl> sortOrders(Set<ProductRequestImpl> products,boolean isAscending);
	Set<ProductRepresentationImpl> filterProductByDate(Set<ProductRequestImpl> products, String date1, String date2);
	Set<ProductRepresentationImpl> filterProductBySeller(Set<ProductRequestImpl> products, String sellerName);
	
	


}
