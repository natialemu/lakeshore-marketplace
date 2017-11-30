package Service.Workflow.Product;

import java.util.Set;

import Service.Representation.Product.MinProductRepresentation;
import Service.Representation.Product.ProductRepresentation;
import Service.Representation.Product.ProductRequest;

public interface ProductAcitvity {

	Set<ProductRepresentation> filterProductByCost(Set<ProductRequest> products, double minCost, double maxCost);

	Set<ProductRepresentation> filterProductByRating(Set<ProductRequest> products, int minRating, int maxRating);

	Set<ProductRepresentation> sortInAscendingOrder(Set<ProductRequest> products);

	Set<ProductRepresentation> sortInDescendingOrder(Set<ProductRequest> products);

	Set<ProductRepresentation> filterProductByDate(Set<ProductRequest> products, String date1, String date2);

	Set<ProductRepresentation> filterProductBySeller(Set<ProductRequest> products, String sellerName);

	Set<MinProductRepresentation> getAllProducts();

	Set<ProductRepresentation> getProductByID(int productID);

	Set<ProductRepresentation> getProductBySeller(String sellerName);

	Set<MinProductRepresentation> getProductByType(String productType);

	Set<MinProductRepresentation> getProductsBySellerAndType(String sellerName, String productType);

	Set<MinProductRepresentation> getProductsByName(String productType);

	void addProduct(String username, Set<ProductRequest> products);

	void deleteProduct(int partner_id, int product_id);

}
