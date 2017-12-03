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
import Service.Common.MediaTypes;
import Service.Common.URIs;
import Service.Representation.Link;
import Service.Representation.LinkImpl;
import Service.Representation.Account.Representation.AccountValidationRepresentation;
import Service.Representation.Account.Representation.AccountValidationRepresentationImpl;
import Service.Representation.Product.Representation.MinProductRepresentation;
import Service.Representation.Product.Representation.MinProductRepresentationImpl;
import Service.Representation.Product.Representation.ProductRepresentation;
import Service.Representation.Product.Representation.ProductRepresentationImpl;
import Service.Representation.Product.Request.ProductRequest;

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
		List<Product> productList = new ArrayList<>();
		getProductList(products,productList);
		List<Product> filteredProduct = productFactory.filterProductByCost(productList,minCost,maxCost);
		Set<ProductRepresentation> productRepresentation = new HashSet<>();
		
		convertToDetailedProductRepresentation(filteredProduct,productRepresentation);
		return productRepresentation;
	}

	private void convertToDetailedProductRepresentation(List<Product> filteredProduct,
			Set<ProductRepresentation> productRepresentation) {
		
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
		
		setLinks(productRepresentation);
		
		return productRepresentation;
		
	}

	@Override
	public Set<ProductRepresentation> getProductByID(int productID) {
		List<Product> filteredProduct = productFactory.getProduct(productID);
		Set<ProductRepresentation> productRepresentation = new HashSet<>();
		
		convertToDetailedProductRepresentation(filteredProduct,productRepresentation);
 
		setDetailedLinks(productRepresentation);
		return productRepresentation;
	}

	private void setDetailedLinks(Set<ProductRepresentation> productRepresentation) {

		for(ProductRepresentation pr: productRepresentation) {
			List<Link> links = new ArrayList<>();
			
			//place order
			
			Link placeOrder = new LinkImpl("POST",URIs.ORDER,"Place order",MediaTypes.JSON);
			links.add(placeOrder);
			
			
			//searh for another product
			Link searchProduct = new LinkImpl("GET",URIs.PRODUCTS,"Search for products",MediaTypes.JSON);
			links.add(searchProduct);
			//Rate a product
			//subscribe to a partner
			//
			
			Link[] linkArray = new Link[links.size()];
			pr.setLinks(links.toArray(linkArray));
			
		}
		
	}

	@Override
	public Set<ProductRepresentation> getProductBySeller(String sellerName) {
		List<Product> filteredProduct = productFactory.getProductBySeller(sellerName);
		Set<ProductRepresentation> productRepresentation = new HashSet<>();
		
		convertToDetailedProductRepresentation(filteredProduct,productRepresentation);
		return productRepresentation;
	}

	@Override
	public Set<MinProductRepresentation> getProductByType(String productType) {
		List<Product> filteredProduct = productFactory.getProductByType(productType);
		Set<MinProductRepresentation> productRepresentation = new HashSet<>();
		
		convertToProductRepresentation(filteredProduct,productRepresentation);
		return productRepresentation;
	}

	@Override
	public Set<MinProductRepresentation> getProductsBySellerAndType(String sellerName, String productType) {
		List<Product> filteredProduct = productFactory.getProductsBySellerAndType(sellerName,productType);
		Set<MinProductRepresentation> productRepresentation = new HashSet<>();
		
		convertToProductRepresentation(filteredProduct,productRepresentation);
		return productRepresentation;
	}

	@Override
	public Set<MinProductRepresentation> getProductsByName(String productType) {
		List<Product> filteredProduct = productFactory.getProductsByName(productType);
		assert(filteredProduct != null);
		Set<MinProductRepresentation> productRepresentation = new HashSet<>();
		
		convertToProductRepresentation(filteredProduct,productRepresentation);
		assert(productRepresentation.size() == filteredProduct.size());
		
		setLinks(productRepresentation);
		return productRepresentation;
	}

	private void setLinks(Set<MinProductRepresentation> productRepresentation) {
		
		for(MinProductRepresentation mpr: productRepresentation) {
			List<Link> links = new ArrayList<>();
			
			// view product
			Link viewProduct = new LinkImpl("GET",URIs.PRODUCTS+"/"+mpr.getProductID(),"View Product",MediaTypes.JSON);
			links.add(viewProduct);
			
			//place order
			
			Link placeOrder = new LinkImpl("POST",URIs.ORDER,"Place order",MediaTypes.JSON);
			links.add(placeOrder);
			Link[] linkArray = new Link[links.size()];
			mpr.setLinks(links.toArray(linkArray));
		}
		
	}

	@Override
	public AccountValidationRepresentation addProduct(String username, Set<ProductRequest> products) {
		AccountValidationRepresentation avr = new AccountValidationRepresentationImpl();
		
		List<Product> productList = new ArrayList<>();
		
		getProductList(products,productList);
		assert(productList.size() == products.size());
		
		boolean productAdded = partnerFactory.addProducts(username, productList);
		avr.setIsSuccessful(productAdded);
		setLinksAfterProductAddition(avr);
		return avr;
		
		
		
	}

	private void setLinksAfterProductAddition(AccountValidationRepresentation avr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AccountValidationRepresentation deleteProduct(int partner_id, int product_id) {
		// 
		boolean productDeleted= partnerFactory.deleteProduct(partner_id, product_id);
		AccountValidationRepresentation avr = new AccountValidationRepresentationImpl();
		avr.setIsSuccessful(productDeleted);
		setLinksAfterProductDeletetion(avr);
		return avr;
		
	}

	private void setLinksAfterProductDeletetion(AccountValidationRepresentation avr) {
		
	}

	@Override
	public Set<MinProductRepresentation> getRecentlyAddedProducts(int numOrders) {

		List<Product> products = productFactory.getRecentlyAddedProducts(numOrders);
		Set<MinProductRepresentation> pr = new HashSet<>();
		convertToProductRepresentation(products,pr);
		setLinks(pr);
		return pr;
		
	}

	@Override
	public Set<MinProductRepresentation> getInventory(String username) {
		List<Product> productList = productFactory.getInventory(username);
		Set<MinProductRepresentation> mpr = new HashSet<>();
		convertToProductRepresentation(productList,mpr);
		setLinkAfterGettingInventory(mpr);
		return mpr;

	}

	private void setLinkAfterGettingInventory(Set<MinProductRepresentation> mpr) {
		
	}

}
