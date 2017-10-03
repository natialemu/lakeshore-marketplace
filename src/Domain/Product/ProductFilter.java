package Domain.Product;

public interface ProductFilter {
	public List<Product> productFilter(List<Product> products, String filterType, boolean order);
	public List<Product> productSearch(List<Product> products, boolean order);
	public List<Product> productSort(List<Product> products, boolean order);
}
