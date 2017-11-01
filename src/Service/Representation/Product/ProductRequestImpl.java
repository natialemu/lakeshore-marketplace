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
    private double productCost;
    private String productTag;
    private String productType;

    public ProductRequestImpl() {}

	@Override
	public double getProductCost() {
		// TODO Auto-generated method stub
		return productCost;
	}

	@Override
	public void setProductCost(double productCost) {
		this.productCost = productCost;
		
	}

	@Override
	public void setProductName(String productName) {
		this.productName = productName;
		
	}

	@Override
	public void setProductTag(String productTag) {
		// TODO Auto-generated method stub
		this.productTag = productTag;
		
	}

	@Override
	public String getProductTag() {
		// TODO Auto-generated method stub
		return productTag;
	}

	@Override
	public void setProductType(String productType) {
		this.productType = productType;
		
	}

	@Override
	public String getProductType() {
		// TODO Auto-generated method stub
		return productType;
	}

	@Override
	public String getProductName() {
		// TODO Auto-generated method stub
		return productName;
	}
}
