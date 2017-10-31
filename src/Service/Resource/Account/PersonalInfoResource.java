package Service.Resource.Account;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import Service.Representation.Account.PersonalInformationRepresentation;
import Service.Representation.Account.PersonalInformationRequest;

@Path("/")
public class PersonalInfoResource implements PersonalInfoService {

	@PUT
	@Consumes({"application/xml","application/json"})
	@Path("/personal-information")
	@Override
	public void updateEmail(String oldEmail, String newEmail) {
		// TODO Auto-generated method stub
		
		
	}

	@PUT
	@Consumes({"application/xml","application/json"})
	@Path("/personal-information")
	@Override
	public void updateFullName(String email, String newFullName) {
		// TODO Auto-generated method stub
		
	}

	@PUT
	@Consumes({"application/xml","application/json"})
	@Path("/personal-information")
	@Override
	public void updateBirthDate(String email, String birthDate) {
		// TODO Auto-generated method stub
		
	}

	@PUT
	@Consumes({"application/xml","application/json"})
	@Path("/personal-information")
	@Override
	public void updateLocation(String email, int zipcode, String streetAddress, String city, String country,
			String state) {
		// TODO Auto-generated method stub
		
	}

	@PUT
	@Consumes({"application/xml","application/json"})
	@Path("/personal-information")
	@Override
	public void updatePhone(String email, int areacode, int countrycode, int phoneNumber, int phoneType) {
		// TODO Auto-generated method stub
		
	}

	@PUT
	@Consumes({"application/xml","application/json"})
	@Path("/personal-information")
	@Override
	public void updateSecurityQuestion(String email, String newSecurityQuestion) {
		// TODO Auto-generated method stub
		
	}

	@PUT
	@Consumes({"application/xml","application/json"})
	@Path("/personal-information")
	@Override
	public void updateSecurityAnswer(String email, String newSecurityQuestionAnswer) {
		// TODO Auto-generated method stub
		
	}

	@GET
	@Produces({"application/xml","application/json"})
	@Path("/personal-information")
	@Override
	public PersonalInformationRepresentation getPersonalInformation() {
		// TODO Auto-generated method stub
		return null;
	}

	@DELETE
	@Produces({"application/xml","application/json"})
	@Path("/personal-information")
	@Override
	public void removeEmail(String newEmail) {
		// TODO Auto-generated method stub
		
	}

	@DELETE
	@Produces({"application/xml","application/json"})
	@Path("/personal-information")
	@Override
	public void removeFullName(String email, String FullName) {
		// TODO Auto-generated method stub
		
	}

	@DELETE
	@Produces({"application/xml","application/json"})
	@Path("/personal-information")
	@Override
	public void removeBirthDate(String email, String birthDate) {
		// TODO Auto-generated method stub
		
	}

	@DELETE
	@Produces({"application/xml","application/json"})
	@Path("/personal-information")
	@Override
	public void removeLocation(String email, int zipcode, String streetAddress, String city, String country,
			String state) {
		// TODO Auto-generated method stub
		
	}

	@DELETE
	@Produces({"application/xml","application/json"})
	@Path("/personal-information")
	@Override
	public void removePhone(String email, int areacode, int countrycode, int phoneNumber, int phoneType) {
		// TODO Auto-generated method stub
		
	}

	@DELETE
	@Produces({"application/xml","application/json"})
	@Path("/personal-information")
	@Override
	public void removesecurityQuestion(String email, String newSecurityQuestion) {
		// TODO Auto-generated method stub
		
	}

	@DELETE
	@Produces({"application/xml","application/json"})
	@Path("/personal-information")
	@Override
	public void removesecurityAnswer(String email, String newSecurityQuestionAnswer) {
		// TODO Auto-generated method stub
		
	}

	@POST
	@Produces({"application/xml","application/json"})
	@Path("/personal-information")
	@Override
	public void createPersonalInformation(PersonalInformationRequest personalInformation) {
		// TODO Auto-generated method stub
		
	}

}
