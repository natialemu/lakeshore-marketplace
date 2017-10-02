package Domain.Product;

public class ProductImpl {
	private ProductDetail productDetail;
	private Partner partner;
	
	public ProductDetail getProductDetail() {
		return productDetail;
	}
	
	public void setProductDetail(ProductDetail productDetail) {
		this.productDetail = productDetail;
	}
	
	public Partner getPartner() {
		return this.partner;
	}
	
	public void setPartner(Partner partner) {
		this.partner = partner;
	}
	
}
