package Service.Resource.Account;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import Service.Representation.Account.Representation.AccountRepresentation;
import Service.Representation.Account.Representation.AccountValidationRepresentation;
import Service.Representation.Account.Representation.AccountValidationRepresentationImpl;
import Service.Representation.Account.Request.AccountRequest;
import Service.Representation.Account.Request.BasicAccountRequest;
import Service.Representation.Account.Request.BasicEmailAccountRequest;
import Service.Workflow.Account.AccountActivity;
import Service.Workflow.Account.AccountActivityImpl;

@Path("/account/")
public class AccountResource implements AccountService{

	@POST
	@Produces({"application/xml", "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/")
	@Override
	public AccountValidationRepresentation registerForAccount(@QueryParam("username") String username, @QueryParam("password") String password) {
		// TODO: not to be used yet
		AccountActivity accountActivity = new AccountActivityImpl();
		accountActivity.regsiterCustomerForAccount(username, password);
		return null;
		
	}

	@POST
	@Produces({"application/xml", "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/")
	@Override
	public AccountValidationRepresentation registerForAccountWithEmail(AccountRequest accountRequest) {
		AccountActivity accountActivity = new AccountActivityImpl();
		if(accountRequest.getIsCustomer()) {//if a buyer is registering for an account
		   return accountActivity.registerCustomerForAccountWithEmail(accountRequest);
		}else {
			return accountActivity.registerPartnerForAccountWithEmail(accountRequest.getUsername(), accountRequest.getEmail(), accountRequest.getPassword());
		}
		
	}

	@PUT
	@Produces({"application/xml", "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/login")
	@Override
	public AccountValidationRepresentation loginWithEmail(BasicEmailAccountRequest basicEmailAccountRequest) {
		AccountActivity accountActivity = new AccountActivityImpl();
		return accountActivity.loginWithEmail(basicEmailAccountRequest.getEmail(),basicEmailAccountRequest.getPassword());
		
	}

	@PUT
	@Produces({"application/xml", "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/")
	@Override
	public AccountValidationRepresentation loginWithUsername(BasicAccountRequest basicAccountRequest) {
		// TODO: this doesnt work yet!
		AccountValidationRepresentation avr = new AccountValidationRepresentationImpl();
		AccountActivity accountActivity = new AccountActivityImpl();
		avr.setIsSuccessful(false);
		return avr;//accountActivity.loginWithUsername(basicAccountRequest.getUsername(), basicAccountRequest.getPassword());
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
	@Consumes({"application/xml", "application/json"})
	@Path("/{username}")
	@Override
	public AccountRepresentation getAccount(@PathParam("username")String username) {
		// TODO Auto-generated method stub
		AccountActivity accountActivity = new AccountActivityImpl();
		return accountActivity.getAccount(username);
		
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
