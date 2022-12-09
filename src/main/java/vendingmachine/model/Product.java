package vendingmachine.model;

public class Product {
    private static final int MINIMUM_PRICE = 100;
    private static final int PRICE_MULTIPLIER = 10;
    private static final int EMPTY = 0;
    private final String name;
    private final int price;
    private int unit;

    public Product(String name, int price, int unit) {
        this.name = name;
        validatePrice(price);
        this.price = price;
        this.unit = unit;
    }

    public static void validatePrice(int price) {
        if (price < MINIMUM_PRICE || price % PRICE_MULTIPLIER != 0) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }

    public boolean canPurchase(int money) {
        return price <= money && !isSoldOut();
    }

    public boolean isSoldOut() {
        return unit == EMPTY;
    }

    public int buy() {
        unit--;
        return price;
    }
}
