package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

import vendingmachine.message.GameMessage;

public class InputView {
    public String readMachineMoney() {
        OutputView.printMessage(GameMessage.ASK_MACHINE_MONEY);
        return Console.readLine();
    }

    public String readProductList() {
        OutputView.printMessage(GameMessage.ASK_PRODUCTS);
        return Console.readLine();
    }

    public String readInsertMoney() {
        OutputView.printMessage(GameMessage.ASK_INSERT_MONEY);
        return Console.readLine();
    }

    public String readPurchase() {
        return Console.readLine();
    }
}
