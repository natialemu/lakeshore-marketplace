package Service.Workflow.Product;

import java.util.*;

import Domain.Partner.Partner;
import Domain.Partner.PartnerFactory;
import Domain.Partner.PartnerFactoryImpl;
import Domain.Partner.PartnerImpl;
import Domain.Product.Product;
import Domain.Product.ProductFactory;
import Domain.Product.ProductFactoryImpl;
import Domain.Product.ProductImpl;
import Service.Representation.Product.MinProductRepresentation;
import Service.Representation.Product.MinProductRepresentationImpl;
import Service.Representation.Product.ProductRepresentation;
import Service.Representation.Product.ProductRepresentationImpl;
import Service.Representation.Product.ProductRequest;

public class ProductActivityImpl implements ProductAcitvity {
	private ProductFactory productFactory;
	private PartnerFactory partnerFactory;
	
	public ProductActivityImpl() {
		productFactory = new ProductFactoryImpl();
		partnerFactory = new PartnerFactoryImpl();
	}

	@Override
	public Set<ProductRepresentation> filterProductByCost(Set<ProductRequest> products, double minCost,
			double maxCost) {
		// TODO Auto-generated method stub
		List<Product> productList = new ArrayList<>();
		getProductList(products,productList);
		List<Product> filteredProduct = productFactory.filterProductByCost(productList,minCost,maxCost);
		Set<ProductRepresentation> productRepresentation = new HashSet<>();
		
		convertToDetailedProductRepresentation(filteredProduct,productRepresentation);
		return productRepresentation;
	}

	private void convertToDetailedProductRepresentation(List<Product> filteredProduct,
			Set<ProductRepresentation> productRepresentation) {
		
	
		
			// TODO Auto-generated method stub
			for(Product p: filteredProduct) {
				ProductRepresentation prep = new ProductRepresentationImpl();
				prep.setProductCost(p.getProductCost());
				prep.setProductName(p.getProductName());
				prep.setProductType(p.getProductType());
				prep.setProductTag(p.getProductTag());
				prep.setPartnerName(p.getParner().getPartnerUsername());
			
				productRepresentation.add(prep);
			}
		// TODO Auto-generated method stub
		
	}

	private void convertToProductRepresentation(List<Product> filteredProduct,
			Set<MinProductRepresentation> productRepresentation) {
		// TODO Auto-generated method stub
		for(Product p: filteredProduct) {
			MinProductRepresentation prep = new MinProductRepresentationImpl();
			prep.setProductCost(p.getProductCost());
			prep.setProductName(p.getProductName());
			prep.setProductType(p.getProductType());
			prep.setRating("UNRATED");
			
			productRepresentation.add(prep);
		}
		
	}

	private void getProductList(Set<ProductRequest> products,List<Product> productList) {
		
		//double productCost, String productName, String productTag, String productTyp
		
		// TODO: will depend on what the request methods contain
		
		for(ProductRequest pr: products) {
			Product newProduct = new ProductImpl(pr.getProductCost(),pr.getProductName(),pr.getProductTag(),pr.getProductType());
			productList.add(newProduct);
		}
		
	}

	@Override
	public Set<ProductRepresentation> filterProductByRating(Set<ProductRequest> products, int minRating,
			int maxRating) {
		
		List<Product> productList = new ArrayList<>();
		getProductList(products,productList);
		List<Product> filteredProduct = productFactory.filterProductByRating(productList,minRating,maxRating);
		Set<ProductRepresentation> productRepresentation = new HashSet<>();
		
		convertToDetailedProductRepresentation(filteredProduct,productRepresentation);
		return productRepresentation;
	}

	@Override
	public Set<ProductRepresentation> sortInAscendingOrder(Set<ProductRequest> products) {
		// TODO Auto-generated method stub
		List<Product> productList = new ArrayList<>();
		getProductList(products,productList);
		List<Product> filteredProduct = productFactory.sortProductsByName(productList,true);
		Set<ProductRepresentation> productRepresentation = new HashSet<>();
		
		convertToDetailedProductRepresentation(filteredProduct,productRepresentation);
		return productRepresentation;
	}

	@Override
	public Set<ProductRepresentation> sortInDescendingOrder(Set<ProductRequest> products) {
		// TODO Auto-generated method stub
		List<Product> productList = new ArrayList<>();
		getProductList(products,productList);
		List<Product> filteredProduct = productFactory.sortProductsByName(productList,false);
		Set<ProductRepresentation> productRepresentation = new HashSet<>();
		
		convertToDetailedProductRepresentation(filteredProduct,productRepresentation);
		return productRepresentation;
	}

	@Override
	public Set<ProductRepresentation> filterProductByDate(Set<ProductRequest> products, String date1, String date2) {
		
		List<Product> productList = new ArrayList<>();
		getProductList(products,productList);
		List<Product> filteredProduct = productFactory.filterProductByDate(productList,date1,date2);
		Set<ProductRepresentation> productRepresentation = new HashSet<>();
		
		convertToDetailedProductRepresentation(filteredProduct,productRepresentation);
		return productRepresentation;
	}

	@Override
	public Set<ProductRepresentation> filterProductBySeller(Set<ProductRequest> products, String sellerName) {
		// TODO Auto-generated method stub
		List<Product> productList = new ArrayList<>();
		getProductList(products,productList);
		List<Product> filteredProduct = productFactory.filterProductBySeller(productList,sellerName);
		Set<ProductRepresentation> productRepresentation = new HashSet<>();
		
		convertToDetailedProductRepresentation(filteredProduct,productRepresentation);
		return productRepresentation;
	}

	@Override
	public Set<MinProductRepresentation> getAllProducts() {
	
		List<Product> filteredProduct = productFactory.getAllProducts();
		
		assert(filteredProduct != null);
		
		Set<MinProductRepresentation> productRepresentation = new HashSet<>();
		
		convertToProductRepresentation(filteredProduct,productRepresentation);
		
		assert(filteredProduct.size() == productRepresentation.size());
		
		return productRepresentation;
		
	}

	@Override
	public Set<ProductRepresentation> getProductByID(int productID) {
		// TODO Auto-generated method stub
		List<Product> filteredProduct = productFactory.getProduct(productID);
		Set<ProductRepresentation> productRepresentation = new HashSet<>();
		
		convertToDetailedProductRepresentation(filteredProduct,productRepresentation);
		return productRepresentation;
	}

	@Override
	public Set<ProductRepresentation> getProductBySeller(String sellerName) {
		// TODO Auto-generated method stub
		List<Product> filteredProduct = productFactory.getProductBySeller(sellerName);
		Set<ProductRepresentation> productRepresentation = new HashSet<>();
		
		convertToDetailedProductRepresentation(filteredProduct,productRepresentation);
		return productRepresentation;
	}

	@Override
	public Set<MinProductRepresentation> getProductByType(String productType) {
		// TODO Auto-generated method stub
		List<Product> filteredProduct = productFactory.getProductByType(productType);
		Set<MinProductRepresentation> productRepresentation = new HashSet<>();
		
		convertToProductRepresentation(filteredProduct,productRepresentation);
		return productRepresentation;
	}

	@Override
	public Set<MinProductRepresentation> getProductsBySellerAndType(String sellerName, String productType) {
		// TODO Auto-generated method stub
		List<Product> filteredProduct = productFactory.getProductsBySellerAndType(sellerName,productType);
		Set<MinProductRepresentation> productRepresentation = new HashSet<>();
		
		convertToProductRepresentation(filteredProduct,productRepresentation);
		return productRepresentation;
	}

	@Override
	public Set<MinProductRepresentation> getProductsByName(String productType) {
		// TODO Auto-generated method stub
		List<Product> filteredProduct = productFactory.getProductsByName(productType);
		assert(filteredProduct != null);
		Set<MinProductRepresentation> productRepresentation = new HashSet<>();
		
		convertToProductRepresentation(filteredProduct,productRepresentation);
		assert(productRepresentation.size() == filteredProduct.size());
		return productRepresentation;
	}

	@Override
	public void addProduct(String username, Set<ProductRequest> products) {
		// TODO Auto-generated method stub
		List<Product> productList = new ArrayList<>();
		
		getProductList(products,productList);
		assert(productList.size() == products.size());
		
		partnerFactory.addProducts(username, productList);
		
		
		
	}

	@Override
	public void deleteProduct(int partner_id, int product_id) {
		// 
		partnerFactory.deleteProduct(partner_id, product_id);
		
	}

}
