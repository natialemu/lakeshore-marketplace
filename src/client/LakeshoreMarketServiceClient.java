package client;

import java.util.*;


import javax.xml.ws.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import Domain.Product.Product;
import Service.Representation.Account.BasicAccountRequest;
import Service.Representation.Account.BasicAccountRequestImpl;
import Service.Representation.Account.Request.AccountRequest;
import Service.Representation.Account.Request.AccountRequestImpl;
import Service.Representation.Product.ProductRequest;
import Service.Representation.Product.ProductRequestImpl;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;


public final class LakeshoreMarketServiceClient {
	
	private LakeshoreMarketServiceClient() {}
	
	public static void main(String[] args) {
		
		
		List<Object> providers = new ArrayList<Object>();
        JacksonJsonProvider provider = new JacksonJsonProvider();
        provider.addUntouchable(Response.class);
        providers.add(provider);
		
        
        
        /*****************************************************************************************
         * User creates an account
        *****************************************************************************************/
        System.out.println("POST METHOD for Account.........................................................");
        WebClient postAccountClient = WebClient.create("http://localhost:8081/account-service", providers);
        WebClient.getConfig(postAccountClient).getOutInterceptors().add(new LoggingOutInterceptor());
        WebClient.getConfig(postAccountClient).getInInterceptors().add(new LoggingInInterceptor());
                 
        postAccountClient = postAccountClient.accept("application/xml").type("application/json").path("/account");
     	
        String postAccountRequestURI = postAccountClient.getCurrentURI().toString();
        System.out.println("Client POST METHOD Request URI:  " + postAccountRequestURI);
        String postAccountRequestHeaders = postAccountClient.getHeaders().toString();
        System.out.println("Client POST METHOD Request Headers:  " + postAccountRequestHeaders);
        AccountRequest accountRequest = new AccountRequestImpl();
        accountRequest.setEmail("test5@test.com");
        accountRequest.setPassword("testPassword");
        accountRequest.setUsername("testUsername5");
        accountRequest.setIsCustomer(true);
        
        String accountResponsePost =  postAccountClient.post(accountRequest, String.class);
        System.out.println("POST MEDTHOD Response ........." + accountResponsePost);
        
        
        /*****************************************************************************************
         * Partner creates an account
        *****************************************************************************************/
        System.out.println("POST METHOD for Account.........................................................");
        WebClient postAccountPClient = WebClient.create("http://localhost:8081/account-service", providers);
        WebClient.getConfig(postAccountPClient).getOutInterceptors().add(new LoggingOutInterceptor());
        WebClient.getConfig(postAccountPClient).getInInterceptors().add(new LoggingInInterceptor());
                 
        postAccountPClient = postAccountPClient.accept("application/xml").type("application/json").path("/account");
     	
        String postAccountPRequestURI = postAccountClient.getCurrentURI().toString();
        System.out.println("Client POST METHOD Request URI:  " + postAccountPRequestURI);
        String postAccountPRequestHeaders = postAccountClient.getHeaders().toString();
        System.out.println("Client POST METHOD Request Headers:  " + postAccountPRequestHeaders);
        AccountRequest accountRequestPartner = new AccountRequestImpl();
        accountRequestPartner.setEmail("testPartner1@test.com");
        accountRequestPartner.setPassword("testPartnerPassword");
        accountRequestPartner.setUsername("testPartnerUsername1");
        accountRequestPartner.setIsCustomer(false);
        
        String accountPResponsePost =  postAccountClient.post(accountRequest, String.class);
        System.out.println("POST MEDTHOD Response ........." + accountPResponsePost);
        
        

        /*****************************************************************************************
         * Partner Adds Products
        *****************************************************************************************/
        System.out.println("POST METHOD for adding products.........................................................");
        WebClient postProductClient = WebClient.create("http://localhost:8081/product-service", providers);
        WebClient.getConfig(postProductClient).getOutInterceptors().add(new LoggingOutInterceptor());
        WebClient.getConfig(postProductClient).getInInterceptors().add(new LoggingInInterceptor());
                 
        postProductClient = postProductClient.accept("application/xml").type("application/json").path("/products/testPartnerUsername");
     	
        String postProductRequestURI = postProductClient.getCurrentURI().toString();
        System.out.println("Client POST METHOD Request URI:  " + postProductRequestURI);
        String postProductRequestHeaders = postProductClient.getHeaders().toString();
        System.out.println("Client POST METHOD Request Headers:  " + postProductRequestHeaders);

//        BasicAccountRequest partnerAccount = new BasicAccountRequestImpl();
//        partnerAccount.setPassword("testPartnerPassword");
//        partnerAccount.setUsername("testPartnerUsername");
        ProductRequest productRequest1 = new ProductRequestImpl();
        productRequest1.setProductName("Surface book");
        productRequest1.setProductCost(20.0);
        productRequest1.setProductTag("expensive");
        productRequest1.setProductType("Laptop");
        
        ProductRequest productRequest2 = new ProductRequestImpl();
        productRequest2.setProductName("Harry Potter");
        productRequest2.setProductCost(30.0);
        productRequest2.setProductTag("fantasy");
        productRequest2.setProductType("Book");
        
        ProductRequest productRequest3 = new ProductRequestImpl();
        productRequest3.setProductName("Introduction to algorithms");
        productRequest3.setProductCost(50.0);
        productRequest3.setProductTag("computer science");
        productRequest3.setProductType("Book");
        
        ProductRequest productRequest4 = new ProductRequestImpl();
        productRequest4.setProductName("Nokia Lumia 1520");
        productRequest4.setProductCost(220.0);
        productRequest4.setProductTag("dead");
        productRequest4.setProductType("Smartphone");
        
        Set<ProductRequest> productRequests = new HashSet<>();
        productRequests.add(productRequest1);
        productRequests.add(productRequest2);
        productRequests.add(productRequest3);
        productRequests.add(productRequest4);
        
        
     	String responsePost =  postProductClient.post(productRequests, String.class);
        System.out.println("POST MEDTHOD Response ........." + responsePost);
        
        /*****************************************************************************************
         * Customer logs into account
         *****************************************************************************************/
        System.out.println("PUT METHOD for logging in.........................................................");
        WebClient putLoginClient = WebClient.create("http://localhost:8081/account-service", providers);
        
        WebClient.getConfig(putLoginClient).getOutInterceptors().add(new LoggingOutInterceptor());

        WebClient.getConfig(putLoginClient).getInInterceptors().add(new LoggingInInterceptor());
        
        putLoginClient = putLoginClient.accept("application/json").type("application/json").path("/account");
        
        String putLoginRequestURI = putLoginClient.getCurrentURI().toString();
        System.out.println("Client GET METHOD URI for products search Request :  " + putLoginRequestURI);
        String putLoginRequestHeaders = putLoginClient.getHeaders().toString();
        System.out.println("Client GET METHOD Request Headers:  " + putLoginRequestHeaders);
        BasicAccountRequest customerBAR = new BasicAccountRequestImpl();
        customerBAR.setPassword("testPassword");
        customerBAR.setUsername("testUsername");

        
        
        String putLoginResponse = putLoginClient.put(customerBAR, String.class);
        System.out.println("PUT METHOD Response: ...." + putLoginResponse);
        
//
//        
//        /*****************************************************************************************
//         * Customer searches for a product
//         *****************************************************************************************/
//        System.out.println("GET METHOD for searching for product.........................................................");
//        WebClient getProductSearchClient = WebClient.create("http://localhost:8081/product-service", providers);
//        
//        WebClient.getConfig(getProductSearchClient).getOutInterceptors().add(new LoggingOutInterceptor());
//
//        WebClient.getConfig(getProductSearchClient).getInInterceptors().add(new LoggingInInterceptor());
//        
//        getProductSearchClient = getProductSearchClient.accept("application/json").type("application/json").path("/products");
//        
//        String getProductSearchRequestURI = getProductSearchClient.getCurrentURI().toString();
//        System.out.println("Client GET METHOD URI for products search Request :  " + getProductSearchRequestURI);
//        String getProductSearchRequestHeaders = getProductSearchClient.getHeaders().toString();
//        System.out.println("Client GET METHOD Request Headers:  " + getProductSearchRequestHeaders);
//        
//        
//        String productSearchResponse = getProductSearchClient.get(String.class);
//        System.out.println("GET METHOD Response: ...." + productSearchResponse);
//        
//        //to get the response as object of Employee class
//        //Employee employee = client.get(Employee.class);
//        Set<Product> searchResults = (Set<Product>)getProductSearchClient.getCollection(Product.class);
//        
//        //System.out.println("Name:" + employee.getFirstName());
//        //System.out.println("privileges:" + employee.getPrivileges());
//        
//        /*****************************************************************************************
//         * Customer Buys a product
//         *****************************************************************************************/
//        Set<ProductRequest> shoppingCart = new HashSet<>();
//        
//        Iterator<Product> productIterator = searchResults.iterator();
//        
//        
//        int i =0;
//        while(productIterator.hasNext()) {
//        	Product currentProduct = productIterator.next();
//        	if(i < 3) {
//        		
//        		ProductRequest pr1 = new ProductRequestImpl();
//        		pr1.setProductCost(currentProduct.getProductCost());
//        		pr1.setProductName(currentProduct.getProductName());
//        		pr1.setProductTag(currentProduct.getProductTag());
//        		pr1.setProductType(currentProduct.getProductType());
//        		
//        		shoppingCart.add(pr1);
//        		
//        	}
//        }
//        
//        System.out.println("POST METHOD for placing an order .........................................................");
//        WebClient getOrderClient = WebClient.create("http://localhost:8081/order-service", providers);
//        
//        WebClient.getConfig(getOrderClient).getOutInterceptors().add(new LoggingOutInterceptor());
//        WebClient.getConfig(getOrderClient).getInInterceptors().add(new LoggingInInterceptor());
//        
//        getOrderClient = getOrderClient.accept("application/json").type("application/json").path("/order");
//        
//        String getOrderRequestURI = getOrderClient.getCurrentURI().toString();
//        System.out.println("Client GET METHOD  to bank-information Request URI:  " + getOrderRequestURI);
//        String getOrderRequestHeaders = getOrderClient.getHeaders().toString();
//        System.out.println("Client GET METHOD Request Headers:  " + getOrderRequestHeaders);
//        BasicAccountRequest basicAccountRequest2 = new BasicAccountRequestImpl();
//        basicAccountRequest2.setUsername("testUser");
//        basicAccountRequest2.setPassword("testPassword");
//        
//        String orderResponse = getOrderClient.post(basicAccountRequest2,String.class);
//        System.out.println("GET METHOD Response: ...." + orderResponse);
//        
       
        System.exit(0);
	}

}
