package Domain.Order.OrderState;

import Domain.Order.Order;

public class UnprocessedOrder implements OrderState{
     private Order order;

     public UnprocessedOrder(Order order){
         this.order = order;
     }


    @Override
    public boolean verifyPayment() {
        return true;
    }

    @Override
    public boolean verifyOrderContent() {
         return order.verifyPayment();
    }

    @Override
    public boolean processPayment() {
         if(order.verifyOrderContent()){
             order.setState(order.getProccessedState());
         }
        return order.verifyOrderContent();
    }

    @Override
    public boolean shipOrder() {
        return false;
    }

    @Override
    public boolean cancelOrder() {
        return false;
    }

    @Override
    public boolean sendConfirmation() {
        return false;
    }
}
