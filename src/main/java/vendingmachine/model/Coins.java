package vendingmachine.model;

import java.util.Collections;
import java.util.Map;

public class Coins {
    private final Map<Coin, Integer> coins;

    public Coins(int money) {
        this.coins = new CoinGenerator().generateCoins(money);
    }

    public Map<Coin, Integer> getCoins() {
        return Collections.unmodifiableMap(coins);
    }
}
