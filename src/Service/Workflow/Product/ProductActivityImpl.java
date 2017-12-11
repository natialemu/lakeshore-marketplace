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
import Service.Representation.Product.Request.*;

public class ProductActivityImpl implements ProductAcitvity {
	private ProductFactory productFactory;
	private PartnerFactory partnerFactory;
	
	public ProductActivityImpl() {
		productFactory = new ProductFactoryImpl();
		partnerFactory = new PartnerFactoryImpl();
	}

	@Override
	public Set<ProductRepresentationImpl> filterProductByCost(Set<ProductRequestImpl> products, double minCost,
			double maxCost) {
		List<Product> productList = new ArrayList<>();
		getProductList(products,productList);
		List<Product> filteredProduct = productFactory.filterProductByCost(productList,minCost,maxCost);
		Set<ProductRepresentationImpl> productRepresentation = new HashSet<>();
		
		convertToDetailedProductRepresentation(filteredProduct,productRepresentation);
		return productRepresentation;
	}

	private void convertToDetailedProductRepresentation(List<Product> filteredProduct,
			Set<ProductRepresentationImpl> productRepresentation) {
		
			for(Product p: filteredProduct) {
				ProductRepresentationImpl prep = new ProductRepresentationImpl();
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
			Set<MinProductRepresentationImpl> productRepresentation) {
		for(Product p: filteredProduct) {
			MinProductRepresentationImpl prep = new MinProductRepresentationImpl();
			prep.setProductCost(p.getProductCost());
			prep.setProductName(p.getProductName());
			prep.setProductType(p.getProductType());
			prep.setRating("UNRATED");
			prep.setProductID(p.getProductID());
			
			productRepresentation.add(prep);
		}
		
	}

	private void getProductList(Set<ProductRequestImpl> products,List<Product> productList) {
		
		//double productCost, String productName, String productTag, String productTyp
		
		// TODO: will depend on what the request methods contain
		
		for(ProductRequestImpl pr: products) {
			Product newProduct = new ProductImpl(pr.getProductCost(),pr.getProductName(),pr.getProductTag(),pr.getProductType());
			productList.add(newProduct);
		}
		
	}

	@Override
	public Set<ProductRepresentationImpl> filterProductByRating(Set<ProductRequestImpl> products, int minRating,
			int maxRating) {
		
		List<Product> productList = new ArrayList<>();
		getProductList(products,productList);
		List<Product> filteredProduct = productFactory.filterProductByRating(productList,minRating,maxRating);
		Set<ProductRepresentationImpl> productRepresentation = new HashSet<>();
		
		convertToDetailedProductRepresentation(filteredProduct,productRepresentation);
		return productRepresentation;
	}

	@Override
	public Set<ProductRepresentationImpl> sortInAscendingOrder(Set<ProductRequestImpl> products) {
		// TODO Auto-generated method stub
		List<Product> productList = new ArrayList<>();
		getProductList(products,productList);
		List<Product> filteredProduct = productFactory.sortProductsByName(productList,true);
		Set<ProductRepresentationImpl> productRepresentation = new HashSet<>();
		
		convertToDetailedProductRepresentation(filteredProduct,productRepresentation);
		return productRepresentation;
	}

	@Override
	public Set<ProductRepresentationImpl> sortInDescendingOrder(Set<ProductRequestImpl> products) {
		List<Product> productList = new ArrayList<>();
		getProductList(products,productList);
		List<Product> filteredProduct = productFactory.sortProductsByName(productList,false);
		Set<ProductRepresentationImpl> productRepresentation = new HashSet<>();
		
		convertToDetailedProductRepresentation(filteredProduct,productRepresentation);
		return productRepresentation;
	}

	@Override
	public Set<ProductRepresentationImpl> filterProductByDate(Set<ProductRequestImpl> products, String date1, String date2) {
		
		List<Product> productList = new ArrayList<>();
		getProductList(products,productList);
		List<Product> filteredProduct = productFactory.filterProductByDate(productList,date1,date2);
		Set<ProductRepresentationImpl> productRepresentation = new HashSet<>();
		
		convertToDetailedProductRepresentation(filteredProduct,productRepresentation);
		return productRepresentation;
	}

	@Override
	public Set<ProductRepresentationImpl> filterProductBySeller(Set<ProductRequestImpl> products, String sellerName) {
		List<Product> productList = new ArrayList<>();
		getProductList(products,productList);
		List<Product> filteredProduct = productFactory.filterProductBySeller(productList,sellerName);
		Set<ProductRepresentationImpl> productRepresentation = new HashSet<>();
		
		convertToDetailedProductRepresentation(filteredProduct,productRepresentation);
		return productRepresentation;
	}

	@Override
	public Set<MinProductRepresentationImpl> getAllProducts() {
	
		List<Product> filteredProduct = productFactory.getAllProducts();
		
		assert(filteredProduct != null);
		
		Set<MinProductRepresentationImpl> productRepresentation = new HashSet<>();
		
		convertToProductRepresentation(filteredProduct,productRepresentation);
		
		assert(filteredProduct.size() == productRepresentation.size());
		
		setLinks(productRepresentation);
		
		return productRepresentation; 
		
	}

	@Override
	public Set<ProductRepresentationImpl> getProductByID(int productID) {
		List<Product> filteredProduct = productFactory.getProduct(productID);
		Set<ProductRepresentationImpl> productRepresentation = new HashSet<>();
		
		convertToDetailedProductRepresentation(filteredProduct,productRepresentation);
 
		setDetailedLinks(productRepresentation);
		return productRepresentation;
	}

	private void setDetailedLinks(Set<ProductRepresentationImpl> productRepresentation) {

		for(ProductRepresentationImpl pr: productRepresentation) {
			List<LinkImpl> links = new ArrayList<>();
			
			//place order
			
			LinkImpl placeOrder = new LinkImpl("POST",URIs.ORDER,"Place order",MediaTypes.JSON);
			links.add(placeOrder);
			
			
			//searh for another product
			LinkImpl searchProduct = new LinkImpl("GET",URIs.PRODUCTS,"Search for products",MediaTypes.JSON);
			links.add(searchProduct);
		
			
			LinkImpl[] linkArray = new LinkImpl[links.size()];
			pr.setLinks(links.toArray(linkArray));
			
		}
		
	}

	@Override
	public Set<ProductRepresentationImpl> getProductBySeller(String sellerName) {
		List<Product> filteredProduct = productFactory.getProductBySeller(sellerName);
		Set<ProductRepresentationImpl> productRepresentation = new HashSet<>();
		
		convertToDetailedProductRepresentation(filteredProduct,productRepresentation);
		return productRepresentation;
	}

	@Override
	public Set<MinProductRepresentationImpl> getProductByType(String productType) {
		List<Product> filteredProduct = productFactory.getProductByType(productType);
		Set<MinProductRepresentationImpl> productRepresentation = new HashSet<>();
		
		convertToProductRepresentation(filteredProduct,productRepresentation);
		return productRepresentation;
	}

	@Override
	public Set<MinProductRepresentationImpl> getProductsBySellerAndType(String sellerName, String productType) {
		List<Product> filteredProduct = productFactory.getProductsBySellerAndType(sellerName,productType);
		Set<MinProductRepresentationImpl> productRepresentation = new HashSet<>();
		
		convertToProductRepresentation(filteredProduct,productRepresentation);
		return productRepresentation;
	}

	@Override
	public Set<MinProductRepresentationImpl> getProductsByName(String productType) {
		List<Product> filteredProduct = productFactory.getProductsByName(productType);
		assert(filteredProduct != null);
		Set<MinProductRepresentationImpl> productRepresentation = new HashSet<>();
		
		convertToProductRepresentation(filteredProduct,productRepresentation);
		assert(productRepresentation.size() == filteredProduct.size());
		
		setLinks(productRepresentation);
		return productRepresentation;
	}

	private void setLinks(Set<MinProductRepresentationImpl> productRepresentation) {
		
		for(MinProductRepresentation mpr: productRepresentation) {
			List<LinkImpl> links = new ArrayList<>();
			
			// view product
			LinkImpl viewProduct = new LinkImpl("GET",URIs.PRODUCTS+"/"+mpr.getProductID(),"View Product",MediaTypes.JSON);
			links.add(viewProduct);
			
			//place order
			
			LinkImpl placeOrder = new LinkImpl("POST",URIs.ORDER,"Place order",MediaTypes.JSON);
			links.add(placeOrder);
			LinkImpl[] linkArray = new LinkImpl[links.size()];
			mpr.setLinks(links.toArray(linkArray));
		}
		
	}

	@Override
	public AccountValidationRepresentationImpl addProduct(String username, Set<ProductRequestImpl> products) {
		AccountValidationRepresentationImpl avr = new AccountValidationRepresentationImpl();
		
		List<Product> productList = new ArrayList<>();
		
		getProductList(products,productList);
		assert(productList.size() == products.size());
		
		boolean productAdded = partnerFactory.addProducts(username, productList);
		avr.setIsSuccessful(productAdded);
		setLinksAfterProductAddition(avr);
		return avr;
		
		
		
	}

	private void setLinksAfterProductAddition(AccountValidationRepresentationImpl avr) {

		List<LinkImpl> links = new ArrayList<>();
		
		LinkImpl getAccountLink = new LinkImpl("GET",URIs.ACCOUNT,"Get account", MediaTypes.JSON);
		links.add(getAccountLink);
		
		LinkImpl deleteProducts = new LinkImpl("DELETE",URIs.PRODUCTS,"Delete product", MediaTypes.JSON);
		links.add(deleteProducts);
		
		LinkImpl[] linkArray = new LinkImpl[links.size()];
		links.toArray(linkArray);
		avr.setLinks(linkArray);	
	}

	@Override
	public AccountValidationRepresentationImpl deleteProduct(int partner_id, int product_id) {
		// 
		boolean productDeleted= partnerFactory.deleteProduct(partner_id, product_id);
		AccountValidationRepresentationImpl avr = new AccountValidationRepresentationImpl();
		avr.setIsSuccessful(productDeleted);
		setLinksAfterProductDeletetion(avr);
		return avr;
		
	}

	private void setLinksAfterProductDeletetion(AccountValidationRepresentation avr) {
		
	}

	@Override
	public Set<MinProductRepresentationImpl> getRecentlyAddedProducts(int numOrders) {

		List<Product> products = productFactory.getRecentlyAddedProducts(numOrders);
		Set<MinProductRepresentationImpl> pr = new HashSet<>();
		convertToProductRepresentation(products,pr);
		setLinks(pr);
		return pr;
		
	}

	@Override
	public Set<MinProductRepresentationImpl> getInventory(String username) {
		List<Product> productList = productFactory.getInventory(username);
		Set<MinProductRepresentationImpl> mpr = new HashSet<>();
		convertToProductRepresentation(productList,mpr);
		setLinkAfterGettingInventory(mpr);
		return mpr;

	}

	private void setLinkAfterGettingInventory(Set<MinProductRepresentationImpl> mpr) {
		for(MinProductRepresentationImpl prorep:mpr) {
			List<LinkImpl> links = new ArrayList<>();
			
			//Add products
			LinkImpl addProducts = new LinkImpl("POST",URIs.PRODUCTS,"Add products",MediaTypes.JSON);
			links.add(addProducts);
			
			//get Account
			LinkImpl getAccountLink = new LinkImpl("GET",URIs.ACCOUNT,"Get account", MediaTypes.JSON);
			links.add(getAccountLink);
			
			
			LinkImpl[] linkArray = new LinkImpl[links.size()];
			prorep.setLinks(links.toArray(linkArray));
			
		}
		
		
	}

}
