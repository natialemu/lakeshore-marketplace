package Service.Resource.Account;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import Service.Representation.Account.AccountRepresentation;

@Path("/")
public class AccountResource implements AccountService{

	@POST
	@Produces({"application/xml", "application/json"})
	@Path("/account")
	@Override
	public void registerAccount(@QueryParam("username") String username, @QueryParam("password") String password) {
		// TODO Auto-generated method stub
		
	}

	@POST
	@Produces({"application/xml", "application/json"})
	@Path("/account")
	@Override
	public void registerAccount(@QueryParam("username") String username, @QueryParam("email") String email, @QueryParam("password") String password) {
		// TODO Auto-generated method stub
		
	}

	@PUT
	@Produces({"application/xml", "application/json"})
	@Path("/account")
	@Override
	public boolean loginWithEmail(@QueryParam("username") String email, @QueryParam("password")String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@PUT
	@Produces({"application/xml", "application/json"})
	@Path("/account")
	@Override
	public boolean loginWithUsername(@QueryParam("username")String username, @QueryParam("password")String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@PUT
	@Produces({"application/xml", "application/json"})
	@Path("/account/username")
	@Override
	public void updateUsername(@QueryParam("username")String oldUsername, @QueryParam("new-username")String newUnsername) {
		// TODO Auto-generated method stub
		
	}

	@PUT
	@Produces({"application/xml", "application/json"})
	@Path("/account/password")
	@Override
	public void updatePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@PUT
	@Produces({"application/xml", "application/json"})
	@Path("/account")
	@Override
	public void updateAccount(@QueryParam("username")String oldUsername,@QueryParam("new-username") String newUsername, @QueryParam("password")String oldPassowrd, @QueryParam("new-password")String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@GET
	@Produces({"application/xml", "application/json"})
	@Path("/account")
	@Override
	public AccountRepresentation getAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	@DELETE
	@Produces({"application/xml", "application/json"})
	@Path("/account")
	@Override
	public void deleteAccount(String username, String passowrd) {
		// TODO Auto-generated method stub
		
	}

	
}
