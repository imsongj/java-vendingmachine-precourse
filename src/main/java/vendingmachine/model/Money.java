package vendingmachine.model;

import java.util.regex.Pattern;
import vendingmachine.message.ErrorMessage;

public class Money {
    private static final String NUMERIC_PATTERN = "^[0-9]*$";

    private final int amount;

    public Money(String amountInput) {
        validateNumeric(amountInput);
        validateInteger(amountInput);
        this.amount = convertInputToAmount(amountInput);
    }

    public void validateNumeric(String input) {
        if (input == null || !Pattern.matches(NUMERIC_PATTERN, input)) {
            throw new IllegalArgumentException(ErrorMessage.MACHINE_MONEY_EXCEPTION);
        }
    }

    public void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.MACHINE_MONEY_EXCEPTION);
        }
    }

    public int convertInputToAmount(String input) {
        return Integer.parseInt(input);
    }

    public int getAmount() {
        return amount;
    }
}
