package Service.Representation.Delivery;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Delivery status")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class DeliveryRequestImpl implements DeliveryRequest{
	private String tracking_number;
    
    public DeliveryRequestImpl() {}
    
    public String getTracking_number() {
		return tracking_number;
	}

	public void setTracking_number(String tracking_number) {
		this.tracking_number = tracking_number;
	}

}