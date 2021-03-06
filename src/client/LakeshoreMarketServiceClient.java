package client;

import java.util.*;


import javax.xml.ws.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import Domain.Product.Product;
import Domain.Product.ProductImpl;
import Service.Representation.Account.Request.AccountRequest;
import Service.Representation.Account.Request.AccountRequestImpl;
import Service.Representation.Account.Request.BasicAccountRequest;
import Service.Representation.Account.Request.BasicAccountRequestImpl;
import Service.Representation.Account.Request.BasicEmailAccountRequestImpl;
import Service.Representation.Order.Request.OrderRequest;
import Service.Representation.Order.Request.OrderRequestImpl;
import Service.Representation.Product.Representation.MinProductRepresentationImpl;
import Service.Representation.Product.Representation.ProductRepresentationImpl;
import Service.Representation.Product.Request.ProductRequest;
import Service.Representation.Product.Request.ProductRequestImpl;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;


public final class LakeshoreMarketServiceClient {
	
	private LakeshoreMarketServiceClient() {}
	
	public static void main(String[] args) {
		
		
		
		List<Object> providers = new ArrayList<Object>();
        JacksonJsonProvider provider = new JacksonJsonProvider();
        provider.addUntouchable(Response.class);
        providers.add(provider);
		
        
//        
//        /*****************************************************************************************
//         * User creates an account
//        *****************************************************************************************/
//        System.out.println("POST METHOD for Account.........................................................");
//        WebClient postAccountClient = WebClient.create("http://localhost:8081", providers);
//        WebClient.getConfig(postAccountClient).getOutInterceptors().add(new LoggingOutInterceptor());
//        WebClient.getConfig(postAccountClient).getInInterceptors().add(new LoggingInInterceptor());
//                 
//        postAccountClient = postAccountClient.accept("application/xml").type("application/json").path("/account/");
//     	
//        String postAccountRequestURI = postAccountClient.getCurrentURI().toString();
//        System.out.println("Client POST METHOD Request URI:  " + postAccountRequestURI);
//        String postAccountRequestHeaders = postAccountClient.getHeaders().toString();
//        System.out.println("Client POST METHOD Request Headers:  " + postAccountRequestHeaders);
        AccountRequest accountRequest = new AccountRequestImpl();
        accountRequest.setEmail("test5@test.com");
        accountRequest.setPassword("testPassword");
        accountRequest.setUsername("testUsername5");
        accountRequest.setIsCustomer(true);
//        
//        String accountResponsePost =  postAccountClient.post(accountRequest, String.class);
//        System.out.println("POST MEDTHOD Response ........." + accountResponsePost);
//        
//        
//        /*****************************************************************************************
//         * Partner creates an account
//        *****************************************************************************************/
//        System.out.println("POST METHOD for Account.........................................................");
//        WebClient postAccountPClient = WebClient.create("http://localhost:8081", providers);
//        WebClient.getConfig(postAccountPClient).getOutInterceptors().add(new LoggingOutInterceptor());
//        WebClient.getConfig(postAccountPClient).getInInterceptors().add(new LoggingInInterceptor());
//                 
//        postAccountPClient = postAccountPClient.accept("application/xml").type("application/json").path("/account");
//     	
//        String postAccountPRequestURI = postAccountPClient.getCurrentURI().toString();
//        System.out.println("Client POST METHOD Request URI:  " + postAccountPRequestURI);
//        String postAccountPRequestHeaders = postAccountPClient.getHeaders().toString();
//        System.out.println("Client POST METHOD Request Headers:  " + postAccountPRequestHeaders);
        AccountRequest accountRequestPartner = new AccountRequestImpl();
        accountRequestPartner.setEmail("testPartner1@test.com");
        accountRequestPartner.setPassword("testPartnerPassword");
        accountRequestPartner.setUsername("testPartnerUsername1");
        accountRequestPartner.setIsCustomer(false);
//        
//        String accountPResponsePost =  postAccountPClient.post(accountRequestPartner, String.class);
//        System.out.println("POST MEDTHOD Response ........." + accountPResponsePost);
//        
//        
//
//        /*****************************************************************************************
//         * Partner Adds Products
//        *****************************************************************************************/
//        System.out.println("POST METHOD for adding products.........................................................");
//        WebClient postProductClient = WebClient.create("http://localhost:8081/products", providers);
//        WebClient.getConfig(postProductClient).getOutInterceptors().add(new LoggingOutInterceptor());
//        WebClient.getConfig(postProductClient).getInInterceptors().add(new LoggingInInterceptor());
//        String username = accountRequestPartner.getUsername();
//                 
//        postProductClient = postProductClient.accept("application/xml").type("application/json").path("/"+username);
//     	
//        String postProductRequestURI = postProductClient.getCurrentURI().toString();
//        System.out.println("Client POST METHOD Request URI:  " + postProductRequestURI);
//        String postProductRequestHeaders = postProductClient.getHeaders().toString();
//        System.out.println("Client POST METHOD Request Headers:  " + postProductRequestHeaders);
//
////        BasicAccountRequest partnerAccount = new BasicAccountRequestImpl();
////        partnerAccount.setPassword("testPartnerPassword");
////        partnerAccount.setUsername("testPartnerUsername");
//        ProductRequestImpl productRequest1 = new ProductRequestImpl();
//        productRequest1.setProductName("Surface book");
//        productRequest1.setProductCost(20.0);
//        productRequest1.setProductTag("expensive");
//        productRequest1.setProductType("Laptop");
//        
//        ProductRequestImpl productRequest2 = new ProductRequestImpl();
//        productRequest2.setProductName("Harry Potter");
//        productRequest2.setProductCost(30.0);
//        productRequest2.setProductTag("fantasy");
//        productRequest2.setProductType("Book");
//        
//        ProductRequestImpl productRequest3 = new ProductRequestImpl();
//        productRequest3.setProductName("Introduction to algorithms");
//        productRequest3.setProductCost(50.0);
//        productRequest3.setProductTag("computer science");
//        productRequest3.setProductType("Book");
//        
//        ProductRequestImpl productRequest4 = new ProductRequestImpl();
//        productRequest4.setProductName("Nokia Lumia 1520");
//        productRequest4.setProductCost(220.0);
//        productRequest4.setProductTag("dead");
//        productRequest4.setProductType("Smartphone");
//        
//        Set<ProductRequestImpl> productRequests = new HashSet<>();
//        productRequests.add(productRequest1);
//        productRequests.add(productRequest2);
//        productRequests.add(productRequest3);
//        productRequests.add(productRequest4);
//        
//        
//     	String responsePost =  postProductClient.post(productRequests, String.class);
//        System.out.println("POST MEDTHOD Response ........." + responsePost);
//        
//        /*****************************************************************************************
//         * Customer logs into account
//         *****************************************************************************************/
//        System.out.println("PUT METHOD for logging in.........................................................");
//        WebClient putLoginClient = WebClient.create("http://localhost:8081/account", providers);
//        
//        WebClient.getConfig(putLoginClient).getOutInterceptors().add(new LoggingOutInterceptor());
//
//        WebClient.getConfig(putLoginClient).getInInterceptors().add(new LoggingInInterceptor());
//        
//        putLoginClient = putLoginClient.accept("application/json").type("application/json").path("/login");
//        
//        String putLoginRequestURI = putLoginClient.getCurrentURI().toString();
//        System.out.println("Client GET METHOD URI for products search Request :  " + putLoginRequestURI);
//        String putLoginRequestHeaders = putLoginClient.getHeaders().toString();
//        System.out.println("Client GET METHOD Request Headers:  " + putLoginRequestHeaders);
//        BasicEmailAccountRequestImpl customerBAR = new BasicEmailAccountRequestImpl();
//        customerBAR.setPassword("testPassword");
//        customerBAR.setEmail("test5@test.com");
//        customerBAR.setIsCustomer(true);
//        
//        
//        String putLoginResponse = putLoginClient.put(customerBAR, String.class);
//        System.out.println("PUT METHOD Response: ...." + putLoginResponse);
        
        
//        /*****************************************************************************************
//       * Partner logs into account
//       *****************************************************************************************/
//      System.out.println("PUT METHOD for logging in.........................................................");
//      WebClient putLoginClient = WebClient.create("http://localhost:8081/account", providers);
//      
//      WebClient.getConfig(putLoginClient).getOutInterceptors().add(new LoggingOutInterceptor());
//
//      WebClient.getConfig(putLoginClient).getInInterceptors().add(new LoggingInInterceptor());
//      
//      putLoginClient = putLoginClient.accept("application/json").type("application/json").path("/login/partner");
//      
//      String putLoginRequestURI = putLoginClient.getCurrentURI().toString();
//      System.out.println("Client GET METHOD URI for products search Request :  " + putLoginRequestURI);
//      String putLoginRequestHeaders = putLoginClient.getHeaders().toString();
//      System.out.println("Client GET METHOD Request Headers:  " + putLoginRequestHeaders);
//      BasicEmailAccountRequestImpl customerBAR = new BasicEmailAccountRequestImpl();
//      customerBAR.setPassword(accountRequestPartner.getPassword());
//      customerBAR.setEmail(accountRequestPartner.getEmail());
//
//      
//      
//      String putLoginResponse = putLoginClient.put(customerBAR, String.class);
//      System.out.println("PUT METHOD Response: ...." + putLoginResponse);
        
//        /*****************************************************************************************
//       * Partner gets inventory
//       *****************************************************************************************/
//      System.out.println("GET METHOD for searching for product.........................................................");
//      WebClient getProductSearchClient = WebClient.create("http://localhost:8081/products", providers);
//      
//      WebClient.getConfig(getProductSearchClient).getOutInterceptors().add(new LoggingOutInterceptor());
//
//      WebClient.getConfig(getProductSearchClient).getInInterceptors().add(new LoggingInInterceptor());
//      
//      getProductSearchClient = getProductSearchClient.accept("application/json").type("application/json").path("/inventory/"+accountRequestPartner.getUsername());
//      
//      String getProductSearchRequestURI = getProductSearchClient.getCurrentURI().toString();
//      System.out.println("Client GET METHOD URI for products search Request :  " + getProductSearchRequestURI);
//      String getProductSearchRequestHeaders = getProductSearchClient.getHeaders().toString();
//      System.out.println("Client GET METHOD Request Headers:  " + getProductSearchRequestHeaders);
//      
//      
//      String productSearchResponse = getProductSearchClient.get(String.class);
//      System.out.println("GET METHOD Response: ...." + productSearchResponse);
//      
//      //to get the response as object of Employee class
//      //Employee employee = client.get(Employee.class);
//      Collection<MinProductRepresentationImpl> searchResults = (Collection<MinProductRepresentationImpl>)getProductSearchClient.getCollection(MinProductRepresentationImpl.class);
//      
//      System.out.println("Searched products: ");
//      for(MinProductRepresentationImpl p: searchResults) {
//      	System.out.println("Product name : " + p.getProductName()+" costs $"+p.getProductCost());
//      }
      
//      System.out.println("Name:" + employee.getFirstName());
//      System.out.println("privileges:" + employee.getPrivileges());
      
      
////
////        
//        /*****************************************************************************************
//         * Customer searches for a product
//         *****************************************************************************************/
//        System.out.println("GET METHOD for searching for product.........................................................");
//        WebClient getProductSearchClient = WebClient.create("http://localhost:8081/products", providers);
//        
//        WebClient.getConfig(getProductSearchClient).getOutInterceptors().add(new LoggingOutInterceptor());
//
//        WebClient.getConfig(getProductSearchClient).getInInterceptors().add(new LoggingInInterceptor());
//        
//        getProductSearchClient = getProductSearchClient.accept("application/json").type("application/json").path("/");
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
//        Collection<MinProductRepresentationImpl> searchResults = (Collection<MinProductRepresentationImpl>)getProductSearchClient.getCollection(MinProductRepresentationImpl.class);
//        
//        System.out.println("Searched products: ");
//        for(MinProductRepresentationImpl p: searchResults) {
//        	System.out.println("Product name : " + p.getProductName()+" costs $"+p.getProductCost());
//        }
        
//        System.out.println("Name:" + employee.getFirstName());
//        System.out.println("privileges:" + employee.getPrivileges());
        
////        
////        /*****************************************************************************************
////         * Customer builds personal profile
////         *****************************************************************************************/
////        
////        
////        
////        
////        /*****************************************************************************************
////         * Customer builds bank and payment profile
////         *****************************************************************************************/
////        
////        
////        
        /*****************************************************************************************
         * Customer Buys a product
         *****************************************************************************************/
        
        System.out.println("POST METHOD for placing an order .........................................................");
        WebClient postOrderClient = WebClient.create("http://localhost:8081/orders", providers);
        
        WebClient.getConfig(postOrderClient).getOutInterceptors().add(new LoggingOutInterceptor());
        WebClient.getConfig(postOrderClient).getInInterceptors().add(new LoggingInInterceptor());
        
        postOrderClient = postOrderClient.accept("application/json").type("application/json").path("/"+accountRequest.getUsername());
        
        String getOrderRequestURI = postOrderClient.getCurrentURI().toString();
        System.out.println("Client POST METHOD  to  Order URI:  " + getOrderRequestURI);
        String getOrderRequestHeaders = postOrderClient.getHeaders().toString();
        System.out.println("Client POST METHOD Order Headers:  " + getOrderRequestHeaders);
        
        ProductRequestImpl productRequest1 = new ProductRequestImpl();
      productRequest1.setProductName("Surface book");
      productRequest1.setProductCost(20.0);
      productRequest1.setProductTag("expensive");
      productRequest1.setProductType("Laptop");
      
      ProductRequestImpl productRequest2 = new ProductRequestImpl();
      productRequest2.setProductName("Harry Potter");
      productRequest2.setProductCost(30.0);
      productRequest2.setProductTag("fantasy");
      productRequest2.setProductType("Book");
      
      ProductRequestImpl productRequest3 = new ProductRequestImpl();
      productRequest3.setProductName("Introduction to algorithms");
      productRequest3.setProductCost(50.0);
      productRequest3.setProductTag("computer science");
      productRequest3.setProductType("Book");
      
      Set<ProductRequestImpl> shoppingCart = new HashSet<>();
      shoppingCart.add(productRequest1);
      shoppingCart.add(productRequest2);
      shoppingCart.add(productRequest3);
        
        
        
        String orderResponse = postOrderClient.post(shoppingCart,String.class);
        System.out.println("GET METHOD Response: ...." + orderResponse);
       
       
        System.exit(0);
	}

}
