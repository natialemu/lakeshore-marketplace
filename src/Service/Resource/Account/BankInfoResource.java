package Service.Resource.Account;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import org.apache.cxf.rs.security.cors.CorsHeaderConstants;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.apache.cxf.rs.security.cors.LocalPreflight;

import Service.Representation.Account.Representation.AccountValidationRepresentation;
import Service.Representation.Account.Representation.AccountValidationRepresentationImpl;
import Service.Representation.Account.Representation.BankInfoRepresentation;
import Service.Representation.Account.Representation.BankInfoRepresentationImpl;
import Service.Representation.Account.Request.BankInfoRequest;
import Service.Representation.Account.Request.BankInfoRequestImpl;
import Service.Representation.Account.Request.BasicAccountRequest;
import Service.Workflow.Account.BankInfoActivity;
import Service.Workflow.Account.BankInfoActivityImpl;

@CrossOriginResourceSharing(
        allowOrigins = {"http://localhost:63342"}, 
        allowCredentials = true,
        		allowHeaders = {
        				
                    "'Accept': 'application/json'",
                    "'Content-Type': 'application/json'"
                
        		        }
        		   
        
)
@Path("/bank/")
public class BankInfoResource implements BankInfoService{
	
	@Context
	private HttpHeaders headers;
	
	@OPTIONS
    @Path("/")
    @LocalPreflight
    public Response options() {
        String origin = headers.getRequestHeader("Origin").get(0);
        
        if("http://localhost:63342".equals(origin)) {return Response.ok()
                           .header(CorsHeaderConstants.HEADER_AC_ALLOW_METHODS, "POST PUT")
                           .header(CorsHeaderConstants.HEADER_AC_ALLOW_CREDENTIALS, "true")
                           .header(CorsHeaderConstants.HEADER_AC_ALLOW_ORIGIN, "http://localhost:63342")
                           .header(CorsHeaderConstants.HEADER_AC_ALLOW_HEADERS, "Content-Type")
                           .build();
        }else {
        	return Response.ok().build();
        }
	}
	@OPTIONS
    @Path("/{username}")
    @LocalPreflight
    public Response options(@PathParam("username") String username) {
        String origin = headers.getRequestHeader("Origin").get(0);
        
        if("http://localhost:63342".equals(origin)) {return Response.ok()
                           .header(CorsHeaderConstants.HEADER_AC_ALLOW_METHODS, "POST PUT DELETE GET")
                           .header(CorsHeaderConstants.HEADER_AC_ALLOW_CREDENTIALS, "true")
                           .header(CorsHeaderConstants.HEADER_AC_ALLOW_ORIGIN, "http://localhost:63342")
                           .header(CorsHeaderConstants.HEADER_AC_ALLOW_HEADERS, "Content-Type")
                           .build();
        }else {
        	return Response.ok().build();
        }
	}
	

	@PUT
	@Consumes({"application/xml","application/json"})
	@Path("/")
	@Override
	public void updateBankName(@QueryParam("account_number")String bankAccountNumber, @QueryParam("bank_name")String newBankName) {
		// TODO Auto-generated method stub
		BankInfoActivity bankInfoActivity = new BankInfoActivityImpl();
		bankInfoActivity.updateBankName(bankAccountNumber,newBankName);
		
		
	}

	@PUT
	@Consumes({"application/xml","application/json"})
	@Path("/")
	@Override
	public void updateAccountNumber(@QueryParam("account_number")String oldAccountNumber, @QueryParam("account_number")String newAccountNumber) {
		// TODO Auto-generated method stub
		BankInfoActivity bankInfoActivity = new BankInfoActivityImpl();
		bankInfoActivity.updateAccountNumber(oldAccountNumber,newAccountNumber);
		
	}

	@PUT
	@Consumes({"application/xml","application/json"})
	@Path("/")
	@Override
	public void updateRoutingNumber(@QueryParam("account_number")String accountNumber, @QueryParam("routing_number")String newRoutingNumber) {
		// TODO Auto-generated method stub
		BankInfoActivity bankInfoActivity = new BankInfoActivityImpl();
		bankInfoActivity.updateRoutingNumber(accountNumber,newRoutingNumber);
	}

	@PUT
	@Consumes({"application/xml","application/json"})
	@Path("/")
	@Override
	public void updateSwiftCode(@QueryParam("account_number")String accountNumber, @QueryParam("new_swift_code")int newSwiftCode) {
		// TODO Auto-generated method stub
		BankInfoActivity bankInfoActivity = new BankInfoActivityImpl();
		bankInfoActivity.updateSwiftCode(accountNumber,newSwiftCode);
		
	}

	@PUT
	@Consumes({"application/xml","application/json"})
	@Path("/")
	@Override
	public void updateAccountType(@QueryParam("account_number")String accountNumber, @QueryParam("account_type")String newAccountType) {
		// TODO Auto-generated method stub
		BankInfoActivity bankInfoActivity = new BankInfoActivityImpl();
		bankInfoActivity.updateAccountType(accountNumber,newAccountType);
		
	}

	@PUT
	@Consumes({"application/xml","application/json"})
	@Path("/")
	@Override
	public void updateCardNumber(@QueryParam("card_number")String cardNumber, @QueryParam("new_card_number")String newPaymentCard) {
		// TODO Auto-generated method stub
		BankInfoActivity bankInfoActivity = new BankInfoActivityImpl();
		bankInfoActivity.updateCardNumber(cardNumber,newPaymentCard);
		
	}

	@PUT
	@Consumes({"application/xml","application/json"})
	@Path("/")
	@Override
	public void updateCardExpirationDate(@QueryParam("card_number")String cardNumber, @QueryParam("new_Date")String newDate) {
		// TODO Auto-generated method stub
		BankInfoActivity bankInfoActivity = new BankInfoActivityImpl();
		bankInfoActivity.updateCardExpirationDate(cardNumber,newDate);
		
	}

	@PUT
	@Consumes({"application/xml","application/json"})
	@Path("/")
	@Override
	public void updateNameOnCard(@QueryParam("card_number")String cardNumber, @QueryParam("card_name")String newNameOncard) {
		// TODO Auto-generated method stub
		BankInfoActivity bankInfoActivity = new BankInfoActivityImpl();
		bankInfoActivity.updateNameOnCard(cardNumber,newNameOncard);
		
	}

	@PUT
	@Consumes({"application/xml","application/json"})
	@Path("/")
	@Override
	public void updateSecurityCode(@QueryParam("card_number")String cardNumber, @QueryParam("new_security_code")String newSecurityCode) {
		BankInfoActivity bankInfoActivity = new BankInfoActivityImpl();
		bankInfoActivity.updateSecurityCode(cardNumber,newSecurityCode);
		
	}

	@GET
	@Produces({"application/xml","application/json"})
	@Path("/{username}")
	@Override
	public BankInfoRepresentationImpl getBankInfo(@PathParam("username") String username) {
		BankInfoActivity bankInfoActivity = new BankInfoActivityImpl();
	    return bankInfoActivity.getBankInfo(username);
	
	}

	@DELETE
	@Consumes({"application/xml","application/json"})
	@Path("/")
	@Override
	public void deleteBankName(@QueryParam("account_number")String bankAccountNumber,@QueryParam("bank_name")String bankName) {
		BankInfoActivity bankInfoActivity = new BankInfoActivityImpl();
		bankInfoActivity.deleteBankName(bankAccountNumber,bankName);
		
	}

	@DELETE
	@Consumes({"application/xml","application/json"})
	@Path("/bank-information")
	@Override
	public void deleteAccountNumber(@QueryParam("account_number")String accountNumber) {
		// TODO Auto-generated method stub
		BankInfoActivity bankInfoActivity = new BankInfoActivityImpl();
		bankInfoActivity.deleteAccountNumber(accountNumber);
		
	}

	@DELETE
	@Consumes({"application/xml","application/json"})
	@Path("/")
	@Override
	public void deleteRoutingNumber(@QueryParam("account_number")String accountNumber,@QueryParam("routing_number")String routingNumber) {
		// TODO Auto-generated method stub
		BankInfoActivity bankInfoActivity = new BankInfoActivityImpl();
		bankInfoActivity.deleteRoutingNumber(accountNumber,routingNumber);
		
	}

	@DELETE
	@Consumes({"application/xml","application/json"})
	@Path("/bank-information")
	@Override
	public void deleteSwiftCode(@QueryParam("account_number")String accountNumber,@QueryParam("swift_code")String swiftCode) {
		// TODO Auto-generated method stub
		BankInfoActivity bankInfoActivity = new BankInfoActivityImpl();
		bankInfoActivity.deleteSwiftCode(accountNumber,swiftCode);
		
	}

	@DELETE
	@Consumes({"application/xml","application/json"})
	@Path("/")
	@Override
	public void deleteAccountType(@QueryParam("account_number")String accountNumber,@QueryParam("account_type")String accountType) {
		// TODO Auto-generated method stub
		BankInfoActivity bankInfoActivity = new BankInfoActivityImpl();
		bankInfoActivity.deleteAccountType(accountNumber,accountType);
		
	}

	@DELETE
	@Consumes({"application/xml","application/json"})
	@Path("/")
	@Override
	public void deleteCardNumber(@QueryParam("card_number")String cardNumber) {
		// TODO Auto-generated method stub
		BankInfoActivity bankInfoActivity = new BankInfoActivityImpl();
		bankInfoActivity.deleteCardNumber(cardNumber);
		
	}

	@DELETE
	@Consumes({"application/xml","application/json"})
	@Path("/")
	@Override
	public void deleteCardExpirationDate(@QueryParam("card_number")String cardNumber,@QueryParam("expiration_date")String expirationDate) {
		// TODO Auto-generated method stub
		
		BankInfoActivity bankInfoActivity = new BankInfoActivityImpl();
		bankInfoActivity.deleteCardExpirationDate(cardNumber,expirationDate);
	}

	@DELETE
	@Consumes({"application/xml","application/json"})
	@Path("/")
	@Override
	public void deleteNameOnCard(@QueryParam("card_number")String cardNumber,@QueryParam("card_name")String cardName) {
		// TODO Auto-generated method stub
		
		BankInfoActivity bankInfoActivity = new BankInfoActivityImpl();
		bankInfoActivity.deleteNameOnCard(cardNumber,cardName);
	}

	@DELETE
	@Consumes({"application/xml","application/json"})
	@Path("/")
	@Override
	public void deleteSecurityCode( @QueryParam("card_number") String cardNumber, @QueryParam("security_code") int securityCode ) {
		// TODO Auto-generated method stub
		BankInfoActivity bankInfoActivity = new BankInfoActivityImpl();
		bankInfoActivity.deleteSecurityCode(cardNumber,securityCode);
		
	}

	@POST
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	@Path("/{username}")
	@Override
	public AccountValidationRepresentationImpl createBankInformation(@PathParam("username") String username,BankInfoRequestImpl bankInformation) {
		// TODO Auto-generated method stub
		BankInfoActivity bankInfoActivity = new BankInfoActivityImpl();
		return bankInfoActivity.createBankInformation(username,bankInformation);
		
	}

}
