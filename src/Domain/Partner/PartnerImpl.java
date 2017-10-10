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
import Domain.Product.Product;
import Domain.Tools.IDGenerator;
import Repository.Partner.PartnerDAO;

import java.util.List;

public class PartnerImpl implements Partner{
    private Account account;
    private int partnerID;
    private DeliveryFactory deliveryFactory;
    private AccountFactory accountFactory;
    private OrderFactory orderFactory;
    private Inventory inventory;
    private PartnerDAO partnerDAO;



    public PartnerImpl(){
        partnerID = IDGenerator.getId();
        deliveryFactory = new DeliveryFactoryImpl();
        accountFactory = new AccountFactoryImpl();


    }

    public void createPartner(){

        partnerDAO.createPartner(this);
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
    public Delivery acceptDelivery(Delivery delivery) {
        //subscription
       return deliveryFactory.sendDelivery();

    }

    @Override
    public void acceptOrder(List<Product> products, Customer customer) {
        System.out.println("Order accepted by partner");
    }

    public void sendDeliveryStatus(int deliveryID, int trackingNumber){
        deliveryFactory.acceptDeliveryStatus(deliveryID,trackingNumber);
    }
    public void sendDeliveryStatus(int deliveryID, int trackingNumber, String deliveryMethod,String deliveryCarrier){
        deliveryFactory.acceptDeliveryStatus(deliveryID,trackingNumber,deliveryMethod,deliveryCarrier);
    }

    public boolean orderReturned(Order order){
        return orderFactory.cancelOrder(order.getOrderID());
    }
}
