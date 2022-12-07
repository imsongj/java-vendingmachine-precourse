package vendingmachine.view.validator;

public class MoneyValidator extends Validator {
    @Override
    public void validateInput(String input) {
        validateNumeric(input);
        validateInteger(input);
    }
}
