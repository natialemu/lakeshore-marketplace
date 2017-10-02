package Domain.Product;

public interface ProductFilter {
	public List<Product> productFilter(List<Product> products);
	public List<Product> productSearch(List<Product> products);
	public List<Product> productSort(List<Product> products);
}
