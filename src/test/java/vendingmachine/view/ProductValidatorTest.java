package vendingmachine.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import vendingmachine.model.Product;
import vendingmachine.view.validator.ProductValidator;

public class ProductValidatorTest {
    @ParameterizedTest
    @MethodSource("provideParametersForProductValue")
    @DisplayName("잘못된 상품 정보를 입력하면 예외를 발생시킨다.")
    void throwExceptionForInvalidProductValues(String productInput) {
        assertThatThrownBy(() -> new ProductValidator().validateProductValues(productInput))
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

    @ParameterizedTest
    @MethodSource("provideParametersForProduct")
    @DisplayName("잘못된 상품 리스트를 입력하면 예외를 발생시킨다.")
    void throwExceptionForInvalidProduct(String productInput) {
        assertThatThrownBy(() -> new ProductValidator().validateProductString(productInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideParametersForProduct() {
        return Stream.of(
                Arguments.of("[a,123,1];[ab,12,2]123"),
                Arguments.of("[a,123,1];;[ab,12,2]"),
                Arguments.of(";[a,123,1]"),
                Arguments.of("[a,123,1];[a,123,1]; "),
                Arguments.of("a,123,3")
        );
    }

    @Test
    @DisplayName("상품 중 중복된 이름이 존재하면 예외를 발생시킨다.")
    void throwExceptionForDuplicate() {
        List<Product> products = Arrays.asList(new Product("[콜라,3000,1]"),
                new Product("[콜라,2000,3]"));
        assertThatThrownBy(() -> new ProductValidator().validateDuplicateName(products))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
