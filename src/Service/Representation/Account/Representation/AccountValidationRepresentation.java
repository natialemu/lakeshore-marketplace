package Service.Representation.Account.Representation;

import Service.Representation.AbstractRepresentationInterface;

public interface AccountValidationRepresentation extends AbstractRepresentationInterface {
	void setIsSuccessful(boolean isSuccessful);
	boolean getIsSuccessful();

}
