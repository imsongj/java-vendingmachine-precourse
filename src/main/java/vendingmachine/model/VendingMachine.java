package vendingmachine.model;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    private final Money machineMoney;
    private final Map<Coin, Integer> coins;
    private Products products;
    private int insertedMoney;

    public VendingMachine(Money machineMoney) {
        this.machineMoney = machineMoney;
        coins = new CoinGenerator().generateCoins(machineMoney.getAmount());
    }

    public void initializeProducts(List<Product> products) {
        this.products = new Products(products);
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

    public void isValidPurchase(String name) {
        if(!products.doesProductExists(name)) {
            throw new IllegalArgumentException();
        }
        products.canPurchase(name, insertedMoney);
    }

    public void buyProduct(String name) {
        insertedMoney -= products.buyProduct(name);
    }

    public boolean isOpen() {
        return !products.cannotPurchaseAnyProduct(insertedMoney);
    }

}
