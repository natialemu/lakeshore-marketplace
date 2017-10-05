package Domain.Partner;

import Domain.Account.Account;
import Domain.Customer.Customer;
import Domain.Delivery.Delivery;
import Domain.Product.Product;

import java.util.List;

public interface Partner {
	public Account getAccount();
	public void setAccount(Account account);
	public Inventory getInventory();
	public void addInventory(Inventory inventory);

    String getPartnerID();
    Delivery getDelivery();
    void setDelivery(Delivery delivery);

    Delivery acceptDelivery(Delivery delivery);

    void acceptOrder(List<Product> products, Customer customer);
}
