package Domain.Order;

public interface OrderCancellation {
    void cancelProccessedOrder(Order retrievedOrder);

    void cancelDeliveredOrder(Order retrievedOrder);

}
