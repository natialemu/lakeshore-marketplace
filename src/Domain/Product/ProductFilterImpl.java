package Domain.Product;

public class ProductFilterImpl {
	private String filterType;
	
	
	public void setFilterType(String filterType) {
		this.filterType = filterType;
	}
	
	public List<ProductDetail> productFilter(List<ProductDetail> products){
		List<ProductDetail> productTypes = new ArrayList<ProductDetail>();
		 
		for (ProductDetail product : products) {
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
