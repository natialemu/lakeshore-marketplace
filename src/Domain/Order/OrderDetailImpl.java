package Domain.Order;

import Domain.Customer.Customer;
import Domain.Partner.Partner;
import Domain.Product.Product;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDetailImpl implements OrderDetail {
    private Map<Partner, List<Product>> mapProductInOrder;
    private Map<Product, Integer> mapProductCount;

    private Date orderCreated;

    private double totalCost;
    private Customer customer;

    public Map<Partner, List<Product>> getMapProductInOrder() {
        return mapProductInOrder;
    }

    public void setMapProductInOrder(Map<Partner, List<Product>> mapProductInOrder) {
        this.mapProductInOrder = mapProductInOrder;
    }

    public Map<Product, Integer> getMapProductCount() {
        return mapProductCount;
    }

    public void setMapProductCount(Map<Product, Integer> mapProductCount) {
        this.mapProductCount = mapProductCount;
    }

    public Date getOrderCreated() {
        return orderCreated;
    }

    public void setOrderCreated(Date orderCreated) {
        this.orderCreated = orderCreated;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public OrderDetailImpl(List<Product> products, Customer customer){
        this.customer = customer;
        mapProductCount = new HashMap<>();
        populateMapCount(products,mapProductCount);
        mapProductInOrder = new HashMap<>();
        populateMapInventory(products,mapProductInOrder);

        totalCost = calculateTotalCost(products);
        orderCreated = new Date();

    }

    private double calculateTotalCost(List<Product> products) {

        return 0.0;
    }

    private void populateMapInventory(List<Product> products, Map<Partner, List<Product>> mapProductInOrder) {

    }

    private void populateMapCount(List<Product> products, Map<Product, Integer> mapProductCount)
    {

    }

    public List<Product> getProductByPartner(Partner partner){
        return mapProductInOrder.get(partner);
    }



}
