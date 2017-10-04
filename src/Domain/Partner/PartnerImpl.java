package Domain.Partner;

import Domain.Account.Account;
import Domain.Account.AccountFactory;
import Domain.Account.AccountFactoryImpl;
import Domain.Account.AccountImpl;
import Domain.Delivery.Delivery;
import Domain.Delivery.DeliveryFactory;
import Domain.Delivery.DeliveryFactoryImpl;
import Domain.Tools.IDGenerator;

public class PartnerImpl implements Partner{
    private Account account;
    private int partnerID;
    private DeliveryFactory deliveryFactory;
    private AccountFactory accountFactory;
    private DeliveryManagement deliveryManagement;
    private OrderReturnManagement orderReturnManagement;


    public PartnerImpl(){
        partnerID = IDGenerator.getId();
        deliveryFactory = new DeliveryFactoryImpl();
        accountFactory = new AccountFactoryImpl();
        deliveryManagement = new DeliveryManagementImpl();
        orderReturnManagement = new OrderReturnManagementImpl();
    }

    public void createAccount(String username, String passowrd){
        account = new AccountImpl(username,passowrd);
        accountFactory.createBasicAccount(username,passowrd);
    }
    @Override
    public Account getAccount() {
        return account;
    }

    @Override
    public void setAccount(Account account) {

        this.account = account;
    }

    @Override
    public Inventory getInventory() {
        return null;
    }

    @Override
    public void addInventory(Inventory inventory) {

    }

    @Override
    public String getPartnerID() {
        return null;
    }

    @Override
    public Delivery getDelivery() {
        return null;
    }

    @Override
    public void setDelivery(Delivery delivery) {

    }

    @Override
    public void acceptDelivery(Delivery delivery) {
        deliveryManagement.acceptDelivery(delivery);

    }
}
