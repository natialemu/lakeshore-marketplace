package Domain.Order;

import Domain.Customer.Customer;
import Domain.Delivery.Delivery;
import Domain.Delivery.DeliveryFactory;
import Domain.Delivery.DeliveryFactoryImpl;
import Domain.Order.OrderValidation.OrderValidation;
import Domain.Order.OrderValidation.OrderValidationCommand.*;
import Domain.Order.OrderValidation.OrderValidationImpl;
import Domain.Product.Product;
import Domain.Transaction.Transaction;
import Domain.Transaction.TransactionFactory;
import Domain.Transaction.TransactionFactoryImpl;
import Domain.Transaction.TransactionImpl;
import Repository.Order.OrderDAO;
import Repository.Order.OrderDAOImpl;

import java.util.ArrayList;
import java.util.List;

public class OrderFactoryImpl implements OrderFactory{
    private TransactionFactory transaction;
    private Validator validator;
    private OrderCancellation orderCancellation;
    private Order order;
    private DeliveryFactory delivery;
    private OrderDAO orderDAO;
    private OrderValidation orderValidation;



    public OrderFactoryImpl(){
        transaction = new TransactionFactoryImpl();
        delivery = new DeliveryFactoryImpl();
        orderCancellation = new OrderCancellationImpl();
        orderValidation = new OrderValidationImpl();
        orderDAO = new OrderDAOImpl();
    }

    public boolean createOrder(List<Product> products, Customer customer){


        order = new OrderImpl(products,customer);

        validator = new ValidatorImpl(new ValidatePayment(order));
        if(validator.executeCommand()){
            order.setPaymentValidation(transaction.validatePayment(order));
        }
        validator = new ValidatorImpl(new ValidateOrderContent(order));
        if(validator.executeCommand()){
            order.setPaymentValidation(orderValidation.validateOrderContent(order));
        }
        validator = new ValidatorImpl(new ProcessPayment(order));
        if(validator.executeCommand()){
            transaction.processPayment(order);
            order.processPayment();
        }


        validator = new ValidatorImpl(new ConfirmOrder(order));
        if(validator.executeCommand()){
            confirmOrder();
            order.sendConfirmation();
        }


        validator = new ValidatorImpl(new DeliverOrder(order));
        if(validator.executeCommand()){
            delivery.sendDelivery(order);
            order.shipOrder();
        }

        return orderDAO.createOrder(order);
    }

    public boolean cancelOrder(int confirmationID){
        Order retrievedOrder = orderDAO.retrieveOrder(confirmationID);
        if(retrievedOrder.cancelOrder() && retrievedOrder.getStringOrderState().equals("ProcessedOrder")){
            orderCancellation.cancelProccessedOrder(retrievedOrder);
            orderDAO.updateStatus(retrievedOrder,retrievedOrder.getConfirmationID());
        }else if(retrievedOrder.cancelOrder() && retrievedOrder.getStringOrderState().equals("DeliveredOrder")){
            orderCancellation.cancelDeliveredOrder(retrievedOrder);
            orderDAO.updateStatus(retrievedOrder, retrievedOrder.getConfirmationID());
        }
        return true;
    }

    public String getOrderStatus(){
        return order.getStringOrderState();
    }

    public void confirmOrder(){
        System.out.println("Order sent out for delivery! ");
    }





}
