package vendingmachine.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ProductTest {
    @ParameterizedTest
    @MethodSource("provideParametersForProductValue")
    @DisplayName("잘못된 상품 정보를 입력하면 예외를 발생시킨다.")
    void throwExceptionForInvalidProductValues(String productInput) {
        assertThatThrownBy(() -> new Product(productInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideParametersForProductValue() {
        return Stream.of(
                Arguments.of("[a,123,a]"),
                Arguments.of("[a,12dv,2]"),
                Arguments.of("[jim,10000000000, 10]"),
                Arguments.of("[a, 1200]"),
                Arguments.of("[a, 1200, 20, 1]"),
                Arguments.of("[]"),
                Arguments.of("[,,,]")
        );
    }
}
