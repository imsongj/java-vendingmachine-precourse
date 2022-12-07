package vendingmachine.view.validator;

import java.util.regex.Pattern;

public class Validator {
    private static final String NUMERIC_PATTERN = "^[0-9]*$";

    public void validateInput(String input){}

    public void validateNumeric(String input) {
        if (input == null || !Pattern.matches(NUMERIC_PATTERN, input)) {
            throw new IllegalArgumentException();
        }
    }

    public void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }
}
