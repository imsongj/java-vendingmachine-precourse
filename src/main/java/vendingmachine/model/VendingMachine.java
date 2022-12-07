package vendingmachine.model;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class VendingMachine {
    private int initialMoney;
    private LinkedHashMap<Coin, Integer> coins;

    public VendingMachine(int initialMoney) {
        this.initialMoney = initialMoney;
        coins = new CoinGenerator().generateCoins(initialMoney);
    }


}
