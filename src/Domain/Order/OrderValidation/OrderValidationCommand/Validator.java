package Domain.Order.OrderValidation.OrderValidationCommand;

public interface Validator {
    ValidationCommand getValidationCommand();
    void setValidationCommand(ValidationCommand validationCommand);

    boolean executeCommand();
}
