package Domain.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductFilterByType implements ProductFilter {
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

}
