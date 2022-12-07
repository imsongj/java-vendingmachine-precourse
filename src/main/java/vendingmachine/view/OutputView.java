package vendingmachine.view;

import java.util.Map;

import java.util.Map.Entry;
import vendingmachine.model.Coin;

public class OutputView {
    private static final String ASK_MACHINE_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String COINS_HEADER = "\n자판기가 보유한 동전";
    private static final String COIN_FORMAT = "%d원 - %d개%n";

    public void askMachineMoney() {
        System.out.println(ASK_MACHINE_MONEY);
    }

    public void printAllCoins(Map<Coin, Integer> coins) {
        System.out.println(COINS_HEADER);
        for (Entry<Coin, Integer> entry : coins.entrySet()) {
            printCoin(entry.getKey(), entry.getValue());
        }
    }

    public void printCoin(Coin coin, int count) {
        System.out.printf(COIN_FORMAT, coin.getAmount(), count);
    }
}
