package vendingmachine.view;

import java.util.ArrayList;
import java.util.List;
import vendingmachine.model.Product;

public class StringUtility {
    private static final String PRODUCT_DELIMITER = ";";
    private static final String VALUE_DELIMITER = ",";
    private static final int NAME_INDEX = 0;
    private static final int PRICE_INDEX = 1;
    private static final int UNIT_INDEX = 2;

    public static List<Product> convertInputToProductList(String input) {
        List<Product> products = new ArrayList<>();
        String[] productInputs = input.split(PRODUCT_DELIMITER);
        for (String productInput : productInputs) {
            productInput = productInput.substring(1, productInput.length() - 1);
            String[] values = productInput.split(VALUE_DELIMITER);
            products.add(new Product(values[NAME_INDEX],
                    Integer.parseInt(values[PRICE_INDEX]), Integer.parseInt(values[UNIT_INDEX])));
            System.out.println(values[NAME_INDEX]);
        }
        return products;
    }
}
