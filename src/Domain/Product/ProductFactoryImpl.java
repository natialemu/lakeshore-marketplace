package Domain.Product;

import Repository.Product.ProductDAO;
import Repository.Product.ProductDAOImpl;

import java.util.List;

public class ProductFactoryImpl implements ProductFactory{
    private ProductFilter productFilter;
    private ProductSearch productSearch;
    private ProductDAO productDAO;

    public ProductFilter getProductFilter() {
        return productFilter;
    }

    public void setProductFilter(ProductFilter productFilter) {
        this.productFilter = productFilter;
    }

    public ProductSearch getProductSearch() {
        return productSearch;
    }

    public void setProductSearch(ProductSearch productSearch) {
        this.productSearch = productSearch;
    }

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public ProductFactoryImpl(){
        productFilter = new ProductFilterImpl();
        productDAO = new ProductDAOImpl();
        productSearch = new ProductSearchImpl();
    }

    public List<Product> getAllProducts(){
        return productSearch.getAllProducts();
    }

    public Product searchProductByID(int productID){
        return productSearch.searchProductByID(productID);
    }

    public List<Product> searchProductsByName(String productName){
        return productSearch.searchProductsByName(productName);
    }

    public List<Product> searchProductByType(String productType){
        return productSearch.searchProductByType(productType);
    }

    public List<Product> filterProductByTag(List<Product> products){
        return productFilter.filterProductByTag(products);
    }

    public List<Product> sortProductsByName(List<Product> products, boolean order){
        return productFilter.sortProductsByName(products,order);
    }

    public List<Product> sortProductsByPrice(List<Product> products){
        return productFilter.sortProductsByPrice(products);
    }

    public List<Product> sortProductsByRating(List<Product> products){
        return productFilter.sortProductsByRating(products);
    }

    public void createProduct(Product product){
        productDAO.createProduct(product);
    }

	@Override
	public List<Product> filterProductByCost(List<Product> productList, double minCost, double maxCost) {
		// TODO Auto-generated method stub
		return productFilter.filterProductByCost(productList,minCost, maxCost);
	}

	@Override
	public List<Product> filterProductByRating(List<Product> productList, int minRating, int maxRating) {
		
		return productFilter.filterProductByRating(productList,minRating, maxRating);
	}

	@Override
	public List<Product> filterProductByDate(List<Product> productList, String date1, String date2) {
		// TODO Auto-generated method stub
		return productFilter.filterProductByDate(productList,date1,date2);
	}

	@Override
	public List<Product> filterProductBySeller(List<Product> productList, String sellerName) {
		// TODO Auto-generated method stub
		return productFilter.filterProductBySeller(productList,sellerName);
	}

	@Override
	public List<Product> getProduct(int productID) {
		// TODO Auto-generated method stub
		return productSearch.getProduct(productID);
	}

	@Override
	public List<Product> getProductBySeller(String sellerName) {
		// TODO Auto-generated method stub
		return productSearch.getProductBySeller(sellerName);
	}

	@Override
	public List<Product> getProductByType(String productType) {
		// TODO Auto-generated method stub
		return productSearch.getProductByType(productType);
	}

	@Override
	public List<Product> getProductsBySellerAndType(String sellerName, String productType) {
		// TODO Auto-generated method stub
		return productSearch.getProductsBySellerAndType(sellerName,productType);
	}

	@Override
	public List<Product> getProductsByName(String productName) {
		// 
		return productSearch.getProductByName(productName);
	}

}
