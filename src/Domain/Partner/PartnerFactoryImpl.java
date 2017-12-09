package Domain.Partner;

import java.util.List;

import Domain.Account.Account;
import Domain.Account.AccountFactory;
import Domain.Account.AccountFactoryImpl;
import Domain.Customer.Customer;
import Domain.Delivery.Delivery;
import Domain.Delivery.DeliveryFactory;
import Domain.Delivery.DeliveryFactoryImpl;
import Domain.Order.Order;
import Domain.Order.OrderFactory;
import Domain.Order.OrderFactoryImpl;
import Domain.Product.Product;
import Domain.Product.ProductFactory;
import Domain.Product.ProductFactoryImpl;
import Repository.Partner.PartnerDAO;
import Repository.Partner.PartnerDAOImpl;
import Repository.Product.ProductDAO;
import Repository.Product.ProductDAOImpl;

public class PartnerFactoryImpl implements PartnerFactory {
    private DeliveryFactory deliveryFactory;
    private OrderFactory orderFactory;
    private ProductFactory productFactory;
    private AccountFactory accountFactory;

    private PartnerDAO partnerDAO;
    private ProductDAO productDAO;
    public PartnerFactoryImpl() {
        partnerDAO = new PartnerDAOImpl();
        orderFactory = new OrderFactoryImpl();
        productFactory = new ProductFactoryImpl();
        accountFactory = new AccountFactoryImpl();
        productDAO = new ProductDAOImpl();

    }
    public void createPartner(Partner partner){

        partnerDAO.createPartner(partner);
    }


    public boolean registerPartner(String email, String username, String password) {

    	Partner partner = new PartnerImpl();
        Account newAccount = accountFactory.getNewAccount(email,username,password);
        boolean returnType = accountFactory.createBasicAccount(newAccount);
        partner.setAccount(newAccount);
        createPartner(partner);
        return returnType;
    }
    public boolean addProducts(String username, List<Product> products) {
    	

    	boolean successful = true;
    	Partner partner = partnerDAO.getPartner(username);
    	successful = partner == null & successful;
    	assert(partner != null);
    	assert(partner.getPartnerUsername().equals(username));
    	assert(partner.getAccount() != null);
    	assert(partner.getPartnerID() != 0);
    	
    	
    	assert(products != null);
    	assert(products.size() > 0);
    	
//    	
    	for(Product p: products){
    		assert(p.getParner() == null);
    		 p.setPartner(partner);
    		 assert(p.getParner() != null);
    		 
    		 boolean productCreated = productFactory.createProduct(p);
    		 successful = successful && productCreated;
    		 System.out.println("Check DB -> just added product: " + p.getProductName());
   
    	}
    	return successful;
    	
             // p.setPartner(partner);
//            productFactory.createProduct(p);
//        }
    }
    @Override
    public Delivery acceptDelivery(Partner partner, Delivery delivery) {
        //subscription
       return null;

    }

    @Override
    public void acceptOrder(List<Product> products, Customer customer) {
        System.out.println("Order accepted by partner");
        //TODO: should let the order factory know to send confirmation
    }

    public void provideDeliveryStatus(int deliveryID, int trackingNumber){
        deliveryFactory.acceptDeliveryStatus(deliveryID,trackingNumber);
    }
    public void provideDeliveryStatus(int deliveryID, int trackingNumber, String deliveryMethod,String deliveryCarrier){
        deliveryFactory.acceptDeliveryStatus(deliveryID,trackingNumber,deliveryMethod,deliveryCarrier);
    }

    public void orderReturned(int orderID){
        orderFactory.cancelOrder(orderID);
    }

    @Override
    public Partner createNewPartner() {
        return new PartnerImpl();
    }
	@Override
	public boolean deleteProduct(int partner_id, int product_id) {
		// TODO: should send to product DAO for deletion
		System.out.println("Product is deleted! ");
		return true;
		
	}
}
