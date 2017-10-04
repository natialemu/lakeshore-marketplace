package Domain.Partner;

import Domain.Account.Account;

public interface Partner {
	public Account getAccount();
	public void setAccount(Account account);
	public Inventory getInventory();
	public void addInventory(Inventory inventory);

    String getPartnerID();

}
