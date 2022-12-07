package vendingmachine.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CoinGeneratorTest {
    @Test
    @DisplayName("0부터 3을 포함한 리스트를 생성한다.")
    void generateNumberList() {
        assertThat(new CoinGenerator().generateNumberList()).isEqualTo(Arrays.asList(0,1,2,3));
    }

    @ParameterizedTest
    @CsvSource({
            "3000",
            "2020",
            "2660"
    })
    @DisplayName("주어진 금액에 맞게 동전을 생성한다.")
    void generateRandomCoin(int money) {
        Map<Coin, Integer> coins = new CoinGenerator().generateCoins(money);
        int sum = 0;
        for (Entry<Coin, Integer> entry : coins.entrySet()) {
            sum += entry.getKey().getAmount() * entry.getValue();
        }
        assertThat(money).isEqualTo(sum);
    }
}
