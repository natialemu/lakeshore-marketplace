package Repository.Product;

import Domain.Order.Order;
import Domain.Partner.Partner;
import Domain.Product.Product;
import Domain.Product.ProductImpl;
import Domain.Transaction.Transaction;
import Domain.Transaction.TransactionImpl;
import Repository.Partner.PartnerDAO;
import Repository.Partner.PartnerDAOImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO{
    private PartnerDAO partnerDAO;
    

    public ProductDAOImpl(){
        partnerDAO = new PartnerDAOImpl();
    }

    private Connection openConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/lakeshore_market", "root", "Natlocus13");


        } catch (SQLException exception) {
            exception.printStackTrace();
            //exception.printStackTrace();

        } catch (ClassNotFoundException es) {

            //es.printStackTrace();
        }

        return connection;

    }
    @Override
    public List<Product> getProducts() {
        int product_id = 0;
        String productName = null;
        double productCost = 0;
        String productType = null;
        String productPhoto = null;
        int partner_id = 0;
        String productTag= null;



        List<Product> products = new ArrayList<>();
        List<Integer> partnerIDs = new ArrayList<>();
        Connection connection = openConnection();
        try {
            Statement selectStatement = connection.createStatement();

            String selectQuery = "SELECT * from product";
            ResultSet resultSet = selectStatement.executeQuery(selectQuery);
            while(resultSet.next()){

                product_id = resultSet.getInt("product_id");
                productName = resultSet.getString("product_name");
                productCost = resultSet.getInt("product_cost");
                productType = resultSet.getString("product_type");
                productTag = resultSet.getString("product_tag");
                partner_id = resultSet.getInt("partner_id");
                productPhoto = resultSet.getString("product_photo");

                Product product = new ProductImpl(productCost,productName,productPhoto,productTag,productType);
                product.setProductID(product_id);
                products.add(product);
                partnerIDs.add(partner_id);
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }

        for(int i = 0; i < products.size();i++){
            Partner partner = partnerDAO.getPartner(partnerIDs.get(i));
            products.get(i).setPartner(partner);
        }

        return products;


    }

    @Override
    public List<Product> getProductsWithName(String productName) {
        int product_id = 0;
        double productCost = 0;
        String productType = null;
        String productPhoto = null;
        int partner_id = 0;
        String productTag= null;



        List<Product> products = new ArrayList<>();
        List<Integer> partnerIDs = new ArrayList<>();
        Connection connection = openConnection();
        try {
            Statement selectStatement = connection.createStatement();

            String selectQuery = "SELECT * from product where product_name='" + productName+"'";
            ResultSet resultSet = selectStatement.executeQuery(selectQuery);
            while(resultSet.next()){

                product_id = resultSet.getInt("product_id");
                productCost = resultSet.getInt("product_cost");
                productType = resultSet.getString("product_type");
                productTag = resultSet.getString("product_tag");
                partner_id = resultSet.getInt("partner_id");
                productPhoto = resultSet.getString("product_photo");

                Product product = new ProductImpl(productCost,productName,productPhoto,productTag,productType);
                product.setProductID(product_id);
                products.add(product);
                partnerIDs.add(partner_id);
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }

        for(int i = 0; i < products.size();i++){
            Partner partner = partnerDAO.getPartner(partnerIDs.get(i));
            products.get(i).setPartner(partner);
        }

        return products;
    }

    @Override
    public List<Product> getProductWithType(String productType) {
        int product_id = 0;
        String productName = null;
        double productCost = 0;
        String productPhoto = null;
        int partner_id = 0;
        String productTag= null;



        List<Product> products = new ArrayList<>();
        List<Integer> partnerIDs = new ArrayList<>();
        Connection connection = openConnection();
        try {
            Statement selectStatement = connection.createStatement();

            String selectQuery = "SELECT * from product where product_type='" + productType+"'";
            ResultSet resultSet = selectStatement.executeQuery(selectQuery);
            while(resultSet.next()){

                product_id = resultSet.getInt("product_id");
                productName = resultSet.getString("product_name");
                productCost = resultSet.getInt("product_cost");
                productType = resultSet.getString("product_type");
                partner_id = resultSet.getInt("partner_id");
                productPhoto = resultSet.getString("product_photo");

                Product product = new ProductImpl(productCost,productName,productPhoto,productTag,productType);
                product.setProductID(product_id);
                products.add(product);
                partnerIDs.add(partner_id);
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }

        for(int i = 0; i < products.size();i++){
            Partner partner = partnerDAO.getPartner(partnerIDs.get(i));
            products.get(i).setPartner(partner);
        }

        return products;
    }

    @Override
    public Product getProductByID(int productID) {
        String productName = null;
        double productCost = 0;
        String productPhoto = null;
        int partner_id = 0;
        String productType = null;
        String productTag= null;



        List<Product> products = new ArrayList<>();
        List<Integer> partnerIDs = new ArrayList<>();
        Connection connection = openConnection();
        try {
            Statement selectStatement = connection.createStatement();

            String selectQuery = "SELECT * from product where product_id=" + productID;
            ResultSet resultSet = selectStatement.executeQuery(selectQuery);

            resultSet.next();

                productName = resultSet.getString("product_name");
                productCost = resultSet.getInt("product_cost");
                productType = resultSet.getString("product_type");
                partner_id = resultSet.getInt("partner_id");
                productPhoto = resultSet.getString("product_photo");




        } catch (SQLException se) {
            se.printStackTrace();
        } finally {

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }


        Partner partner = partnerDAO.getPartner(partner_id);
        Product product = new ProductImpl(productCost,productName,productPhoto,productTag,productType);
        product.setProductID(productID);

        product.setPartner(partner);

        return product;
    }

    @Override
    public boolean createProduct(Product product) {
        boolean inserted = false;

        Connection connection = openConnection();
        try{
            Statement insertSatement = connection.createStatement();

            String insertQuery = "INSERT INTO product (product_id, product_name,product_cost,product_type,product_photo,partner_id,product_tag) VALUES("+product.getProductID()+",'"+product.getProductName()+"', "+product.getProductCost()+", '"+product.getProductType()+"','"+product.getProductPhoto()+"',"+product.getParner().getPartnerID()+",'"+product.getProductTag()+"')";
            insertSatement.executeUpdate(insertQuery);

            inserted = true;
        }catch (SQLException se){
            se.printStackTrace();

        }finally {
            if(connection != null){
                try {
                    connection.close();

                }catch (Exception e){}

            }
        }
        return inserted;

    }

    @Override
    public void setOrderID(Product p, int orderID) {


        Connection connection = openConnection();
        try{
            Statement updateStatement = connection.createStatement();

            String updateQuery = "UPDATE product SET order_id="+orderID+" where product_id=" + p.getProductID();
            updateStatement.executeUpdate(updateQuery);


        }catch (SQLException se){
            se.printStackTrace();

        }finally {
            if(connection != null){
                try {
                    connection.close();

                }catch (Exception e){}

            }
        }

    }

	@Override
	public List<Product> getRecentlyAddedProducts(int numOrders) {
		Connection connection = openConnection();
		List<Integer> ids = new ArrayList<>();
		try {
			Statement statement = connection.createStatement();
			String selectQuery = "SELECT TOP" +numOrders+ "product_id \r\n" + 
					"FROM table product \r\n" + 
					"GROUP BY product_id \r\n" + 
					"ORDER BY max(time) desc";
			ResultSet resultSet = statement.executeQuery(selectQuery);
	        assert (!resultSet.isLast());
	        while(resultSet.next()) {
	        	int product_id = resultSet.getInt(0);
	        	ids.add(product_id);
	        	
	        	
	        }
		}catch (SQLException se) {
	        se.printStackTrace();
	    } finally {
	
	        if (connection != null) {
	            try {
	                connection.close();
	            } catch (SQLException e) { /* ignored */}
	        }
	    }
		List<Product> products = new ArrayList<>();
		for(Integer id:ids) {
			Product product = getProductByID(id);
			products.add(product);
		}
		return products;
	}

	@Override
	public List<Product> getInventory(String username) {
		int partnerID = partnerDAO.getPartnerID(username);
		return getProductsByPartnerID(partnerID);
	}

	private List<Product> getProductsByPartnerID(int partnerID) {
        int product_Id = 0;



        List<Product> products = new ArrayList<>();
        List<Integer> productIDS = new ArrayList<>();
        Connection connection = openConnection();
        try {
            Statement selectStatement = connection.createStatement();

            String selectQuery = "SELECT * from product where partner_id=" + partnerID;
            ResultSet resultSet = selectStatement.executeQuery(selectQuery);

            while(resultSet.next()) {
                 product_Id = resultSet.getInt("product_id");
                 productIDS.add(product_Id);
            	
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
        }


        for(Integer id:productIDS) {
        	Product product = getProductByID(id);
        	products.add(product);
        }
        
        return products;
        
		
	}


}
