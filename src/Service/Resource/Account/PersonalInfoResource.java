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
import Service.Representation.Account.Representation.PersonalInformationRepresentation;
import Service.Representation.Account.Representation.PersonalInformationRepresentationImpl;
import Service.Representation.Account.Request.BasicAccountRequest;
import Service.Representation.Account.Request.PersonalInformationRequest;
import Service.Representation.Account.Request.PersonalInformationRequestImpl;
import Service.Workflow.Account.PersonalInfoActivity;
import Service.Workflow.Account.PersonalInfoActivityImpl;


@CrossOriginResourceSharing(
        allowOrigins = {"http://localhost:63342"}, 
        allowCredentials = true,
        		allowHeaders = {
        				
                    "'Accept': 'application/json'",
                    "'Content-Type': 'application/json'"
                
        		        }
        		   
        
)
@Path("/profile/")
public class PersonalInfoResource implements PersonalInfoService {

	@Context
	private HttpHeaders headers;
	
	@OPTIONS
    @Path("/")
    @LocalPreflight
    public Response options() {
        String origin = headers.getRequestHeader("Origin").get(0);
        
        if("http://localhost:63342".equals(origin)) {return Response.ok()
                           .header(CorsHeaderConstants.HEADER_AC_ALLOW_METHODS, "POST, PUT, GET, DELETE")
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
                           .header(CorsHeaderConstants.HEADER_AC_ALLOW_METHODS, "POST, PUT, GET, DELETE")
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
	public void updateEmail(@QueryParam("old_email")String oldEmail,@QueryParam("new_email") String newEmail) {
		PersonalInfoActivity personalInfoActivity = new PersonalInfoActivityImpl();
		personalInfoActivity.updateEmail(oldEmail,newEmail);
		
		
	}

	@PUT
	@Consumes({"application/xml","application/json"})
	@Path("/")
	@Override
	public void updateFullName(@QueryParam("email")String email, @QueryParam("newFullName")String newFullName) {
		PersonalInfoActivity personalInfoActivity = new PersonalInfoActivityImpl();
		personalInfoActivity.updateFullName(email,newFullName);
		
		
	}

	@PUT
	@Consumes({"application/xml","application/json"})
	@Path("/")
	@Override
	public void updateBirthDate(@QueryParam("email")String email, @QueryParam("birthDate")String birthDate) {
		PersonalInfoActivity personalInfoActivity = new PersonalInfoActivityImpl();
		personalInfoActivity.updateBirthDate(email,birthDate);
		
	}

	@PUT
	@Consumes({"application/xml","application/json"})
	@Path("/")
	@Override
	public void updateLocation(@QueryParam("email")String email, @QueryParam("zipcode")int zipcode, @QueryParam("streetAddress")String streetAddress, @QueryParam("city")String city, @QueryParam("country")String country,
			@QueryParam("state")String state) {
		PersonalInfoActivity personalInfoActivity = new PersonalInfoActivityImpl();
		personalInfoActivity.updateLocation(email,zipcode,streetAddress,city,country,state);
		
	}

	@PUT
	@Consumes({"application/xml","application/json"})
	@Path("/")
	@Override
	public void updatePhone(@QueryParam("email")String email, @QueryParam("areacode")int areacode, @QueryParam("countrycode")int countrycode, @QueryParam("phoneNumber")int phoneNumber, @QueryParam("phoneType")int phoneType) {
		PersonalInfoActivity personalInfoActivity = new PersonalInfoActivityImpl();
		personalInfoActivity.updatePhone(email,areacode,countrycode,phoneNumber,phoneType);
		
	}

	@PUT
	@Consumes({"application/xml","application/json"})
	@Path("/")
	@Override
	public void updateSecurityQuestion(@QueryParam("email")String email, @QueryParam("newSecurityQuestion")String newSecurityQuestion) {
		PersonalInfoActivity personalInfoActivity = new PersonalInfoActivityImpl();
		personalInfoActivity.updateEmail(email,newSecurityQuestion);
		
	}

	@PUT
	@Consumes({"application/xml","application/json"})
	@Path("/")
	@Override
	public void updateSecurityAnswer(@QueryParam("email")String email, @QueryParam("newSecurityQuestionAnswer")String newSecurityQuestionAnswer) {
		PersonalInfoActivity personalInfoActivity = new PersonalInfoActivityImpl();
		personalInfoActivity.updateEmail(email,newSecurityQuestionAnswer);
		
	}

	@GET
	@Produces({"application/xml","application/json"})
	@Path("/{username}")
	@Override
	public PersonalInformationRepresentationImpl getPersonalInformation(@PathParam("username")String username) {
		PersonalInfoActivity personalInfoActivity = new PersonalInfoActivityImpl();
		return (PersonalInformationRepresentationImpl)personalInfoActivity.getPersonalInformation(username);
	}

	@DELETE
	@Produces({"application/xml","application/json"})
	@Path("/")
	@Override
	public void removeEmail(@QueryParam("newEmail")String newEmail) {
		PersonalInfoActivity personalInfoActivity = new PersonalInfoActivityImpl();
		personalInfoActivity.removeEmail(newEmail);
		
	}

	@DELETE
	@Produces({"application/xml","application/json"})
	@Path("/")
	@Override
	public void removeFullName(@QueryParam("email")String email, @QueryParam("FullName")String FullName) {
		PersonalInfoActivity personalInfoActivity = new PersonalInfoActivityImpl();
		personalInfoActivity.removeFullName(email,FullName);
		
	}

	@DELETE
	@Produces({"application/xml","application/json"})
	@Path("/")
	@Override
	public void removeBirthDate(@QueryParam("email")String email, @QueryParam("birthDate")String birthDate) {
		PersonalInfoActivity personalInfoActivity = new PersonalInfoActivityImpl();
		personalInfoActivity.removeBirthDate(email,birthDate);
		
	}

	@DELETE
	@Produces({"application/xml","application/json"})
	@Path("/")
	@Override
	public void removeLocation(@QueryParam("email")String email, @QueryParam("zipcode")int zipcode, @QueryParam("streetAddress")String streetAddress, @QueryParam("city")String city, @QueryParam("country")String country,
			@QueryParam("state")String state) {
		PersonalInfoActivity personalInfoActivity = new PersonalInfoActivityImpl();
		personalInfoActivity.removeLocation(email,zipcode,streetAddress,city,country,state);
		
	}

	@DELETE
	@Produces({"application/xml","application/json"})
	@Path("/")
	@Override
	public void removePhone(@QueryParam("email")String email, @QueryParam("areacode")int areacode, @QueryParam("countrycode")int countrycode, @QueryParam("phoneNumber")int phoneNumber, @QueryParam("phoneType")int phoneType) {
		PersonalInfoActivity personalInfoActivity = new PersonalInfoActivityImpl();
		personalInfoActivity.removePhone(email,areacode,countrycode,phoneNumber,phoneType);
		
	}

	@DELETE
	@Produces({"application/xml","application/json"})
	@Path("/")
	@Override
	public void removesecurityQuestion(@QueryParam("email")String email, @QueryParam("newSecurityQuestion")String newSecurityQuestion) {
		PersonalInfoActivity personalInfoActivity = new PersonalInfoActivityImpl();
		personalInfoActivity.removesecurityQuestion(email,newSecurityQuestion);
		
	}

	@DELETE
	@Produces({"application/xml","application/json"})
	@Path("/")
	@Override
	public void removesecurityAnswer(@QueryParam("email")String email, @QueryParam("newSecurityQuestionAnswer")String newSecurityQuestionAnswer) {
		PersonalInfoActivity personalInfoActivity = new PersonalInfoActivityImpl();
		personalInfoActivity.removesecurityAnswer(email,newSecurityQuestionAnswer);
		
	}

	@POST
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	@Path("/{username}")
	@Override
	public AccountValidationRepresentationImpl createPersonalInformation(@PathParam("username") String username, PersonalInformationRequestImpl personalInformation) {
		PersonalInfoActivity personalInfoActivity = new PersonalInfoActivityImpl();
		return personalInfoActivity.createPersonalInformation(username, personalInformation); 
		
	}

	@PUT
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	@Path("/{username}")
	@Override
	public AccountValidationRepresentationImpl updatePersonalInformation(@PathParam("username") String username,
			PersonalInformationRequestImpl personalInformation) {
		PersonalInfoActivity personalInfoActivity = new PersonalInfoActivityImpl();
		return personalInfoActivity.updatePersonalInformation(username, personalInformation); 
	}

}
