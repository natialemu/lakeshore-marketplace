package Domain.Product;

public class ProductFilterImpl implements ProductFilter {
	private String filterType;
	private boolean order;
	
	
	public void setFilterType(String filterType) {
		this.filterType = filterType;
	}
	
	public List<Product> productFilter(List<Product> products, String filterType, boolean order){
		List<Product> productTypes = new ArrayList<Product>();
		 
		for (Product product : products) {
			if (product.getProductType().equalsIgnoreCase(filterType)) {
				productTypes.add(product);
			}
		}
		return productTypes;
	}
	public List<Product> productSearch(List<Product> products){
		return products
	}
	
	public List<Product> productSort(List<Product> products){
		return products
	}	
}
