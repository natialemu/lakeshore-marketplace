package Repository.Delivery;

import Domain.Delivery.DeliveryConfirmation;

public interface DeliveryConfirmationDAO {
    DeliveryConfirmation getConfirmation(int confirmation_id);
}
