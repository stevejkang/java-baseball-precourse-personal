package baseball.domain;

import baseball.constant.BaseballGameNumber;
import baseball.constant.InputExceptionMessage;
import java.util.ArrayList;
import java.util.List;

public class GameNumbers {
    private final List<GameNumber> numbers;

    private GameNumbers(List<GameNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static GameNumbers of(List<Integer> numbers) {
        List<GameNumber> results = new ArrayList<>();
        for (Integer number : numbers) {
            results.add(GameNumber.of(number));
        }

        return new GameNumbers(results);
    }

    public int size() {
        return this.numbers.size();
    }

    private void validate(List<GameNumber> numbers) {
        checkIsEmpty(numbers);
        checkLength(numbers);
    }

    private void checkIsEmpty(List<GameNumber> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException(InputExceptionMessage.EMPTY_NUMBER_PROVIDED);
        }
    }

    private void checkLength(List<GameNumber> numbers) {
        if (numbers.size() != BaseballGameNumber.MAX_LENGTH) {
            throw new IllegalArgumentException(InputExceptionMessage.OUT_OF_LENGTH_RANGE);
        }
    }

    public GameNumber getBallNumberByIndex(int index) {
        return this.numbers.get(index);
    }

    public boolean contains(GameNumber number) {
        return this.numbers.contains(number);
    }
}
