package Domain.Product;

public interface ProductFilter {
	public List<Product> productSortByName(List<Product> products,boolean order);
	public List<Product> productSortByID(List<Product> products, boolean order);
	public List<Product> productSortByCost(List<Product> products, boolean order);
	public List<Product> productSortByTag(List<Product> products, boolean order);
	public List<Product> productSortByType(List<Product> products, boolean order);
	public List<Product> productSortByPartnerName(List<Product> products, boolean order);
	public List<Product> productSortByPartnerID(List<Product> products, boolean order);
	public List<Product> productFilterByName(List<Product> products, String filterName, boolean order);
	public List<Product> productFilterByID(List<Product> products, long filterID, boolean order);
	public List<Product> productFilterByCost(List<Product> products, double filterCost, boolean order);
	public List<Product> productFilterByTag(List<Product> products, String filterTag, boolean order);
	public List<Product> productFilterByType(List<Product> products, String filterType, boolean order);
	public List<Product> productFilterByPartnerName(List<Product> products, String filterPartnerName, boolean order);
	public List<Product> productFilterByPartnerID(List<Product> products, long filterPartnerID, boolean order);
}
