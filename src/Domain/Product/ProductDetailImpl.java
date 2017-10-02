package Domain.Product;
import java.util.Comparator;

public class ProductDetailImpl implements ProductDetail {
	private String productName;
	private long productID;
	private double productCost;
	private String productType;
	private String productTag;
	private String productPhoto;
	
	public ProductDetailImpl(String productName, long productID, double productCost, String productType, String productTag, String productPhoto) {
		this.productName=productName; this.productID = productID; this.productCost = productCost; this.productType = productType;
		this.productTag = productTag; this.productPhoto = productPhoto;
	}
	
	public String getProductName() {
		return this.productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public long getProductID() {
		return this.productID;
	}
	
	public void setProductID(long productID) {
		this.productID = productID;
	}
	
	public double getProductCost() {
		return this.productCost;
	}
	
	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}
	
	public String getProductType() {
		return this.productType;
	}
	
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	public String getProductTag() {
		return this.productTag;
	}
	
	public void setProductTag(String productTag) {
		this.productTag = productTag;
	}
	
	public String getProductPhoto() {
		return this.productPhoto;
	}

	public void setProductPhoto(String productPhoto) {
		this.productPhoto = productPhoto;
	}
	
	@Override
	public String toString() {
		return "ProductDetail{" + 
				"productName='" + productName + '\'' +
				", productID='" + productID + '\'' +
				", productCost'" + productCost + '\'' +
				", productType'" + productType + '\'' +
				", productTag'" + productTag + '\'' +
				", productPhoto'" + productPhoto + '\'' +
				'}';
	}
	
	/*Comparator for sorting the list by Product Type - Ascending*/
    public static Comparator<ProductDetail> ProductTypeAscComparator = new Comparator<ProductDetail>() {

	public int compare(ProductDetail p1, ProductDetail p2) {
	   String ProductType1 = p1.getProductType().toUpperCase();
	   String ProductType2 = p2.getProductType().toUpperCase();

	   //ascending order
	   return ProductType1.compareTo(ProductType2);

    }};
    
    /*Comparator for sorting the list by Product Type - Ascending*/
    public static Comparator<ProductDetail> ProductTypeDesComparator = new Comparator<ProductDetail>() {

	public int compare(ProductDetail p1, ProductDetail p2) {
	   String ProductType1 = p1.getProductType().toUpperCase();
	   String ProductType2 = p2.getProductType().toUpperCase();

	   //descending order
	   return ProductType2.compareTo(ProductType1);

    }};
    
    /*Comparator for sorting the list by Product Name - Ascending*/
    public static Comparator<ProductDetail> ProductNameAscComparator = new Comparator<ProductDetail>() {

	public int compare(ProductDetail p1, ProductDetail p2) {
	   String ProductName1 = p1.getProductName().toUpperCase();
	   String ProductName2 = p2.getProductName().toUpperCase();

	   //ascending order
	   return ProductName1.compareTo(ProductName2);

    }};
    
    /*Comparator for sorting the list by Product Name -Descending*/
    public static Comparator<ProductDetail> ProductNameDesComparator = new Comparator<ProductDetail>() {

	public int compare(ProductDetail p1, ProductDetail p2) {
	   String ProductName1 = p1.getProductName().toUpperCase();
	   String ProductName2 = p2.getProductName().toUpperCase();

	   //descending order
	   return ProductName2.compareTo(ProductName1);

    }};
    
    /*Comparator for sorting the list by Product Tag - Ascending*/
    public static Comparator<ProductDetail> ProductTagAscComparator = new Comparator<ProductDetail>() {

	public int compare(ProductDetail p1, ProductDetail p2) {
	   String ProductTag1 = p1.getProductTag().toUpperCase();
	   String ProductTag2 = p2.getProductTag().toUpperCase();

	   //ascending order
	   return ProductTag1.compareTo(ProductTag2);

    }};
    
    /*Comparator for sorting the list by Product Tag - Descending*/
    public static Comparator<ProductDetail> ProductTagDesComparator = new Comparator<ProductDetail>() {

	public int compare(ProductDetail p1, ProductDetail p2) {
	   String ProductTag1 = p1.getProductTag().toUpperCase();
	   String ProductTag2 = p2.getProductTag().toUpperCase();

	   //descending order
	   return ProductTag2.compareTo(ProductTag1);

    }};
    
    /*Comparator for sorting the list by Product Cost - Ascending*/
    public static Comparator<ProductDetail> ProductCostAscComparator = new Comparator<ProductDetail>() {

	public int compare(ProductDetail p1, ProductDetail p2) {
	   double ProductCost1 = p1.getProductCost();
	   double ProductCost2 = p2.getProductCost();

	   //Ascending order
	   return ((int)ProductCost1 - (int)ProductCost2);

    }};
    
    /*Comparator for sorting the list by Product Cost - Descending*/
    public static Comparator<ProductDetail> ProductCostDesComparator = new Comparator<ProductDetail>() {

	public int compare(ProductDetail p1, ProductDetail p2) {
	   double ProductCost1 = p1.getProductCost();
	   double ProductCost2 = p2.getProductCost();

	   //Descending order
	   return ((int)ProductCost2 - (int)ProductCost1);

    }};
    
    /*Comparator for sorting the list by Product ID - Ascending*/
    public static Comparator<ProductDetail> ProductIDAscComparator = new Comparator<ProductDetail>() {

	public int compare(ProductDetail p1, ProductDetail p2) {
	   double ProductID1 = p1.getProductID();
	   double ProductID2 = p2.getProductID();

	   //Ascending order
	   return ((int)ProductID1 - (int)ProductID2);

    }};
    
    /*Comparator for sorting the list by Product ID - descending*/
    public static Comparator<ProductDetail> ProductIDDesComparator = new Comparator<ProductDetail>() {

	public int compare(ProductDetail p1, ProductDetail p2) {
	   double ProductID1 = p1.getProductID();
	   double ProductID2 = p2.getProductID();

	   //descending order
	   return ((int)ProductID2 - (int)ProductID1);

    }};

}