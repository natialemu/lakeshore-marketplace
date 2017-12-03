package Service.Representation.Delivery.Request;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class DeliveryRequestImpl implements DeliveryRequest{
	private String tracking_number;
    private String deliveryCarrier;
    private String deliveryMethod;
    private String deliveryConfirmationID;
    private int orderID;
    
    @Override
    public int getOrderID() {
    	return orderID;
    }
    @Override
    public void setOrderID(int orderID) {
    	this.orderID = orderID;
    }
    
    
    public DeliveryRequestImpl() {}

	public String getTracking_number() {
		return tracking_number;
	}

	public void setTracking_number(String tracking_number) {
		this.tracking_number = tracking_number;
	}

	public String getDeliveryCarrier() {
		return deliveryCarrier;
	}

	public void setDeliveryCarrier(String deliveryCarrier) {
		this.deliveryCarrier = deliveryCarrier;
	}

	public String getDeliveryMethod() {
		return deliveryMethod;
	}

	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}

	public String getDeliveryConfirmationID() {
		return deliveryConfirmationID;
	}

	public void setDeliveryConfirmationID(String deliveryConfirmationID) {
		this.deliveryConfirmationID = deliveryConfirmationID;
	}
    
   

}