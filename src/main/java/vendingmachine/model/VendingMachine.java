package vendingmachine.model;

public class VendingMachine {
    private final Money machineMoney;
    private final Coins coins;
    private Products products;
    private Money insertedMoney;

    public VendingMachine(Money machineMoney) {
        this.machineMoney = machineMoney;
        coins = new Coins(machineMoney.getAmount());
    }

    public void initializeProducts(Products products) {
        this.products = products;
    }

    public void insertMoney(Money insertedMoney) {
        this.insertedMoney = insertedMoney;
    }

    public Coins getCoins() {
        return coins;
    }

    public Money getInsertedMoney() {
        return insertedMoney;
    }

    public void isValidPurchase(String productName) {
        if(!products.doesProductExists(productName)) {
            throw new IllegalArgumentException();
        }
        products.canPurchase(productName, insertedMoney.getAmount());
    }

    public void buyProduct(String productName) {
        insertedMoney.spend(products.buyProduct(productName));
    }

    public boolean isOpen() {
        return !products.cannotPurchaseAnyProduct(insertedMoney.getAmount());
    }

}
