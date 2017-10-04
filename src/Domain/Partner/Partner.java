package Domain.Partner;

import Domain.Account.Account;
import Domain.Delivery.Delivery;

public interface Partner {
	public Account getAccount();
	public void setAccount(Account account);
	public Inventory getInventory();
	public void addInventory(Inventory inventory);

    String getPartnerID();
    Delivery getDelivery();
    void setDelivery(Delivery delivery);

    void acceptDelivery(Delivery delivery);
}
