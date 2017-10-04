package Domain.Partner;

public interface InventoryImpl implements Inventory {
	
	private Map<Product product,Integer index> inventory;
	
	public Map<Product product,Integer index> getInventory()(return this.inventory;)
	public void setInventory(Map<Product product,Integer index> inventory){this.inventory = inventory;}
}

