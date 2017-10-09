package Repository.Account.AccountProfileDAO;

import Domain.Account.AccountProfile.Contact.ContactInfo;
import Domain.Account.AccountProfile.Contact.Location;
import Domain.Account.AccountProfile.Contact.LocationImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactDAOImplTest {
    private ContactDAO contactDAO;
    private String email = "test@test.com";
    private String fullName = "test contact profile";
    private Location location = new LocationImpl("test address", "chicago",89,"il","america",90);
    private String dateOfBirth = "09090909";
    private String securityQuestion = "test question";
    private String securityQuetsionAnswer = "test answer";

    @BeforeEach
    public void setUp(){
        contactDAO = new ContactDAOImpl();
    }
    @Test
    void createAccountContactProfile() {
        contactDAO.createAccountContactProfile(email,fullName,location,dateOfBirth,securityQuestion,securityQuetsionAnswer);
    }

    @Test
    void updateAddress() {

        //Already tested
    }

    @Test
    void getActualAnswer() {
        String answer = contactDAO.getActualAnswer(email,securityQuestion);
        assertEquals(answer,securityQuetsionAnswer);
    }

    @Test
    void getContactInfo() {
        ContactInfo contactInfo = contactDAO.getContactInfo(email);
        assertEquals(contactInfo.getEmail(),email);
        assertEquals(contactInfo.getBirthDate(),dateOfBirth);
        assertEquals(contactInfo.getFullName(),fullName);
        assertEquals(contactInfo.getLocation(),location);
        assertEquals(contactInfo.getSecurityQuestion(),securityQuestion);
        assertEquals(contactInfo.getSecurityQuestionAnswer(),securityQuetsionAnswer);
    }

}