package Domain.Product;

public class ProductFilterImpl implements ProductFilter {
	
	private String sortName;
	private long sortID;
	private double sortCost;
	private String sortTag;
	private String sortType;
	private String sortPartnerName;
	private String sortPartnerID;
	
	private boolean order;
	
	
	public void setSortName(String sortName) {
		this.sortName = sortName;
	}
	public void setSortID(long sortID) {
		this.sortID = sortID;
	}
	public void setSortCost(double sortCost) {
		this.sortCost = sortCost;
	}
	public void setSortTag(String sortTag) {
		this.sortTag = sortTag;
	}
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}
	public void setSortPartnerName(String sortPartnerName) {
		this.sortPartnerName = sortPartnerName;
	}
	public void setSortPartnerID(long sortPartnerID) {
		this.sortPartnerID = sortPartnerID;
	}	
	
	public String getSortName() {
		return this.sortName;
	}
	public long getSortID() {
		return this.sortID;
	}
	public double getSortCost() {
		return this.sortCost;
	}
	public String getSortTag() {
		return this.sortTag;
	}
	public String getSortType() {
		return this.sortType;
	}
	public String getSortPartnerName() {
		return this.sortPartnerName;
	}
	public long getSortPartnerID() {
		return this.sortPartnerID;
	}	
	
	public List<Product> productSortByName(List<Product> products, String sortName, boolean order){
		List<Product> productNames = new ArrayList<Product>();
		 
		for (Product product : products) {
			if (product.getProductName().equalsIgnoreCase(sortName)) {
				productNames.add(product);
			}
		}
		return productNames;
	}
	public List<Product> productSortByID(List<Product> products, long sortID, boolean order){
		List<Product> productIDs = new ArrayList<Product>();
		 
		for (Product product : products) {
			if (product.getProductID().equalsIgnoreCase(sortID)) {
				productIDs.add(product);
			}
		}
		return productIDs;
	}
	public List<Product> productSortByCost(List<Product> products, double sortCost, boolean order){
		List<Product> productCosts = new ArrayList<Product>();
		 
		for (Product product : products) {
			if (product.getProductCost().equalsIgnoreCase(sortCost)) {
				productCosts.add(product);
			}
		}
		return productCosts;
	}
	public List<Product> productSortByTag(List<Product> products, String sortTag, boolean order){
		List<Product> productTags = new ArrayList<Product>();
		 
		for (Product product : products) {
			if (product.getProductTag().equalsIgnoreCase(sortTag)) {
				productTags.add(product);
			}
		}
		return productTags;
	}
	
	public List<Product> productSortByType(List<Product> products, String sortType, boolean order){
		List<Product> productTypes = new ArrayList<Product>();
		 
		for (Product product : products) {
			if (product.getProductType().equalsIgnoreCase(sortType)) {
				productTypes.add(product);
			}
		}
		return productTypes;
	}
	public List<Product> productSortByPartnerName(List<Product> products, String sortPartnerName, boolean order){
		List<Product> productPartnerNames = new ArrayList<Product>();
		 
		for (Product product : products) {
			if (product.getProductPartnerName().equalsIgnoreCase(sortPartnerName)) {
				productPartnerNames.add(product);
			}
		}
		return productPartnerNames;
	}
	public List<Product> productSortByPartnerID(List<Product> products, long sortPartnerID, boolean order){
		List<Product> productPartnerIDs = new ArrayList<Product>();
		 
		for (Product product : products) {
			if (product.getProductPartnerID().equalsIgnoreCase(sortPartnerID)) {
				productPartnerIDs.add(product);
			}
		}
		return productPartnerIDs;
	}
}

