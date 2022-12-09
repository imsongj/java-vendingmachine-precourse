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

    public boolean canPurchase(String name, int insertedMoney) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product.canPurchase(insertedMoney);
            }
        }
        return false;
    }
}
