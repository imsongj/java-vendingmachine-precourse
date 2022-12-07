package vendingmachine.view.validator;

import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import vendingmachine.model.Product;
import vendingmachine.view.StringUtility;

public class ProductValidator extends Validator {
    private static final String PRODUCT_PATTERN = "^\\[.*]$";
    private static final String PRODUCT_DELIMITER = ";";
    private static final String VALUE_DELIMITER = ",";
    private static final int VALUE_LENGTH = 3;
    private static final int PRICE_INDEX = 1;
    private static final int UNIT_INDEX = 2;

    @Override
    public void validateInput(String input) {
        validateProductString(input);
        validateDuplicateName(StringUtility.convertInputToProductList(input));
    }

    public void validateProductString(String input) {
        String[] productInputs = input.split(PRODUCT_DELIMITER);
        Pattern pattern = Pattern.compile(PRODUCT_PATTERN);
        for (String productInput : productInputs) {
            Matcher matcher = pattern.matcher(productInput);
            if (!matcher.find()) {
                throw new IllegalArgumentException();
            }
            validateProductValues(productInput);
        }
    }

    public void validateProductValues(String productInput) {
        productInput = productInput.substring(1, productInput.length() - 1);
        String[] values = productInput.split(VALUE_DELIMITER);
        if (values.length != VALUE_LENGTH) {
            throw new IllegalArgumentException();
        }
        validateInteger(values[PRICE_INDEX]);
        validateInteger(values[UNIT_INDEX]);
    }

    public void validateDuplicateName(List<Product> products) {
        Set<String> names = products.stream()
                .map(Product::getName)
                .collect(Collectors.toSet());
        if (products.size() != names.size()) {
            throw new IllegalArgumentException();
        }
    }
}
