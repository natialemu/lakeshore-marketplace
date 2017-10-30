package Service.Workflow.Product;

import java.util.Set;

import Domain.Product.ProductFactory;
import Domain.Product.ProductFactoryImpl;
import Service.Representation.Product.ProductRepresentation;
import Service.Representation.Product.ProductRequest;

public class ProductActivityImpl implements ProductAcitvity {
	private ProductFactory productFactory;
	
	public ProductActivityImpl() {
		productFactory = new ProductFactoryImpl();
	}

	@Override
	public Set<ProductRepresentation> filterProductByCost(Set<ProductRequest> products, double minCost,
			double maxCost) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<ProductRepresentation> filterProductByRating(Set<ProductRequest> products, int minRating,
			int maxRating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<ProductRepresentation> sortInAscendingOrder(Set<ProductRequest> products) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<ProductRepresentation> sortInDescendingOrder(Set<ProductRequest> products) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<ProductRepresentation> filterProductByDate(Set<ProductRequest> products, String date1, String date2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<ProductRepresentation> filterProductBySeller(Set<ProductRequest> products, String sellerName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<ProductRepresentation> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<ProductRepresentation> getProductByID(int productID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<ProductRepresentation> getProductBySeller(String sellerName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<ProductRepresentation> getProductByType(String productType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<ProductRepresentation> getProductsBySellerAndType(String sellerName, String productType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<ProductRepresentation> getProductsByName(String productType) {
		// TODO Auto-generated method stub
		return null;
	}

}
