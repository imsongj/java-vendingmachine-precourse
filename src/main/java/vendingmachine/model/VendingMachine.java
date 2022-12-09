package vendingmachine.model;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    private int initialMoney;
    private Map<Coin, Integer> coins;
    private List<Product> products;
    private int insertedMoney;

    public VendingMachine(int initialMoney) {
        this.initialMoney = initialMoney;
        coins = new CoinGenerator().generateCoins(initialMoney);
    }

    public void initializeProducts(List<Product> products) {
        this.products = products;
    }

    public void insertMoney(int money) {
        this.insertedMoney = money;
    }

    public Map<Coin, Integer> getCoins() {
        return Collections.unmodifiableMap(coins);
    }

    public int getMoney() {
        return insertedMoney;
    }
}
