package vendingmachine.model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Coins {
    private final Map<Coin, Integer> coins;

    public Coins(int money) {
        this.coins = new CoinGenerator().generateCoins(money);
    }

    public Coins(Map<Coin, Integer> coins) {
        this.coins = coins;
    }

    public Map<Coin, Integer> getCoins() {
        return Collections.unmodifiableMap(coins);
    }

    public Coins getMinimumCoins(int money) {
        Map<Coin, Integer> minimumCoins = new LinkedHashMap<>();
        for (Entry<Coin, Integer> entry : coins.entrySet()) {
            int count = getNumberOfCoins(entry.getKey(), entry.getValue(), money);
            if (count > 0) {
                minimumCoins.put(entry.getKey(), count);
                money -= entry.getKey().getAmount() * count;
            }
        }
        return new Coins(minimumCoins);
    }

    public int getNumberOfCoins(Coin coin, int stock, int money) {
        int count = 0;
        while (coin.getAmount() <= money && stock > 0) {
            count++;
            stock--;
            money -= coin.getAmount();
        }
        return count;
    }
}
