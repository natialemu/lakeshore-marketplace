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
	public void addProducts(List<Product> products);
	void setInventory(Inventory inventory);

    int getPartnerID();
    Delivery getDelivery();
    void setDelivery(Delivery delivery);

    void setPartnerID(int partnerID);
}
