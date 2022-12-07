package vendingmachine.model;

import java.util.Collections;
import java.util.Map;

public class VendingMachine {
    private int initialMoney;
    private Map<Coin, Integer> coins;

    public VendingMachine(int initialMoney) {
        this.initialMoney = initialMoney;
        coins = new CoinGenerator().generateCoins(initialMoney);
    }

    public Map<Coin, Integer> getCoins() {
        return Collections.unmodifiableMap(coins);
    }

}
