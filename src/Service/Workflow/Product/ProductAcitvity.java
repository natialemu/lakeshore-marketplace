package Service.Workflow.Product;

import java.util.Set;

import Service.Representation.Account.Representation.AccountValidationRepresentation;
import Service.Representation.Account.Representation.AccountValidationRepresentationImpl;
import Service.Representation.Product.Representation.MinProductRepresentation;
import Service.Representation.Product.Representation.MinProductRepresentationImpl;
import Service.Representation.Product.Representation.ProductRepresentation;
import Service.Representation.Product.Representation.ProductRepresentationImpl;
import Service.Representation.Product.Request.ProductRequest;
import Service.Representation.Product.Request.ProductRequestImpl;

public interface ProductAcitvity {

	Set<ProductRepresentationImpl> filterProductByCost(Set<ProductRequestImpl> products, double minCost, double maxCost);

	Set<ProductRepresentationImpl> filterProductByRating(Set<ProductRequestImpl> products, int minRating, int maxRating);

	Set<ProductRepresentationImpl> sortInAscendingOrder(Set<ProductRequestImpl> products);

	Set<ProductRepresentationImpl> sortInDescendingOrder(Set<ProductRequestImpl> products);

	Set<ProductRepresentationImpl> filterProductByDate(Set<ProductRequestImpl> products, String date1, String date2);

	Set<ProductRepresentationImpl> filterProductBySeller(Set<ProductRequestImpl> products, String sellerName);

	Set<MinProductRepresentationImpl> getAllProducts();

	Set<ProductRepresentationImpl> getProductByID(int productID);

	Set<ProductRepresentationImpl> getProductBySeller(String sellerName);

	Set<MinProductRepresentationImpl> getProductByType(String productType);

	Set<MinProductRepresentationImpl> getProductsBySellerAndType(String sellerName, String productType);

	Set<MinProductRepresentationImpl> getProductsByName(String productType);

	AccountValidationRepresentationImpl addProduct(String username, Set<ProductRequestImpl> products);

	AccountValidationRepresentationImpl deleteProduct(int partner_id, int product_id);

	Set<MinProductRepresentationImpl> getRecentlyAddedProducts(int numOrders);

	Set<MinProductRepresentationImpl> getInventory(String username);

}
