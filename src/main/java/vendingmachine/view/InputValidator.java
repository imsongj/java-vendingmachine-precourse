package vendingmachine.view;

import java.util.regex.Pattern;

public class InputValidator {
    private static final String PATTERN = "^[0-9]*$";

    public static void validateNumeric(String input) {
        if (input == null || !Pattern.matches(PATTERN, input)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException();
        }
    }

}
