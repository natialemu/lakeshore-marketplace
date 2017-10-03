package Domain.Product;

public interface ProductFilter {
	public List<Product> productSortByName(List<Product> products, String sortName, boolean order);
	public List<Product> productSortByID(List<Product> products, long sortID, boolean order);
	public List<Product> productSortByCost(List<Product> products, double sortCost, boolean order);
	public List<Product> productSortByTag(List<Product> products, String sortTag, boolean order);
	public List<Product> productSortByType(List<Product> products, String sortType, boolean order);
	public List<Product> productSortByPartnerName(List<Product> products, String sortPartnerName, boolean order);
	public List<Product> productSortByPartnerID(List<Product> products, long sortPartnerID, boolean order);
}
