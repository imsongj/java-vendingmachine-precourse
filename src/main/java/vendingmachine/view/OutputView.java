package vendingmachine.view;

import java.util.Map.Entry;

import vendingmachine.model.Coin;
import vendingmachine.model.Coins;
import vendingmachine.model.Money;

public class OutputView {

    private static final String COINS_HEADER = "\n자판기가 보유한 동전";
    private static final String COIN_FORMAT = "%d원 - %d개%n";

    private static final String MONEY_FORMAT = "%n투입 금액: %d원%n";

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public void printInsertMoney(Money money) {
        System.out.printf(MONEY_FORMAT, money.getAmount());
    }

    public void printAllCoins(Coins coins) {
        System.out.println(COINS_HEADER);
        for (Entry<Coin, Integer> entry : coins.getCoins().entrySet()) {
            printCoin(entry.getKey(), entry.getValue());
        }
    }

    public void printCoin(Coin coin, int count) {
        System.out.printf(COIN_FORMAT, coin.getAmount(), count);
    }
}
