package baseball.domain;

public class GameNumber {
    private final int number;

    private GameNumber(int number) {
        this.number = number;
    }

    public static GameNumber of(Integer number) {
        return new GameNumber(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final GameNumber that = (GameNumber) o;

        return number == that.number;
    }
}
