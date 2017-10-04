package Domain.Product;
import java.util*;
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
	
	public List<Product> productSortByName(List<Product> products, boolean order){
		List<Product> listOfProducts = products;
		if (order == true){collections.sort(listOfProducts, Product.ProductNameAscComparator);}
		else{collections.sort(listOfProducts, Product.ProductNameDesComparator);}
		
		return listOfProducts;
	}
	public List<Product> productSortByID(List<Product> products, boolean order){
		List<Product> listOfProducts = products;
		if (order == true){collections.sort(listOfProducts, Product.ProductIDAscComparator);}
		else{collections.sort(listOfProducts, Product.ProductIDDesComparator);}
		
		return listOfProducts;
	}
	public List<Product> productSortByCost(List<Product> products, boolean order){
		List<Product> listOfProducts = products;
		if (order == true){collections.sort(listOfProducts, Product.ProductCostAscComparator);}
		else{collections.sort(listOfProducts, Product.ProductCostDesComparator);}
		
		return listOfProducts;
	}
	public List<Product> productSortByTag(List<Product> products, boolean order){
		List<Product> listOfProducts = products;
		if (order == true){collections.sort(listOfProducts, Product.ProductTagAscComparator);}
		else{collections.sort(listOfProducts, Product.ProductTagDesComparator);}
		
		return listOfProducts;
	}
	
	public List<Product> productSortByType(List<Product> products, boolean order){
		List<Product> listOfProducts = products;
		if (order == true){collections.sort(listOfProducts, Product.ProductTypeAscComparator);}
		else{collections.sort(listOfProducts, Product.ProductTypeDesComparator);}
		
		return listOfProducts;
	}
	public List<Product> productSortByPartnerName(List<Product> products, boolean order){
		List<Product> listOfProducts = products;
		if (order == true){collections.sort(listOfProducts, Product.ProductPartnerNameAscComparator);}
		else{collections.sort(listOfProducts, Product.ProductPartnerNameDesComparator);}
		
		return listOfProducts;
	}
	
	public List<Product> productSortByPartnerID(List<Product> products, boolean order){
		List<Product> listOfProducts = products;
		if (order == true){collections.sort(listOfProducts, Product.ProductPartnerIDAscComparator);}
		else{collections.sort(listOfProducts, Product.ProductPartnerIDDesComparator);}
		
		return listOfProducts;
	}

	public List<Product> filterByName(List<Product> products, String filterName, boolean order){
		 List<Product> listOfProducts = new ArrayList<Product>();
		 
		for (Product product : products) {
			if (product.getProductID().equalsIgnoreCase(filterName)) {
				listOfProducts.add(product);
			}
		}
		
		if (order == true){collections.sort(listOfProducts, Product.ProductNameAscComparator);}
		else{collections.sort(listOfProducts, Product.ProductNameDesComparator);}
		return listOfProducts;
	}
	
	public List<Product> productSortByID(List<Product> products, long filterID, boolean order){
		List<Product> listOfProducts = new ArrayList<Product>();
		 
		for (Product product : products) {
			if (product.getProductID().equalsIgnoreCase(filterID)) {
				listOfProducts.add(product);
			}
		}
		if (order == true){collections.sort(listOfProducts, Product.ProductIDAscComparator);}
		else{collections.sort(listOfProducts, Product.ProductIDDesComparator);}
		
		return listOfProducts;
	}
	public List<Product> productSortByCost(List<Product> products, double filterCost, boolean order){
		List<Product> listOfProducts = new ArrayList<Product>();
		 
		for (Product product : products) {
			if (product.getProductCost().equalsIgnoreCase(filterCost)) {
				listOfProducts.add(product);
			}
		}
		if (order == true){collections.sort(listOfProducts, Product.ProductCostAscComparator);}
		else{collections.sort(listOfProducts, Product.ProductCostDesComparator);}
		return listOfProducts;
	}
	public List<Product> productSortByTag(List<Product> products, String filterTag, boolean order){
		List<Product> listOfProducts = new ArrayList<Product>();
		 
		for (Product product : products) {
			if (product.getProductTag().equalsIgnoreCase(filterTag)) {
				listOfProducts.add(product);
			}
		}
		if (order == true){collections.sort(listOfProducts, Product.ProductTagAscComparator);}
		else{collections.sort(listOfProducts, Product.ProductTagDesComparator);}
		return listOfProducts;
	}
	
	public List<Product> productSortByType(List<Product> products, String filterType, boolean order){
		List<Product> listOfProducts = new ArrayList<Product>();
		 
		for (Product product : products) {
			if (product.getProductType().equalsIgnoreCase(filterType)) {
				listOfProducts.add(product);
			}
		}
		if (order == true){collections.sort(listOfProducts, Product.ProductTypeAscComparator);}
		else{collections.sort(listOfProducts, Product.ProductTypeDesComparator);}
		return listOfProducts;
	}
	public List<Product> productSortByPartnerName(List<Product> products, StringfilterPartnerName, boolean order){
		List<Product> listOfProducts = new ArrayList<Product>();
		 
		for (Product product : products) {
			if (product.getProductPartnerName().equalsIgnoreCase(filterPartnerName)) {
				listOfProducts.add(product);
			}
		}
		if (order == true){collections.sort(listOfProducts, Product.ProductPartnerNameAscComparator);}
		else{collections.sort(listOfProducts, Product.ProductPartnerNameDesComparator);}
		return listOfProducts;
	}
	public List<Product> productSortByPartnerID(List<Product> products, long filterPartnerID, boolean order){
		List<Product> listOfProducts = new ArrayList<Product>();
		 
		for (Product product : products) {
			if (product.getProductPartnerID().equalsIgnoreCase(filterPartnerID)) {
				listOfProducts.add(product);
			}
		}
		if (order == true){collections.sort(listOfProducts, Product.ProductPartnerIDAscComparator);}
		else{collections.sort(listOfProducts, Product.ProductPartnerIDDesComparator);}
		return listOfProducts;
	}
}