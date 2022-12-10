package vendingmachine.model;

import java.util.List;

public class VendingMachine {
    private final Money machineMoney;
    private final Coins coins;
    private Products products;
    private int insertedMoney;

    public VendingMachine(Money machineMoney) {
        this.machineMoney = machineMoney;
        coins = new Coins(machineMoney.getAmount());
    }

    public void initializeProducts(List<Product> products) {
        this.products = new Products(products);
    }

    public void insertMoney(int money) {
        this.insertedMoney = money;
    }

    public Coins getCoins() {
        return coins;
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
