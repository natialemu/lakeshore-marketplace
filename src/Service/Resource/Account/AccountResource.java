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

import Service.Representation.Account.Representation.AccountRepresentation;
import Service.Representation.Account.Representation.AccountRepresentationImpl;
import Service.Representation.Account.Representation.AccountValidationRepresentation;
import Service.Representation.Account.Representation.AccountValidationRepresentationImpl;
import Service.Representation.Account.Request.AccountRequest;
import Service.Representation.Account.Request.AccountRequestImpl;
import Service.Representation.Account.Request.BasicAccountRequest;
import Service.Representation.Account.Request.BasicAccountRequestImpl;
import Service.Representation.Account.Request.BasicEmailAccountRequest;
import Service.Representation.Account.Request.BasicEmailAccountRequestImpl;
import Service.Workflow.Account.AccountActivity;
import Service.Workflow.Account.AccountActivityImpl;

@CrossOriginResourceSharing(
        allowOrigins = {"http://localhost:63342"}, 
        allowCredentials = true,
        		allowHeaders = {
        				
                    "'Accept': 'application/json'",
                    "'Content-Type': 'application/json'"
                
        		        }
        		   
        
)
@Path("/")
public class AccountResource implements AccountService{

	@Context
	private HttpHeaders headers;
//	@POST
//	@Produces({"application/xml", "application/json"})
//	@Consumes({"application/xml", "application/json"})
//	@Path("/")
//	@Override
//	public AccountValidationRepresentation registerForAccount(@QueryParam("username") String username, @QueryParam("password") String password) {
//		// TODO: not to be used yet
//		AccountActivity accountActivity = new AccountActivityImpl();
//		accountActivity.regsiterCustomerForAccount(username, password);
//		return null;
//		
//	}
	
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

	
	@POST
	@Consumes({"application/xml", "application/json"})
	@Produces({"application/xml", "application/json"})
	@Path("/")
	@Override
	public AccountValidationRepresentationImpl registerForAccountWithEmail(AccountRequestImpl accountRequest) {
		AccountActivity accountActivity = new AccountActivityImpl();
		if(accountRequest.getIsCustomer()) {//if a buyer is registering for an account
		   return accountActivity.registerCustomerForAccountWithEmail(accountRequest);
		}else {
			return (AccountValidationRepresentationImpl) accountActivity.registerPartnerForAccountWithEmail(accountRequest.getUsername(), accountRequest.getEmail(), accountRequest.getPassword());
		}
		//System.out.println("endpoint reached!");
		//return new AccountValidationRepresentationImpl();
		
	}

	@PUT
	@Produces({"application/xml", "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/login")
	@Override
	public AccountValidationRepresentationImpl loginWithEmail(BasicEmailAccountRequestImpl basicEmailAccountRequest) {
		AccountActivity accountActivity = new AccountActivityImpl();
		return (AccountValidationRepresentationImpl)accountActivity.loginWithEmail(basicEmailAccountRequest.getEmail(),basicEmailAccountRequest.getPassword());
	}
	@PUT
	@Produces({"application/xml", "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/login/partner")
	@Override
	public AccountValidationRepresentationImpl loginPartnerWithEmail(BasicEmailAccountRequestImpl basicEmailAccountRequest) {
		AccountActivity accountActivity = new AccountActivityImpl();
		return (AccountValidationRepresentationImpl)accountActivity.loginPartnerWithEmail(basicEmailAccountRequest.getEmail(),basicEmailAccountRequest.getPassword());
	}

	@PUT
	@Produces({"application/xml", "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/")
	@Override
	public AccountValidationRepresentationImpl loginWithUsername(BasicAccountRequestImpl basicAccountRequest) {
		// TODO: this doesnt work yet!
		AccountValidationRepresentation avr = new AccountValidationRepresentationImpl();
		AccountActivity accountActivity = new AccountActivityImpl();
		avr.setIsSuccessful(false);
		return (AccountValidationRepresentationImpl)avr;//accountActivity.loginWithUsername(basicAccountRequest.getUsername(), basicAccountRequest.getPassword());
	}

	@PUT
	@Produces({"application/xml", "application/json"})
	@Path("/username")
	@Override
	public void updateUsername(@QueryParam("username")String oldUsername, @QueryParam("new-username")String newUnsername) {
		// TODO Auto-generated method stub
		AccountActivity accountActivity = new AccountActivityImpl();
		accountActivity.updateUsername(oldUsername,newUnsername);
		
	}

	@PUT
	@Produces({"application/xml", "application/json"})
	@Path("/password")
	@Override
	public void updatePassword(String username,String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		AccountActivity accountActivity = new AccountActivityImpl();
		accountActivity.updatePassword(username,oldPassword,newPassword);
		
	}

	@PUT
	@Produces({"application/xml", "application/json"})
	@Path("/")
	@Override
	public void updateAccount(@QueryParam("username")String oldUsername,@QueryParam("new-username") String newUsername, @QueryParam("password")String oldPassowrd, @QueryParam("new-password")String newPassword) {
		// TODO Auto-generated method stub
		AccountActivity accountActivity = new AccountActivityImpl();
		accountActivity.updateAccount(oldUsername, newUsername,oldPassowrd,newPassword);
		
		
	}

	@GET
	@Produces({"application/xml", "application/json"})
	@Path("/{username}")
	@Override
	public AccountRepresentationImpl getAccount(@PathParam("username")String username) {
		// TODO Auto-generated method stub
		AccountActivity accountActivity = new AccountActivityImpl();
		return (AccountRepresentationImpl)accountActivity.getAccount(username);
	}

	@DELETE
	@Produces({"application/xml", "application/json"})
	@Path("/{username}")
	@Override
	public void deleteAccount(@PathParam("username")String username) {
		// TODO Auto-generated method stub
		AccountActivity accountActivity = new AccountActivityImpl();
		accountActivity.deleteAccount(username);
		
	}



	
}
