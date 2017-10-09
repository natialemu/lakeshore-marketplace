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

    public List<Product> sortProductsByName(List<Product> products){
        return productFilter.sortProductsByName(products);
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

}
