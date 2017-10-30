package Service.Resource.Product;

import java.util.Set;

import Service.Representation.Product.ProductRepresentation;

public interface ProductSearchService {
	
	Set<ProductRepresentation> getProducts();
	Set<ProductRepresentation> getProductByID(int productID);

	Set<ProductRepresentation> getProductsBySeller(String sellerName);

	Set<ProductRepresentation> getProductsByType(String productType);

	Set<ProductRepresentation> getProductsBySellerAndType(String sellerName, String productType);
	Set<ProductRepresentation> getProductsByName(String productName);


	


}
