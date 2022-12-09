package vendingmachine.model;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VendingMachine {
    private int initialMoney;
    private Map<Coin, Integer> coins;
    private Products products;
    private int insertedMoney;

    public VendingMachine(int initialMoney) {
        this.initialMoney = initialMoney;
        coins = new CoinGenerator().generateCoins(initialMoney);
    }

    public void initializeProducts(List<Product> products) {
        this.products = new Products(products);
    }

    public void insertMoney(int money) {
        this.insertedMoney = money;
    }

    public boolean isValidPurchase(String name) {
        if(products.doesProductExists(name)) {
            return products.canPurchase(name, insertedMoney);
        }
        return false;
    }

    public Map<Coin, Integer> getCoins() {
        return Collections.unmodifiableMap(coins);
    }

    public int getMoney() {
        return insertedMoney;
    }
}
