package Repository.Account.AccountProfileDAO;

import Domain.Account.AccountProfile.Contact.ContactInfo;
import Domain.Account.AccountProfile.Contact.Location;

public interface ContactDAO {
    boolean createAccountContactProfile(String email, String fullName, Location location, String dateOfBirth, String securityQuestion, String securityQuestionAnswer);

    //boolean updateAddress(String streetAddress, String state, String city, int zipcode, String country, int pobox);

    String getActualAnswer(String email, String securityQuestion);

    ContactInfo getContactInfo(String email);

    void createBasicContact(String email);

	boolean updateLocation(String email, Location location);

	boolean updateNameAndBirth(String email, String fullName, String birthDate);

	boolean updatePhone(String email, String cellPhone);

	boolean createLocation(String email, Location location);
}
