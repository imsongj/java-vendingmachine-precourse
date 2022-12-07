package vendingmachine.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class InputValidatorTest {
    @ParameterizedTest
    @CsvSource({
            "abc",
            "12vv",
            "+42"
    })
    @DisplayName("숫자가 아닌 입력을 하면 예외를 발생시킨다")
    void throwExceptionForNonNumeric(String input) {
        assertThatThrownBy(() -> InputValidator.validateNumeric(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정수가 아닌 입력을 하면 예외를 발생시킨다")
    void throwExceptionForNonInteger() {
        assertThatThrownBy(() -> InputValidator.validateInteger("10000000000"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
