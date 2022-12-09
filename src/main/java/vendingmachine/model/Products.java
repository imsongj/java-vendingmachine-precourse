package vendingmachine.model;

import java.util.List;
import java.util.stream.Collectors;

public class Products {
    private final List<Product> products;

    public Products(List<Product> products) {
        this.products = products;
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
