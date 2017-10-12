package Service;

import Domain.Customer.Customer;
import Domain.Partner.Partner;
import Domain.Product.Product;
import Domain.Product.ProductImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){

        CustomerFaccade customerFaccade = new CustomerFacadeImpl();


        PartnerFacade partnerFacade = new PartnerFacadeImpl();


        Customer customer = customerFaccade.createCustomer();
        System.out.println("Customer with ID " + customer.getCustomerID() + " has been created");
        Partner partner  = partnerFacade.createPartner();
        System.out.println("Partner with ID " + partner.getPartnerID() + " has been created");


        String username = "testUsername";
        String passowrd = "testPassword";
        String email = "test@gmail.com";
        customerFaccade.registerACustomer(customer,email,username,passowrd);
        System.out.println("Customer with ID " + customer.getCustomerID() + " has been just registered");


        String partnerUsername = "partnerUsername";
        String partnerPassword = "partner1123";
        String partnerEmail = "partner@gmail.com";
        partnerFacade.registerPartner(partner,partnerEmail,partnerUsername,partnerPassword);
        System.out.println("Partner with ID " + partner.getPartnerID() + " has registered");


        List<Product> products = new ArrayList<>();


        //First product
        double product1Cost = 2000.0;
        String product1Name = "Surface book";
        String product1Type = "Laptop";
        String product1Tag = "expensive";
        String product1Photo = "surface.png";

        Product product1 = new ProductImpl(product1Cost,product1Name,product1Photo,product1Tag,product1Type);

        products.add(product1);

        // Second product
        double product2Cost = 1700.0;
        String product2Name = "Dell xps";
        String product2Type = "Laptop";
        String product2Tag = "High end";
        String product2Photo = "dell.png";

        Product product2 = new ProductImpl(product2Cost,product2Name,product2Photo,product2Tag,product2Type);

        products.add(product2);

        // Third product
        double product3Cost = 600.0;
        String product3Name = "Nokia Lumia 1520";
        String product3Type = "Smartphone";
        String product3Tag = "Premium";
        String product3Photo = "lumia.png";

        Product product3 = new ProductImpl(product3Cost,product3Name,product3Photo,product3Tag,product3Type);

        products.add(product3);


        System.out.println("Partner with ID " + customer.getCustomerID() + " has added the following products to the system: ");

        for(Product p: products){
            System.out.println(p);
        }

        partnerFacade.addProducts(products,partner);



        List<Product> secondPartnerProducts = new ArrayList<>();

        // Fouth product
        double product4Cost = 100.0;
        String product4Name = "Harry Potter";
        String product4Type = "Book";
        String product4Tag = "Fiction";
        String product4Photo = "harrypotter.png";

        Product product4 = new ProductImpl(product4Cost,product4Name,product4Photo,product4Tag,product4Type);
        secondPartnerProducts.add(product4);

        // Fifth product
        double product5Cost = 40.0;
        String product5Name = "Introduction to Algorithms";
        String product5Type = "Book";
        String product5Tag = "Computer Science";
        String product5Photo = "Algorithms.png";

        Product product5 = new ProductImpl(product5Cost,product5Name,product5Photo,product5Tag,product5Type);

        secondPartnerProducts.add(product5);

        Partner secondPartner = partnerFacade.createPartner();
        partnerFacade.registerPartner(secondPartner,"partner2@gmail.com","partner2Test","testpassword");


        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("Partner with ID " + secondPartner.getPartnerID() + " has the following products: ");

        for(Product p: secondPartnerProducts){
            System.out.println(p);
        }



        partnerFacade.addProducts(secondPartnerProducts,secondPartner);
        System.out.println("Partner with id" +partner.getPartnerID()+ " just added products to the system");



        List<Product> shoppingCart = new ArrayList<>();
        shoppingCart.add(product1);
        shoppingCart.add(product4);

        System.out.println("Customer is placing an order on the following products: ");
        for(Product p: shoppingCart){
            System.out.println(p);
        }
        System.out.println("----------------------------------------------------------------");
        System.out.println("Order is being proccessed ...");

        customerFaccade.placeOrder(shoppingCart,customer);

        System.out.println("The status of your order is: "+ customerFaccade.getOrderStatus());











    }








}
