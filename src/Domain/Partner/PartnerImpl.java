package Domain.Partner;

import Domain.Account.Account;
import Domain.Account.AccountFactory;
import Domain.Account.AccountFactoryImpl;
import Domain.Account.AccountImpl;
import Domain.Customer.Customer;
import Domain.Delivery.Delivery;
import Domain.Delivery.DeliveryFactory;
import Domain.Delivery.DeliveryFactoryImpl;
import Domain.Order.Order;
import Domain.Order.OrderFactory;
import Domain.Order.OrderFactoryImpl;
import Domain.Product.Product;
import Domain.Tools.IDGenerator;
import Repository.Partner.PartnerDAO;
import Repository.Partner.PartnerDAOImpl;

import java.util.List;

public class PartnerImpl implements Partner{
    private Account account;
    private Inventory inventory;

    public void setPartnerID(int partnerID) {
        this.partnerID = partnerID;
    }

    private int partnerID;

    public PartnerImpl(){
        partnerID = IDGenerator.getId();
        inventory = new InventoryImpl();


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
        return inventory;
    }

    @Override
    public void addProducts(List<Product> products) {

        inventory.addProducts(products);
    }

    @Override
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public int getPartnerID() {
        return partnerID;
    }

    @Override
    public Delivery getDelivery() {
        return null;
    }

    @Override
    public void setDelivery(Delivery delivery) {
    
    }

    
}
