package vendingmachine.model;

import vendingmachine.message.ErrorMessage;

public class Product {
    private static final int MINIMUM_PRICE = 100;
    private static final int PRICE_MULTIPLIER = 10;
    private static final int EMPTY = 0;
    private static final String VALUE_DELIMITER = ",";
    private static final int VALUE_LENGTH = 3;
    private static final int NAME_INDEX = 0;
    private static final int PRICE_INDEX = 1;
    private static final int UNIT_INDEX = 2;

    private final String name;
    private final int price;
    private int unit;

    public Product(String productInput) {
        validateProductInput(productInput);
        String[] values = convertStringToArray(productInput);

        this.name = values[NAME_INDEX];
        this.price = Integer.parseInt(values[PRICE_INDEX]);
        validatePrice(price);
        this.unit = Integer.parseInt(values[UNIT_INDEX]);
    }

    public void validateProductInput(String productInput) {
        productInput = productInput.substring(1, productInput.length() - 1);
        String[] values = productInput.split(VALUE_DELIMITER);
        if (values.length != VALUE_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.PRODUCT_LIST_EXCEPTION);
        }
        validateInteger(values[PRICE_INDEX]);
        validateInteger(values[UNIT_INDEX]);
    }

    public void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.PRODUCT_LIST_EXCEPTION);
        }
    }

    public static void validatePrice(int price) {
        if (price < MINIMUM_PRICE || price % PRICE_MULTIPLIER != 0) {
            throw new IllegalArgumentException(ErrorMessage.PRODUCT_LIST_EXCEPTION);
        }
    }

    public String[] convertStringToArray(String productInput) {
        productInput = productInput.substring(1, productInput.length() - 1);
        return productInput.split(VALUE_DELIMITER);
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
