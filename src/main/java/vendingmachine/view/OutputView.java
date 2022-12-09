package vendingmachine.view;

import java.util.Map;

import java.util.Map.Entry;
import vendingmachine.model.Coin;

public class OutputView {
    private static final String ASK_MACHINE_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String COINS_HEADER = "\n자판기가 보유한 동전";
    private static final String COIN_FORMAT = "%d원 - %d개%n";
    private static final String ASK_PRODUCTS = "\n상품명과 가격, 수량을 입력해 주세요.";
    private static final String ASK_INSERT_MONEY = "\n투입 금액을 입력해 주세요.";
    private static final String MONEY_FORMAT = "투입 금액: %d원%n";
    private static final String ASK_Purchase = "구매할 상품명을 입력해 주세요.";

    public void askMachineMoney() {
        System.out.println(ASK_MACHINE_MONEY);
    }

    public void askProducts() {
        System.out.println(ASK_PRODUCTS);
    }

    public void askInsertMoney() {
        System.out.println(ASK_INSERT_MONEY);
    }

    public void askPurchase() {
        System.out.println(ASK_Purchase);
    }

    public void printInsertMoney(int money) {
        System.out.printf(MONEY_FORMAT, money);
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
