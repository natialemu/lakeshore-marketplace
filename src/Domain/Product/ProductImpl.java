package Domain.Product;
import java.util.Comparator;

public class ProductImpl implements Product {
	private ProductDetail productDetail;
	private Partner partner;
	
	public Partner getParner(){
		return this.partner;
	}
	
	public void setPartner(Partner partner){
		this.partner = partner;
	}
	
	public ProductDetail getProductDetail(){
		return this.productDetail;
	}
	
	public void setProductDetail(ProductDetail productDetail){
		this.productDetail = productDetail;
	}
	
	/*Comparator for sorting the list by Product Type - Ascending*/
    public static Comparator<Product> ProductTypeAscComparator = new Comparator<Product>() {

	public int compare(Product p1, Product p2) {
	   String ProductType1 = p1.getProductDetails().getProductType().toUpperCase();
	   String ProductType2 = p2.getProductDetails().getProductType().toUpperCase();

	   //ascending order
	   return ProductType1.compareTo(ProductType2);

    }};
    
    /*Comparator for sorting the list by Product Type - Ascending*/
    public static Comparator<Product> ProductTypeDesComparator = new Comparator<Product>() {

	public int compare(Product p1, Product p2) {
	   String ProductType1 = p1.getProductDetails().getProductType().toUpperCase();
	   String ProductType2 = p2.getProductDetails().getProductType().toUpperCase();

	   //descending order
	   return ProductType2.compareTo(ProductType1);

    }};
    
    /*Comparator for sorting the list by Product Name - Ascending*/
    public static Comparator<Product> ProductNameAscComparator = new Comparator<Product>() {

	public int compare(Product p1, Product p2) {
	   String ProductName1 = p1.getProductDetails().getProductName().toUpperCase();
	   String ProductName2 = p2.getProductDetails().getProductName().toUpperCase();

	   //ascending order
	   return ProductName1.compareTo(ProductName2);

    }};
    
    /*Comparator for sorting the list by Product Name -Descending*/
    public static Comparator<Product> ProductNameDesComparator = new Comparator<Product>() {

	public int compare(Product p1, Product p2) {
	   String ProductName1 = p1.getProductDetails().getProductName().toUpperCase();
	   String ProductName2 = p2.getProductDetails().getProductName().toUpperCase();

	   //descending order
	   return ProductName2.compareTo(ProductName1);

    }};
    
    /*Comparator for sorting the list by Product Tag - Ascending*/
    public static Comparator<Product> ProductTagAscComparator = new Comparator<Product>() {

	public int compare(Product p1, Product p2) {
	   String ProductTag1 = p1.getProductDetails().getProductTag().toUpperCase();
	   String ProductTag2 = p2.getProductDetails().getProductTag().toUpperCase();

	   //ascending order
	   return ProductTag1.compareTo(ProductTag2);

    }};
    
    /*Comparator for sorting the list by Product Tag - Descending*/
    public static Comparator<Product> ProductTagDesComparator = new Comparator<Product>() {

	public int compare(Product p1, Product p2) {
	   String ProductTag1 = p1.getProductDetails().getProductTag().toUpperCase();
	   String ProductTag2 = p2.getProductDetails().getProductTag().toUpperCase();

	   //descending order
	   return ProductTag2.compareTo(ProductTag1);

    }};
    
    /*Comparator for sorting the list by Product Cost - Ascending*/
    public static Comparator<Product> ProductCostAscComparator = new Comparator<Product>() {

	public int compare(Product p1, Product p2) {
	   double ProductCost1 = p1.getProductDetails().getProductCost();
	   double ProductCost2 = p2.getProductDetails().getProductCost();

	   //Ascending order
	   return ((int)ProductCost1 - (int)ProductCost2);

    }};
    
    /*Comparator for sorting the list by Product Cost - Descending*/
    public static Comparator<Product> ProductCostDesComparator = new Comparator<Product>() {

	public int compare(Product p1, Product p2) {
	   double ProductCost1 = p1.getProductDetails().getProductCost();
	   double ProductCost2 = p2.getProductDetails().getProductCost();

	   //Descending order
	   return ((int)ProductCost2 - (int)ProductCost1);

    }};
    
    /*Comparator for sorting the list by Product ID - Ascending*/
    public static Comparator<Product> ProductIDAscComparator = new Comparator<Product>() {

	public int compare(Product p1, Product p2) {
	   double ProductID1 = p1.getProductDetails().getProductID();
	   double ProductID2 = p2.getProductDetails().getProductID();

	   //Ascending order
	   return ((int)ProductID1 - (int)ProductID2);

    }};
    
    /*Comparator for sorting the list by Product ID - descending*/
    public static Comparator<Product> ProductIDDesComparator = new Comparator<Product>() {

	public int compare(Product p1, Product p2) {
	   double ProductID1 = p1.getProductDetails().getProductID();
	   double ProductID2 = p2.getProductDetails().getProductID();

	   //descending order
	   return ((int)ProductID2 - (int)ProductID1);

    }};
	
	/*Comparator for sorting the list by Product PartnerName - Ascending*/
    public static Comparator<Product> ProductPartnerNameAscComparator = new Comparator<Product>() {

	public int compare(Product p1, Product p2) {
	   String ProductID1 = p1.getProductDetails().getProductPartnerName().toUpperCase();
	   String ProductID2 = p2.getProductDetails().getProductPartnerName().toUpperCase();

	   ///ascending order
	   return ProductTag1.compareTo(ProductTag2);

    }};
	
	/*Comparator for sorting the list by Product PartnerName - descending*/
    public static Comparator<Product> ProductPartnerNameDesComparator = new Comparator<Product>() {

	public int compare(Product p1, Product p2) {
	   String ProductID1 = p1.getProductDetails().getProductPartnerName().toUpperCase();
	   String ProductID2 = p2.getProductDetails().getProductPartnerName().toUpperCase();

	   ///descending order
	   return ProductTag2.compareTo(ProductTag1);

    }};
	
	/*Comparator for sorting the list by Product Partner ID - Ascending*/
    public static Comparator<Product> ProductPartnerIDAscComparator = new Comparator<Product>() {

	public int compare(Product p1, Product p2) {
	   double ProductID1 = p1.getProductDetails().getProductPartnerID().toUpperCase();
	   double ProductID2 = p2.getProductDetails().getProductPartnerID().toUpperCase();

	   //Ascending order
	   return ((int)ProductID1 - (int)ProductID2);

    }};
	
	/*Comparator for sorting the list by Product Partner ID - Descending*/
    public static Comparator<Product> ProductPartnerIDDesComparator = new Comparator<Product>() {

	public int compare(Product p1, Product p2) {
	   double ProductID1 = p1.getProductDetails().getProductPartnerID().toUpperCase();
	   double ProductID2 = p2.getProductDetails().getProductPartnerID().toUpperCase();

	   //Descending order
	   return ((int)ProductID2 - (int)ProductID1);

    }};
}

