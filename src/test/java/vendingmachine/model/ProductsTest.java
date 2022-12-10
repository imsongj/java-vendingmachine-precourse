package vendingmachine.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ProductsTest {
    @ParameterizedTest
    @MethodSource("provideParametersForPurchase")
    @DisplayName("상품을 구매할 수 있는지 반환한다.")
    void returnTrueIfProductIsPurchasable(int money, String name) {
        Products products = new Products("[apple,1000,3];[banana,3000,1];[kiwi,1000,0]");
        assertThatThrownBy(() -> products.canPurchase(name, money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideParametersForPurchase() {
        return Stream.of(
                Arguments.of(900, "apple"),
                Arguments.of(1000, "banana"),
                Arguments.of(3000, "kiwi")
        );
    }

    @ParameterizedTest
    @MethodSource("provideParametersForProducts")
    @DisplayName("구매할 수 있는 상품이 존재하는지 확인한다")
    void returnTrueIfEveryProductIsNotPurchasable(Products products, boolean result) {
        assertThat(products.cannotPurchaseAnyProduct(900)).isEqualTo(result);
    }

    private static Stream<Arguments> provideParametersForProducts() {
        return Stream.of(
                Arguments.of(new Products("[apple,1000,3];[banana,3000,1];[kiwi,1000,0]"), true),
                Arguments.of(new Products("[apple,1000,3];[banana,3000,1];[kiwi,800,0]"), true),
                Arguments.of(new Products("[apple,900,3];[banana,3000,1];[kiwi,1000,0]"), false)
        );
    }
}
