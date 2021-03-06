package Domain.Order;

import Domain.Customer.Customer;
import Domain.Partner.Partner;
import Domain.Product.Product;
import Domain.Tools.IDGenerator;

import java.util.*;

public class OrderDetailImpl implements OrderDetail {
    private Map<Partner, List<Product>> mapProductInOrder;
    private Map<Product, Integer> mapProductCount;

    private Date orderCreated;

    private double totalCost;
    private Customer customer;
    private int orderDetailID;
    

    public Map<Partner, List<Product>> getMapProductInOrder() {
        return mapProductInOrder;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        products.addAll(mapProductCount.keySet());
        return products;
    }

    @Override
    public List<Partner> getAllPartners() {
        List<Partner> partners = new ArrayList<>();
        partners.addAll(mapProductInOrder.keySet());
        return partners;
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
        orderDetailID = IDGenerator.getId();

    }

    private double calculateTotalCost(List<Product> products) {
        double totalCost = 0.0;
        for(Product p: products) {
        	totalCost+=p.getProductCost();
        }
        return totalCost;
    }

    private void populateMapInventory(List<Product> products, Map<Partner, List<Product>> mapProductInOrder) {
    	
    	for(Product p: products) {
    		if(mapProductInOrder.containsKey(p.getParner())) {
    			List<Product> inventory = mapProductInOrder.get(p.getParner());
    			inventory.add(p);
    			mapProductInOrder.put(p.getParner(), inventory);
    		}else {
    			List<Product> inventory = new ArrayList<>();
    			inventory.add(p);
    			mapProductInOrder.put(p.getParner(), inventory);
    		}
    	}

    }

    private void populateMapCount(List<Product> products, Map<Product, Integer> mapProductCount)
    {
    	for(Product p: products) {
    		if(mapProductCount.containsKey(p)) {
    			mapProductCount.put(p, mapProductCount.get(p)+1);
    		}else {
    			mapProductCount.put(p, 1);
    		}
    	}

    }

    public List<Product> getProductByPartner(Partner partner){
        return mapProductInOrder.get(partner);
    }

	@Override
	public int getDetailID() {
		return orderDetailID;
	}



}
