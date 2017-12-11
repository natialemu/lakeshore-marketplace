package Service.Workflow.Account;

import java.util.ArrayList;
import java.util.List;

import Domain.Account.AccountFactory;
import Domain.Account.AccountFactoryImpl;
import Domain.Account.AccountProfile.Contact.Location;
import Domain.Account.AccountProfile.Contact.LocationImpl;
import Domain.Account.AccountProfile.Finance.FinancialInfo;
import Service.Common.MediaTypes;
import Service.Common.URIs;
import Service.Representation.Link;
import Service.Representation.LinkImpl;
import Service.Representation.Account.Representation.AccountValidationRepresentation;
import Service.Representation.Account.Representation.AccountValidationRepresentationImpl;
import Service.Representation.Account.Representation.BankInfoRepresentation;
import Service.Representation.Account.Representation.BankInfoRepresentationImpl;
import Service.Representation.Account.Request.BankInfoRequest;
import Service.Representation.Account.Request.BankInfoRequestImpl;
import Service.Representation.Account.Request.BasicAccountRequest;
import Service.Representation.Account.Request.BasicBankInfoRequestImpl;
import Service.Representation.Account.Request.PaymentCardRequestImpl;

public class BankInfoActivityImpl implements BankInfoActivity{
	private AccountFactory accountFactory;
	
	public BankInfoActivityImpl() {
		accountFactory = new AccountFactoryImpl();
	}

	@Override
	public void updateBankName(String bankAccountNumber, String newBankName) {
		// TODO Auto-generated method stub
		accountFactory.updateBankName(bankAccountNumber, newBankName);
		
	}

	@Override
	public void updateAccountNumber(String oldAccountNumber, String newAccountNumber) {
		// TODO Auto-generated method stub
		accountFactory.updateAccountNumber(oldAccountNumber,newAccountNumber);
		
	}

	@Override
	public void updateRoutingNumber(String accountNumber, String newRoutingNumber) {
		// TODO Auto-generated method stub
		accountFactory.updateRoutingNumber(accountNumber,newRoutingNumber);
		
	}

	@Override
	public void updateSwiftCode(String accountNumber, int newSwiftCode) {
		// TODO Auto-generated method stub
		accountFactory.updateSwiftCode(accountNumber,newSwiftCode);
		
	}

	@Override
	public void updateAccountType(String accountNumber, String newAccountType) {
		accountFactory.updateAccountType(accountNumber,newAccountType);

		
	}

	@Override
	public void updateCardNumber(String cardNumber, String newPaymentCard) {
		// TODO Auto-generated method stub
		accountFactory.updateCardNumber(cardNumber,newPaymentCard);
	}

	@Override
	public void updateCardExpirationDate(String cardNumber, String newDate) {
		// TODO Auto-generated method stub
		accountFactory.updateCardExpirationDate(cardNumber,newDate);
	}

	@Override
	public void updateNameOnCard(String cardNumber, String newNameOncard) {
		// TODO Auto-generated method stub
		accountFactory.updateNameOnCard(cardNumber,newNameOncard);
	}

	@Override
	public void updateSecurityCode(String cardNumber, String newSecurityCode) {
		// TODO Auto-generated method stub
		accountFactory.updateSecurityCode(cardNumber,newSecurityCode);
	}

	@Override
	public BankInfoRepresentationImpl getBankInfo(String username) {
		// TODO Auto-generated method stub
		
		 FinancialInfo finInfo = accountFactory.getAccount(username).getAccountProfile().getFinancialInfo();
		 BankInfoRepresentationImpl bir = new BankInfoRepresentationImpl();
		 bir.setAccountNumber(finInfo.getBankAccount().getAccountNumber());
		 bir.setAccountType(finInfo.getBankAccount().getAccountType());
		 bir.setBankName(finInfo.getBankAccount().getBankName());
		 bir.setBillingCity(finInfo.getBillingAddress().getCity());
		 bir.setBillingState(finInfo.getBillingAddress().getState());
		 bir.setBillingStreetAddress(finInfo.getBillingAddress().getStreetAddress());
		 bir.setBillingZipcode(Integer.toString(finInfo.getBillingAddress().getZipcode()));
		 bir.setCardExpirationDate(finInfo.getPaymentCard().getCardExpirationDate().toString());
		 bir.setCardNumber(finInfo.getPaymentCard().getCardNumber());
		 bir.setNameOnCard(finInfo.getPaymentCard().getCardHolderName());
		 bir.setCardSecurityCode(Integer.toString(finInfo.getPaymentCard().getCardSecurityNumber()));
		 
		 setLinksAfterBankInfoRetrieval(bir,finInfo);
		 return bir;
		 
		 
	}

	private void setLinksAfterBankInfoRetrieval(BankInfoRepresentationImpl bir, FinancialInfo finInfo) {


		List<LinkImpl> links = new ArrayList<>();
		

		//Link for updating bank info
		
		
		//link for retrieving bank info
		
		
	}

	@Override
	public void deleteBankName(String bankAccountNumber, String bankName) {
		// TODO Auto-generated method stub
		accountFactory.deleteBankName(bankAccountNumber,bankName);
	}

	@Override
	public void deleteAccountNumber(String accountNumber) {
		// TODO Auto-generated method stub
		accountFactory.deleteAccountNumber(accountNumber);
		
	}

	@Override
	public void deleteRoutingNumber(String accountNumber, String routingNumber) {
		// TODO Auto-generated method stub
		accountFactory.deleteRoutingNumber(accountNumber,routingNumber);
		
	}

	@Override
	public void deleteSwiftCode(String accountNumber, String swiftCode) {
		// TODO Auto-generated method stub
		accountFactory.deleteSwiftCode(accountNumber,swiftCode);
		
	}

	@Override
	public void deleteAccountType(String accountNumber, String accountType) {
		// TODO Auto-generated method stub
		accountFactory.deleteAccountType(accountNumber,accountType);

		
	}

	@Override
	public void deleteCardNumber(String cardNumber) {
		// TODO Auto-generated method stub
		accountFactory.deleteCardNumber(cardNumber);

	}

	@Override
	public void deleteCardExpirationDate(String cardNumber, String expirationDate) {
		// TODO Auto-generated method stub
		accountFactory.deleteCardExpirationDate(cardNumber,expirationDate);

		
	}

	@Override
	public void deleteNameOnCard(String cardNumber, String cardName) {
		// TODO Auto-generated method stub
		accountFactory.deleteNameOnCard(cardNumber,cardName);

		
	}

	@Override
	public void deleteSecurityCode(String cardNumber, int securityCode) {
		// TODO Auto-generated method stub
		accountFactory.deleteSecurityCode(cardNumber,securityCode);

		
	}

	@Override
	public AccountValidationRepresentationImpl createBankInformation(String username,BankInfoRequestImpl bankInformation) {
		// TODO Auto-generated method stub
		AccountValidationRepresentationImpl avr = new AccountValidationRepresentationImpl();
		String defaultRoutingNumber = "123456";
		String defaultSwiftCode = "12345"; 
		Location location = new LocationImpl();
		location.setCity(bankInformation.getBillingCity());
		location.setState(bankInformation.getBillingState());
		location.setStreetAddress(bankInformation.getBillingStreetAddress());
		location.setZipcode(Integer.parseInt(bankInformation.getBillingZipcode()));
		
		boolean fin_profile_created = accountFactory.createAccountFinancialProfile(username, bankInformation.getCardNumber(),bankInformation.getAccountNumber(), bankInformation.getBankName(), defaultRoutingNumber, bankInformation.getAccountType(), location, defaultSwiftCode);
		boolean payment_card_created = accountFactory.createPaymentCardProfile(bankInformation.getAccountNumber(), bankInformation.getNameOnCard(), bankInformation.getCardNumber(), bankInformation.getCardExpirationDate(), Integer.parseInt(bankInformation.getCardSecurityCode()));
		
		avr.setIsSuccessful(fin_profile_created && payment_card_created);
		setLinksAfterBankProfile(avr);
		return avr;

	}

	private void setLinksAfterBankProfile(AccountValidationRepresentation avr) {

		List<LinkImpl> links = new ArrayList<>();
		
		//Update personal info
		LinkImpl createBankInfo = new LinkImpl("POST",URIs.BANKINFO,"update bank information",MediaTypes.JSON);
		links.add(createBankInfo);
		
		LinkImpl[] linkArray = new LinkImpl[links.size()];
		avr.setLinks(links.toArray(linkArray));
	}

	@Override
	public AccountValidationRepresentationImpl createBankProfile(String username,
			BasicBankInfoRequestImpl bankInformation) {
		// TODO Auto-generated method stub
		AccountValidationRepresentationImpl avr = new AccountValidationRepresentationImpl();
		if(accountFactory.createBankProfile(username,bankInformation.getAccountNumber(),bankInformation.getAccountType(),bankInformation.getBankName(),bankInformation.getRoutingNumber())) {
			avr.setIsSuccessful(true);
		}else {
			avr.setIsSuccessful(false);
		}
		setLinksAfterBankProfileCreation(avr,username);

		return avr;
	}

	private void setLinksAfterBankProfileCreation(AccountValidationRepresentationImpl avr, String username) {
		List<LinkImpl> links = new ArrayList<>();
		
		//Link for profile creation
		LinkImpl profileCreation = new LinkImpl("POST",URIs.PERSONAL_INFO+"/"+username,"Create a personal profile",MediaTypes.JSON);
		links.add(profileCreation);
		//Link for updating profile
		LinkImpl updateProfile = new LinkImpl("PUT",URIs.PERSONAL_INFO+"/"+username,"Update personal profile",MediaTypes.JSON);
		links.add(updateProfile);
		
		
		//Link for bank profile update
		LinkImpl updateBankProfile = new LinkImpl("PUT",URIs.BANK_PROFILE_URI+"/"+username,"Update bank profile",MediaTypes.JSON);
		links.add(updateBankProfile);
		
		//Link for updating card profile
		LinkImpl updateCardProfile = new LinkImpl("PUT",URIs.PAYMENT_CARD_URI+"/"+username,"Update personal profile",MediaTypes.JSON);
		links.add(updateCardProfile);
		
		//Link for updating card profile
		LinkImpl createCardProfile = new LinkImpl("POST",URIs.PAYMENT_CARD_URI+"/"+username,"Update personal profile",MediaTypes.JSON);
		links.add(createCardProfile);
				
		//link for getting bank info
		LinkImpl bankProfileRetrieval = new LinkImpl("GET",URIs.BANK_PROFILE_URI+"/"+username,"Get account profile information",MediaTypes.JSON);
		links.add(bankProfileRetrieval);
				

		
		
		//link for getting account info
		LinkImpl accountRetrieval = new LinkImpl("GET",URIs.ACCOUNT+"/"+username,"Get account profile information",MediaTypes.JSON);
		links.add(accountRetrieval);
		
		
		LinkImpl[] linkArray = new LinkImpl[links.size()];
		links.toArray(linkArray);
		
		avr.setLinks(linkArray);
		// 
		
	}

	@Override
	public AccountValidationRepresentationImpl createPaymentCardProfile(String username,
			PaymentCardRequestImpl paymentCardInformation) {
		// TODO Auto-generated method stub
		
		AccountValidationRepresentationImpl avr = new AccountValidationRepresentationImpl();
		if(accountFactory.createPaymentCardProfile(username, paymentCardInformation.getNameOnCard(), paymentCardInformation.getCardNumber(), paymentCardInformation.getCardExpirationDate(), Integer.parseInt(paymentCardInformation.getCardSecurityCode()))) {
			avr.setIsSuccessful(true);
		}else {
			avr.setIsSuccessful(false);
		}
		setLinkAfterPaymentCardCreation(avr,username);
		return avr;
	}

	private void setLinkAfterPaymentCardCreation(AccountValidationRepresentationImpl avr, String username) {
		List<LinkImpl> links = new ArrayList<>();
		
		//Link for profile creation
		LinkImpl profileCreation = new LinkImpl("POST",URIs.PERSONAL_INFO+"/"+username,"Create a personal profile",MediaTypes.JSON);
		links.add(profileCreation);
		
		//Link for updating profile
		LinkImpl updateProfile = new LinkImpl("PUT",URIs.PERSONAL_INFO+"/"+username,"Update personal profile",MediaTypes.JSON);
		links.add(updateProfile);
		
		//Link for updating card profile
		LinkImpl updateCardProfile = new LinkImpl("PUT",URIs.PAYMENT_CARD_URI+"/"+username,"Update personal profile",MediaTypes.JSON);
		links.add(updateCardProfile);
		
		
		//Link for bank profile update
		LinkImpl updateBankProfile = new LinkImpl("PUT",URIs.BANK_PROFILE_URI+"/"+username,"Update bank profile",MediaTypes.JSON);
		links.add(updateBankProfile);
		
		//Link for bank profile update
		LinkImpl createBankProfile = new LinkImpl("POST",URIs.BANK_PROFILE_URI+"/"+username,"Update bank profile",MediaTypes.JSON);
		links.add(createBankProfile);

		
		
		//link for getting account info
		LinkImpl accountRetrieval = new LinkImpl("GET",URIs.ACCOUNT+"/"+username,"Get account profile information",MediaTypes.JSON);
		links.add(accountRetrieval);
		
		
		//link for getting payment info
		LinkImpl payemntCardRetrieval = new LinkImpl("GET",URIs.PAYMENT_CARD_URI+"/"+username,"Get account profile information",MediaTypes.JSON);
		links.add(payemntCardRetrieval);
		

		
		
		LinkImpl[] linkArray = new LinkImpl[links.size()];
		links.toArray(linkArray);
		
		avr.setLinks(linkArray);		
	}

	@Override
	public AccountValidationRepresentationImpl updateBankProfile(String username,
			BasicBankInfoRequestImpl bankInformation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountValidationRepresentationImpl updatePaymentCardProfile(String username,
			PaymentCardRequestImpl paymentCardInformation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BasicBankInfoRequestImpl getBankProfile(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaymentCardRequestImpl getPaymentCardProfile(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
