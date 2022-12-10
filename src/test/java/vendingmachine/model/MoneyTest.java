package vendingmachine.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class MoneyTest {
    @ParameterizedTest
    @CsvSource({
            "abc",
            "12vv",
            "+42",
            "10000000000"
    })
    @DisplayName("숫자가 아닌 입력을 하면 예외를 발생시킨다")
    void throwExceptionForInvalidMoney(String input) {
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
