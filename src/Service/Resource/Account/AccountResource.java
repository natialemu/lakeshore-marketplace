package Service.Resource.Account;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import Service.Representation.Account.BasicAccountRequest;
import Service.Representation.Account.Representation.AccountRepresentation;
import Service.Representation.Account.Request.AccountRequest;
import Service.Workflow.Account.AccountActivity;
import Service.Workflow.Account.AccountActivityImpl;

@Path("/")
public class AccountResource implements AccountService{

	@POST
	@Produces({"application/xml", "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/account")
	@Override
	public void registerForAccount(@QueryParam("username") String username, @QueryParam("password") String password) {
		// TODO Auto-generated method stub
		AccountActivity accountActivity = new AccountActivityImpl();
		accountActivity.regsiterCustomerForAccount(username, password);
		
	}

	@POST
	@Consumes({"application/xml", "application/json"})
	@Path("/account")
	@Override
	public void registerForAccountWithEmail(AccountRequest accountRequest) {
		// TODO Auto-generated method stub
		AccountActivity accountActivity = new AccountActivityImpl();
		if(accountRequest.getIsCustomer()) {//if a buyer is registering for an account
		   accountActivity.registerCustomerForAccountWithEmail(accountRequest);
		}else {
			accountActivity.registerPartnerForAccountWithEmail(accountRequest.getUsername(), accountRequest.getEmail(), accountRequest.getPassword());
		}
		
	}

	@PUT
	@Produces({"application/xml", "application/json"})
	@Path("/account")
	@Override
	public boolean loginWithEmail(@QueryParam("username") String email, @QueryParam("password")String password) {
		// TODO Auto-generated method stub
		AccountActivity accountActivity = new AccountActivityImpl();
		return accountActivity.loginWithEmail(email,password);
		
	}

	@PUT
	@Produces({"application/xml", "application/json"})
	@Consumes({"application/xml", "application/json"})
	@Path("/account")
	@Override
	public boolean loginWithUsername(BasicAccountRequest basicAccountRequest) {
		// TODO Auto-generated method stub
		AccountActivity accountActivity = new AccountActivityImpl();
		return accountActivity.loginWithUsername(basicAccountRequest.getUsername(), basicAccountRequest.getPassword());
	}

	@PUT
	@Produces({"application/xml", "application/json"})
	@Path("/account/username")
	@Override
	public void updateUsername(@QueryParam("username")String oldUsername, @QueryParam("new-username")String newUnsername) {
		// TODO Auto-generated method stub
		AccountActivity accountActivity = new AccountActivityImpl();
		accountActivity.updateUsername(oldUsername,newUnsername);
		
	}

	@PUT
	@Produces({"application/xml", "application/json"})
	@Path("/account/password")
	@Override
	public void updatePassword(String username,String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		AccountActivity accountActivity = new AccountActivityImpl();
		accountActivity.updatePassword(username,oldPassword,newPassword);
		
	}

	@PUT
	@Produces({"application/xml", "application/json"})
	@Path("/account")
	@Override
	public void updateAccount(@QueryParam("username")String oldUsername,@QueryParam("new-username") String newUsername, @QueryParam("password")String oldPassowrd, @QueryParam("new-password")String newPassword) {
		// TODO Auto-generated method stub
		AccountActivity accountActivity = new AccountActivityImpl();
		accountActivity.updateAccount(oldUsername, newUsername,oldPassowrd,newPassword);
		
		
	}

//	@POST
//	@Produces({"application/xml", "application/json"})
//	@Consumes({"application/xml", "application/json"})
//	@Path("/account")
//	@Override
//	public AccountRepresentation getAccount(String username, String password) {
//		// TODO Auto-generated method stub
//		AccountActivity accountActivity = new AccountActivityImpl();
//		return accountActivity.getAccount(username, password);
//		
//	}

	@DELETE
	@Produces({"application/xml", "application/json"})
	@Path("/account")
	@Override
	public void deleteAccount(String username, String passowrd) {
		// TODO Auto-generated method stub
		AccountActivity accountActivity = new AccountActivityImpl();
		accountActivity.deleteAccount(username,passowrd);
		
	}



	
}
