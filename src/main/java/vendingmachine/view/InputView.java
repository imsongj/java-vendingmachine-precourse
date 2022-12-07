package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String MACHINE_MONEY_EXCEPTION = "[ERROR] 금액은 정수여야 합니다.";

    public int readMachineMoney() {
        String input;
        do {
            input = Console.readLine();
        } while (isMachineMoneyInvalid(input));
        return Integer.parseInt(input);
    }

    public boolean isMachineMoneyInvalid(String input) {
        try {
            InputValidator.validateNumeric(input);
            InputValidator.validateInteger(input);
            return false;
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            System.out.println(MACHINE_MONEY_EXCEPTION);
            return true;
        }
    }
}
