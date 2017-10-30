package Service.Resource.Account;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import Service.Representation.Account.BankInfoRepresentation;
import Service.Representation.Account.BankInfoRequest;

@Path("/")
public class BankInfoResource implements BankInfoService{
	
	

	@PUT
	@Consumes({"application/xml","application/json"})
	@Path("/account")
	@Override
	public void updateBankName(@QueryParam("account_number")String bankAccountNumber, @QueryParam("bank_name")String newBankName) {
		// TODO Auto-generated method stub
		
	}

	@PUT
	@Consumes({"application/xml","application/json"})
	@Path("/account")
	@Override
	public void updateAccountNumber(@QueryParam("account_number")String oldAccountNumber, @QueryParam("account_number")String newAccountNumber) {
		// TODO Auto-generated method stub
		
	}

	@PUT
	@Consumes({"application/xml","application/json"})
	@Path("/account")
	@Override
	public void updateRoutingNumber(@QueryParam("account_number")String accountNumber, @QueryParam("routing_number")String newRoutingNumber) {
		// TODO Auto-generated method stub
		
	}

	@PUT
	@Consumes({"application/xml","application/json"})
	@Path("/account")
	@Override
	public void updateSwiftCode(@QueryParam("account_number")String accountNumber, @QueryParam("new_swift_code")int newSwiftCode) {
		// TODO Auto-generated method stub
		
	}

	@PUT
	@Consumes({"application/xml","application/json"})
	@Path("/account")
	@Override
	public void updateAccountType(@QueryParam("account_number")String accountNumber, @QueryParam("account_type")String newAccountType) {
		// TODO Auto-generated method stub
		
	}

	@PUT
	@Consumes({"application/xml","application/json"})
	@Path("/account")
	@Override
	public void updateCardNumber(@QueryParam("card_number")String cardNumber, @QueryParam("new_card_number")String newPaymentCard) {
		// TODO Auto-generated method stub
		
	}

	@PUT
	@Consumes({"application/xml","application/json"})
	@Path("/account")
	@Override
	public void updateCardExpirationDate(@QueryParam("card_number")String cardNumber, @QueryParam("new_Date")String newDate) {
		// TODO Auto-generated method stub
		
	}

	@PUT
	@Consumes({"application/xml","application/json"})
	@Path("/account")
	@Override
	public void updateNameOnCard(@QueryParam("card_number")String cardNumber, @QueryParam("card_name")String newNameOncard) {
		// TODO Auto-generated method stub
		
	}

	@PUT
	@Consumes({"application/xml","application/json"})
	@Path("/account")
	@Override
	public void updateSecurityCode(@QueryParam("card_number")String cardNumber, @QueryParam("new_security_code")String newSecurityCode) {
		// TODO Auto-generated method stub
		
	}

	@GET
	@Produces({"application/xml","application/json"})
	@Path("/account")
	@Override
	public BankInfoRepresentation getBankInfo(@QueryParam("username")String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@DELETE
	@Consumes({"application/xml","application/json"})
	@Path("/account")
	@Override
	public void deleteBankName(@QueryParam("account_number")String bankAccountNumber,@QueryParam("bank_name")String bankName) {
		// TODO Auto-generated method stub
		
	}

	@DELETE
	@Consumes({"application/xml","application/json"})
	@Path("/account")
	@Override
	public void deleteAccountNumber(@QueryParam("account_number")String accountNumber) {
		// TODO Auto-generated method stub
		
	}

	@DELETE
	@Consumes({"application/xml","application/json"})
	@Path("/account")
	@Override
	public void deleteRoutingNumber(@QueryParam("account_number")String accountNumber,@QueryParam("routing_number")String routingNumber) {
		// TODO Auto-generated method stub
		
	}

	@DELETE
	@Consumes({"application/xml","application/json"})
	@Path("/account")
	@Override
	public void deleteSwiftCode(@QueryParam("account_number")String accountNumber,@QueryParam("swift_code")String swiftCode) {
		// TODO Auto-generated method stub
		
	}

	@DELETE
	@Consumes({"application/xml","application/json"})
	@Path("/account")
	@Override
	public void deleteAccountType(@QueryParam("account_number")String accountNumber,@QueryParam("account_type")String accountType) {
		// TODO Auto-generated method stub
		
	}

	@DELETE
	@Consumes({"application/xml","application/json"})
	@Path("/account")
	@Override
	public void deleteCardNumber(@QueryParam("card_number")String cardNumber) {
		// TODO Auto-generated method stub
		
	}

	@DELETE
	@Consumes({"application/xml","application/json"})
	@Path("/account")
	@Override
	public void deleteCardExpirationDate(@QueryParam("card_number")String cardNumber,@QueryParam("expiration_date")String expirationDate) {
		// TODO Auto-generated method stub
		
	}

	@DELETE
	@Consumes({"application/xml","application/json"})
	@Path("/account")
	@Override
	public void deleteNameOnCard(@QueryParam("card_number")String cardNumber,@QueryParam("card_name")String cardName) {
		// TODO Auto-generated method stub
		
	}

	@DELETE
	@Consumes({"application/xml","application/json"})
	@Path("/account")
	@Override
	public void deleteSecurityCode( @QueryParam("card_number") String cardNumber, @QueryParam("security_code") int securityCode ) {
		// TODO Auto-generated method stub
		
	}

	@POST
	@Produces({"application/xml","application/json"})
	@Consumes({"application/xml","application/json"})
	@Path("/account")
	@Override
	public void createBankInformation(BankInfoRequest bankInformation) {
		// TODO Auto-generated method stub
		
	}

}
