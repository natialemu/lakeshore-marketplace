package Domain.Partner;

import Domain.Account.AccountFactory;
import Domain.Partner.Partner;

public class PartnerImpl implements Partner{
	private Account account;
	private Inventory inventory;
	private DeliveryManagement deliveryManagement;
	private OrderReturnManagement orderReturnManagement;
	private AccountFactory accountFactory;
	
	@Override
    public int getCustomerID() {
        return partnerID;
    }

    public AccountFactory getAccountFactory() {
        return accountFactory;
    }

    public void setAccountFactory(AccountFactory accountFactory) {
        this.accountFactory = accountFactory;
    }
	
	public void addProductToInventory(Product product, Integer index){inventory.add(product,index);}
	public Inventory getInventory(){return this.inventory;}
	public void provideDeliveryStatus(String status){/*deliver string*/}
	public boolean notifyOrderReturn(){return true;}
	
	@Override
    public String toString() {
        return "PartnerImpl{" +
                "partnerID=" + partnerID +
                ", accountFactory=" + accountFactory +
                ", deliveryManagement=" + deliveryManagement +
                ", orderReturnManagement=" + orderReturnManagement +
                '}';
}
}