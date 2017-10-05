package Domain.Partner;

import Domain.Product.Product;

import java.util.ArrayList;
import java.util.List;

public class InventoryImpl implements Inventory {
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    private List<Product> productList;

    public InventoryImpl(List<Product> products){
        productList = products;
    }
    public InventoryImpl(){
        productList = new ArrayList<>();
    }

    public void addProduct(Product product){
        productList.add(product);
    }
    public void addProducts(List<Product> products){
        productList.addAll(products);
    }

    public void removeProduct(Product product){
        productList.remove(product);
    }

}
