package vendingmachine.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CoinsTest {
    @ParameterizedTest
    @MethodSource("provideParametersForCoins")
    @DisplayName("금액에 맞는 코인 개수를 반환한다.")
    void getNumberOfCoins(int stock, int money, int count) {
        Coin coin = Coin.COIN_50;
        assertThat(new Coins(3000).getNumberOfCoins(coin, stock, money)).isEqualTo(count);
    }

    private static Stream<Arguments> provideParametersForCoins() {
        return Stream.of(
                Arguments.of(3, 150, 3),
                Arguments.of(3, 200, 3),
                Arguments.of(3, 100, 2)
        );
    }
}
