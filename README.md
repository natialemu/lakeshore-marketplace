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
 
 
## Tests

Tests are written using `Junit` and also `mockito` to mock objects. The highly modularized and decoupled architecture allows for easy test writing

 

## Architectural overview

At a higher level, the project was designed in 3 separate layers with high emphasis placed on decoupling and coherence of the system. This is mainly 
achieved by modularizing our code and using various principles such as dependency inversion, open-closed principle and single responsibility principles. 
Various design patterns have also been used to represent repeated design elements. The three layers used in the design of the program are the service layer, 
domain layer, and data access layer. The service layer is a structure built using `Java` and `CXF` running on Apache’s `tomcat` server. The domain layer is written 
in java and uses `ReactiveX` Java to manage asynchronous tasks and uses `spring` to manage dependency injection. This makes testing easier and minimizes code modifications 
when adding new features. The data access layer uses hibernate to persist objects into a `MySQL` database server. At various stages in the design process, we were iteratively 
modifying our designs.
