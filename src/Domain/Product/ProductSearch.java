package Domain.Product;

public interface ProductSearch {
	
	public List<Product> productSearchByName(String searchName);
	public Product productSearchByID(long searchID);
	public List<Product> productSearchByCost(double searchCost);
	public List<Product> productSearchByTag(String searchTag);
	public List<Product> productSearchByType(String searchType);
	public List<Product> productSearchByPartnerName(String searchPartnerName);
	public List<Product> productSearchByPartnerID(long searchPartnerID);
}
