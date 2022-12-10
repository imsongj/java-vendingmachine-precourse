package vendingmachine.model;

import java.util.Arrays;
import java.util.LinkedHashMap;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CoinGenerator {
    private static final int NUMBER_OF_COIN_TYPES = 4;
    private static final int MINIMUM_COIN_VALUE = 10;
    private static final int INITIAL_VALUE = 0;
    private static final int INCREMENT_VALUE = 1;

    public LinkedHashMap<Coin, Integer> generateCoins(int money) {
        LinkedHashMap<Coin, Integer> coins = initializeCoins();
        while (money >= MINIMUM_COIN_VALUE) {
            Coin coin = generateRandomCoin(money);
            coins.merge(coin, INCREMENT_VALUE, Integer::sum);
            money -= coin.getAmount();
        }
        return coins;
    }

    public Coin generateRandomCoin(int maxValue) {
        List<Integer> numbers = generateNumberList();
        Coin coin;
        do {
            coin = Coin.values()[Randoms.pickNumberInList(numbers)];
        } while (coin.getAmount() > maxValue);
        return coin;
    }

    public LinkedHashMap<Coin, Integer> initializeCoins() {
        LinkedHashMap<Coin, Integer> coins = new LinkedHashMap<>();
        Arrays.stream(Coin.values())
                .forEach(coin -> coins.put(coin, INITIAL_VALUE));
        return coins;
    }

    public List<Integer> generateNumberList() {
        return IntStream.range(INITIAL_VALUE, NUMBER_OF_COIN_TYPES)
                .boxed()
                .collect(Collectors.toList());
    }
}
