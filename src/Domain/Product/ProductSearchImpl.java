package Domain.Product;

public class ProductSearchImpl implements ProductSearch {
	private String searchName;
	private long searchID;
	private double searchCost;
	private String searchTag;
	private String searchType;
	private String searchPartnerName;
	private String searchPartnerID;
	
	private boolean order;
	
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	public void setSearchID(long searchID) {
		this.searchID = searchID;
	}
	public void setSearchCost(double searchCost) {
		this.searchCost = searchCost;
	}
	public void setSearchTag(String searchTag) {
		this.searchTag = searchTag;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public void setSearchPartnerName(String searchPartnerName) {
		this.searchPartnerName = searchPartnerName;
	}
	public void setSearchPartnerID(long searchPartnerID) {
		this.searchPartnerID = searchPartnerID;
	}	
	
	public String getSearchName() {
		return this.sortName;
	}
	public long getSearchID() {
		return this.sortID;
	}
	public double getSearchCost() {
		return this.sortCost;
	}
	public String getSearchTag() {
		return this.sortTag;
	}
	public String getSearchType() {
		return this.sortType;
	}
	public String getSearchPartnerName() {
		return this.sortPartnerName;
	}
	public long getSearchPartnerID() {
		return this.sortPartnerID;
	}	
	
	public List<Product> productSearchByName(List<Product> products, String searchName, boolean order){
		List<Product> productNames = new ArrayList<Product>();
		 
		for (Product product : products) {
			if (product.getProductName().equalsIgnoreCase(searchName)) {
				productNames.add(product);
			}
		}
		return productNames;
	}
	public Product productSearchByID(List<Product> products, long searchID, boolean order){
		for (Product product : products) {
			if (product.getProductID().equalsIgnoreCase(searchID)) {
				return product;
			}
		}
		return null;
	}
	public List<Product> productSearchByCost(List<Product> products, double searchCost, boolean order){
		List<Product> productCosts = new ArrayList<Product>();
		 
		for (Product product : products) {
			if (product.getProductCost().equalsIgnoreCase(searchCost)) {
				productCosts.add(product);
			}
		}
		return productCosts;
	}
	public List<Product> productSearchByTag(List<Product> products, String searchTag, boolean order){
		List<Product> productTags = new ArrayList<Product>();
		 
		for (Product product : products) {
			if (product.getProductTag().equalsIgnoreCase(searchTag)) {
				productTags.add(product);
			}
		}
		return productTags;
	}
	
	public List<Product> productSearchByType(List<Product> products, String searchType, boolean order){
		List<Product> productTypes = new ArrayList<Product>();
		 
		for (Product product : products) {
			if (product.getProductType().equalsIgnoreCase(searchType)) {
				productTypes.add(product);
			}
		}
		return productTypes;
	}
	public List<Product> productSearchByPartnerName(List<Product> products, String searchPartnerName, boolean order){
		List<Product> productPartnerNames = new ArrayList<Product>();
		 
		for (Product product : products) {
			if (product.getProductPartnerName().equalsIgnoreCase(searchPartnerName)) {
				productPartnerNames.add(product);
			}
		}
		return productPartnerNames;
	}
	public List<Product> productSearchByPartnerID(List<Product> products, long searchPartnerID, boolean order){
		List<Product> productPartnerIDs = new ArrayList<Product>();
		 
		for (Product product : products) {
			if (product.getProductPartnerID().equalsIgnoreCase(searchPartnerID)) {
				productPartnerIDs.add(product);
			}
		}
		return productPartnerIDs;
	}
}