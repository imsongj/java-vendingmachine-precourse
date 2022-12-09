package vendingmachine.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ProductsTest {
    @ParameterizedTest
    @MethodSource("provideParametersForProducts")
    @DisplayName("상품을 구매할 수 있는지 반환한다.")
    void returnTrueIfProductIsPurchasable(int money, String name, boolean result) {
        Products products = new Products(Arrays.asList(new Product("apple", 1000, 3),
                new Product("banana", 3000, 3),
                new Product("kiwi", 1000, 0)));
        assertThat(products.canPurchase(name, money)).isEqualTo(result);
    }

    private static Stream<Arguments> provideParametersForProducts() {
        return Stream.of(
                Arguments.of(1000, "apple", true ),
                Arguments.of(900, "apple", false ),
                Arguments.of(1000, "banana", false ),
                Arguments.of(3000, "kiwi", false)
        );
    }
}
