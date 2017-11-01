package Service.Representation.Product;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Product")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class ProductRequestImpl implements ProductRequest {
    private String productName;

    public ProductRequestImpl() {}
	
	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}
	public String getProductName() {
		return productName;
	}
}
