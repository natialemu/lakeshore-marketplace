package Service.Resource.Account;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import Service.Representation.Account.BankInfoRepresentation;
import Service.Representation.Account.BankInfoRequest;

@Path("/")
public class BankInfoResource implements BankInfoService{
	
	

	@PUT
	@Consumes("")
	@Override
	public void updateBankName(String bankAccountNumber, String newBankName) {
		// TODO Auto-generated method stub
		
	}

	@PUT
	@Consumes("")
	@Path("")
	@Override
	public void updateAccountNumber(String oldAccountNumber, String newAccountNumber) {
		// TODO Auto-generated method stub
		
	}

	@PUT
	@Consumes("")
	@Path("")
	@Override
	public void updateRoutingNumber(String accountNumber, String newRoutingNumber) {
		// TODO Auto-generated method stub
		
	}

	@PUT
	@Consumes("")
	@Path("")
	@Override
	public void updateSwiftCode(String accountNumber, int newSwiftCode) {
		// TODO Auto-generated method stub
		
	}

	@PUT
	@Consumes("")
	@Path("")
	@Override
	public void updateAccountType(String accountNumber, String newAccountType) {
		// TODO Auto-generated method stub
		
	}

	@PUT
	@Consumes("")
	@Path("")
	@Override
	public void updateCardNumber(String cardNumber, String newPaymentCard) {
		// TODO Auto-generated method stub
		
	}

	@PUT
	@Consumes("")
	@Path("")
	@Override
	public void updateCardExpirationDate(String cardNumber, String newDate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateNameOnCard(String cardNumber, String newNameOncard) {
		// TODO Auto-generated method stub
		
	}

	@PUT
	@Consumes("")
	@Path("")
	@Override
	public void updateSecurityCode(String cardNumber, String newSecurityCode) {
		// TODO Auto-generated method stub
		
	}

	@GET
	@Consumes("")
	@Produces("")
	@Path("")
	@Override
	public BankInfoRepresentation getBankInfo(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@DELETE
	@Consumes("")
	@Path("")
	@Override
	public void deleteBankName(String bankAccountNumber) {
		// TODO Auto-generated method stub
		
	}

	@DELETE
	@Consumes("")
	@Path("")
	@Override
	public void deleteAccountNumber(String accountNumber) {
		// TODO Auto-generated method stub
		
	}

	@DELETE
	@Consumes("")
	@Path("")
	@Override
	public void deleteRoutingNumber(String accountNumber) {
		// TODO Auto-generated method stub
		
	}

	@DELETE
	@Consumes("")
	@Path("")
	@Override
	public void deleteSwiftCode(String accountNumber) {
		// TODO Auto-generated method stub
		
	}

	@DELETE
	@Consumes("")
	@Path("")
	@Override
	public void deleteAccountType(String accountNumber) {
		// TODO Auto-generated method stub
		
	}

	@DELETE
	@Consumes("")
	@Path("")
	@Override
	public void deleteCardNumber(String cardNumber) {
		// TODO Auto-generated method stub
		
	}

	@DELETE
	@Consumes("")
	@Path("")
	@Override
	public void deleteCardExpirationDate(String cardNumber) {
		// TODO Auto-generated method stub
		
	}

	@DELETE
	@Consumes("")
	@Path("")
	@Override
	public void deleteNameOnCard(String cardNumber) {
		// TODO Auto-generated method stub
		
	}

	@DELETE
	@Consumes("")
	@Path("")
	@Override
	public void deleteSecurityCode(String cardNumber) {
		// TODO Auto-generated method stub
		
	}

	@POST
	@Consumes("")
	@Produces("")
	@Path("")
	@Override
	public void createBankInformation(BankInfoRequest bankInformation) {
		// TODO Auto-generated method stub
		
	}

}
