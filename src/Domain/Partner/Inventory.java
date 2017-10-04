package Domain.Partner;

public interface Inventory {
	public Map<Product product,Integer index> getInventory();
	public void setInventory(Map<Product product,Integer index> inventory);
}