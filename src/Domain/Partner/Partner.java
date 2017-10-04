package Domain.Partner;

import Domain.Account.AccountFactory;
import Domain.ReviewSystem.ReviewSystem;

public interface Partner {
	public void addProductToInventory(Product, Integer);
	public void provideDeliveryStatus(String status);
	public boolean notifyOrderReturn();
	public AccountFactory getAccountFactory();
    void setAccountFactory(AccountFactory accountFactory);
}