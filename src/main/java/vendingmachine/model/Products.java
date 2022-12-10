package vendingmachine.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import vendingmachine.message.ErrorMessage;

public class Products {
    private static final String PRODUCT_PATTERN = "^\\[.*]$";
    private static final String PRODUCT_DELIMITER = ";";
    private final List<Product> products;

    public Products(String productsInput) {
        validateProductsString(productsInput);
        this.products = convertStringToList(productsInput);
        validateDuplicateName(products);
    }

    public void validateProductsString(String input) {
        String[] productInputs = input.split(PRODUCT_DELIMITER);
        Pattern pattern = Pattern.compile(PRODUCT_PATTERN);
        for (String productInput : productInputs) {
            Matcher matcher = pattern.matcher(productInput);
            if (!matcher.find()) {
                throw new IllegalArgumentException(ErrorMessage.PRODUCT_LIST_EXCEPTION);
            }
        }
    }

    public void validateDuplicateName(List<Product> products) {
        Set<String> names = products.stream()
                .map(Product::getName)
                .collect(Collectors.toSet());
        if (products.size() != names.size()) {
            throw new IllegalArgumentException(ErrorMessage.PRODUCT_LIST_EXCEPTION);
        }
    }

    public List<Product> convertStringToList(String input) {
        List<Product> products = new ArrayList<>();
        String[] productInputs = input.split(PRODUCT_DELIMITER);
        for (String productInput : productInputs) {
            products.add(new Product(productInput));
        }
        return products;
    }

    public boolean doesProductExists(String name) {
        return products.stream()
                .map(Product::getName)
                .collect(Collectors.toList())
                .contains(name);
    }

    public void canPurchase(String name, int insertedMoney) {
        for (Product product : products) {
            if (product.getName().equals(name) && !product.canPurchase(insertedMoney)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public int buyProduct(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product.buy();
            }
        }
        throw new IllegalArgumentException();
    }

    public boolean cannotPurchaseAnyProduct(int money) {
        return products.stream()
                .noneMatch(product -> product.canPurchase(money));
    }
}
