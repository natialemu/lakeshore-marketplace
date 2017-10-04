package Domain.Order;

public class OrderCancellationImpl implements OrderCancellation{
    @Override
    public void cancelProccessedOrder(Order retrievedOrder) {
        System.out.println("Proccessed Order cancelled!");
    }

    @Override
    public void cancelDeliveredOrder(Order retrievedOrder) {
        System.out.println("Delivered Order cancelled!");

    }
}
