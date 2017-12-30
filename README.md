# Lakeshore Market

## Overview

Lakeshore marketplace is a system that provides e-commerce related web service APIs 
 
## Core dependencies/libraries/frameworks

 - [Hibernate](http://hibernate.org/)
 - [MySQL](https://www.mysql.com/)
 - [Java](https://www.oracle.com/java/index.html)
 - [Spring DI](https://projects.spring.io/spring-framework/)
 - [Apache Tomcat](https://tomcat.apache.org/)
 - [CXF](http://cxf.apache.org/)
 - [ReactiveX](http://reactivex.io/)
 - [Mockito](http://site.mockito.org/)
 - [JUnit](http://junit.org/junit5/)
 
 ## Tomcat Server Connection Details
 
 - **Host:**
 - **Project Name:**
 - **User:**
 - **Password:**
 
 
 ## Class Diagram
 found in the design folder

 
 
## Tests

Tests are written using `Junit` and also `mockito` to mock objects. The highly modularized and decoupled architecture allows for easy test writing

 

## Architectural overview

12 Factor App

At a higher level, the project was designed in 3 separate layers with high emphasis placed on decoupling and coherence of the system. This is mainly 
achieved by modularizing our code and using various principles such as dependency inversion, open-closed principle and single responsibility principles. 
Various design patterns have also been used to represent repeated design elements. The three layers used in the design of the program are the service layer, 
domain layer, and data access layer. The service layer is a structure built using `Java` and `CXF` running on Apache’s `tomcat` server. The domain layer is written 
in java and uses `ReactiveX` Java to manage asynchronous tasks and uses `spring` to manage dependency injection. This makes testing easier and minimizes code modifications 
when adding new features. The data access layer uses hibernate to persist objects into a `MySQL` database server. At various stages in the design process, we were iteratively 
modifying our designs.

## Use Cases

### The buying experience

### Customer Registration

### Partner Registration



## Web service details

Endpoints currently provide the following functionalities:
 ### Customer functionalities
  - Search for a product by either name, id, product type, or seller
  - retrieve `n` most recent products
  - Create account for customer
  - Retrieve account details of the customer
  - delete account for customer
  - modify account details such as personal information or payment information
  - Place an order
  - Cancel an order
  - Retrieve Order confirmation and details
  - Retrieve order history
  - Track placed order
  
  
 ### Partner/Seller functionalities
  - Create account for partner
  - Retrieve account details of the partner
  - delete account for partner
  - modify account details such as personal information or bank information
  - Add products to inventory
  - Remove products from inventory
  - Modify product details
  - Retrieve placed order history
  - Retrieve most recently placed orders to Partner
  - Retrieve Inventory
  - Provide delivery details on a placed order
   
 A detailed documentation of the Endpoints can be found on Swagger [here](https://swaggerhub.com/apis/ljohnson24/LakeShore_MarketPlace_API/0.0.1)
   
   
 ### Error and Exception handling
 



