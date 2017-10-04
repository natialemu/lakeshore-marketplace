package Domain.Product;

public class ProductSearchImpl implements ProductSearch {
	private List<Product> products;
	private Product product;
	
	
	public List<Product> productSearchByName(String searchName){
		List<Product> productNames = new ArrayList<Product>();
		//add logic for retrieving products from the database and adding them to the list
		
		return productNames;
	}
	public Product productSearchByID(long searchID){
		//add logic for retrieving product from the database
				return product;	
	}
	
	public List<Product> productSearchByCost(double searchCost){
		List<Product> productCosts = new ArrayList<Product>();
		//add logic for retrieving products from the database and adding them to the list
		
		return productCosts;
	}
	public List<Product> productSearchByTag(String searchTag){
		List<Product> productTags = new ArrayList<Product>();
		 //add logic for retrieving products from the database and adding them to the list
		return productTags;
	}
	
	public List<Product> productSearchByType(String searchType){
		List<Product> productTypes = new ArrayList<Product>();
		 //add logic for retrieving products from the database and adding them to the list
		
		return productTypes;
	}
	public List<Product> productSearchByPartnerName(String searchPartnerName){
		List<Product> productPartnerNames = new ArrayList<Product>();
		 //add logic for retrieving products from the database and adding them to the list
		
		return productPartnerNames;
	}
	
	public List<Product> productSearchByPartnerID(long searchPartnerID){
		List<Product> productPartnerIDs = new ArrayList<Product>();
		 //add logic for retrieving products from the database and adding them to the list
	
		return productPartnerIDs;
	}
}