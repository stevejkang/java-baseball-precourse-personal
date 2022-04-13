package baseball.domain;

import java.util.List;

public class Opponent {
    private final GameNumbers gameNumbers;

    private Opponent(GameNumbers gameNumbers) {
        this.gameNumbers = gameNumbers;
    }

    public static Opponent generate(GameNumberGenerator gameNumberGenerator) {
        List<Integer> generateNumbers = gameNumberGenerator.generate();
        return new Opponent(GameNumbers.of(generateNumbers));
    }

    public GameNumbers getNumbers() {
        return this.gameNumbers;
    }
}
