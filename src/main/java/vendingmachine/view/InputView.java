package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import vendingmachine.message.GameMessage;
import vendingmachine.model.Product;
import vendingmachine.view.validator.MoneyValidator;
import vendingmachine.view.validator.ProductValidator;
import vendingmachine.view.validator.Validator;

public class InputView {
    private static final String MACHINE_MONEY_EXCEPTION = "[ERROR] 금액은 정수여야 합니다.";
    private static final String PRODUCT_LIST_EXCEPTION = "[ERROR] 올바른 상품 정보를 입력해야 합니다.";

    public String readMachineMoney() {
        OutputView.printMessage(GameMessage.ASK_MACHINE_MONEY);
        return Console.readLine();
    }

    public List<Product> readProductList() {
        try {
            String input = Console.readLine();
            new ProductValidator().validateInput(input);
            return StringUtility.convertInputToProductList(input);
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            System.out.println(PRODUCT_LIST_EXCEPTION);
            return readProductList();
        }
    }

    public int readInsertMoney() {
        String input;
        do {
            input = Console.readLine();
        } while (isInputInvalid(input, new MoneyValidator(), MACHINE_MONEY_EXCEPTION));
        return Integer.parseInt(input);
    }

    public String readPurchase() {
        return Console.readLine();
    }

    public boolean isInputInvalid(String input, Validator validator, String errorMessage) {
        try {
            validator.validateInput(input);
            return false;
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            System.out.println(errorMessage);
            return true;
        }
    }
}
