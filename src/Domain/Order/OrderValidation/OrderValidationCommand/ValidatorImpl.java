package Domain.Order.OrderValidation.OrderValidationCommand;

public class ValidatorImpl  implements Validator{
    ValidationCommand validationCommand;

    public ValidatorImpl(ValidationCommand validationCommand){
        this.validationCommand = validationCommand;
    }

    @Override
    public ValidationCommand getValidationCommand() {
        return validationCommand;
    }

    @Override
    public void setValidationCommand(ValidationCommand validationCommand) {
        this.validationCommand = validationCommand;
    }

    @Override
    public boolean executeCommand() {
        return validationCommand.executeCommand();
    }
}
