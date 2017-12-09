package Service.Resource.Account;

import javax.jws.WebService;

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
@WebService
public interface AccountService {
	
	//AccountValidationRepresentation registerForAccount(String username, String password);
	AccountValidationRepresentationImpl registerForAccountWithEmail(AccountRequestImpl accountRequest);

	AccountValidationRepresentationImpl loginWithEmail(BasicEmailAccountRequestImpl basicEmailAccountRequest);
	AccountValidationRepresentationImpl loginWithUsername(BasicAccountRequestImpl basicAccountRequest);
	
	
	void updateUsername(String oldUsername, String newUnsername);
	void updatePassword(String username, String oldPassword, String newPassword);
	void updateAccount(String oldUsername, String newUsername, String oldPassowrd, String newPassword);
	
	AccountRepresentationImpl getAccount(String username);
	
	void deleteAccount(String username);
	AccountValidationRepresentation loginPartnerWithEmail(BasicEmailAccountRequestImpl basicEmailAccountRequest);
	
	

}
