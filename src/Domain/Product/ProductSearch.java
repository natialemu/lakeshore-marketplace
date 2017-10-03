package Domain.Product;

public interface ProductSearch {
	
	public List<Product> productSearchByName(List<Product> products, String searchName, boolean order);
	public Product productSearchByID(List<Product> products, long searchID, boolean order);
	public List<Product> productSearchByCost(List<Product> products, double searchCost, boolean order);
	public List<Product> productSearchByTag(List<Product> products, String searchTag, boolean order);
	public List<Product> productSearchByType(List<Product> products, String searchType, boolean order);
	public List<Product> productSearchByPartnerName(List<Product> products, String searchPartnerName, boolean order);
	public List<Product> productSearchByPartnerID(List<Product> products, long searchPartnerID, boolean order);
}
