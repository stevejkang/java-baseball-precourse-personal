package baseball.domain.judgement;

import baseball.constant.BaseballGameNumber;
import baseball.domain.GameNumber;
import baseball.domain.GameNumbers;

public class Strike implements Pitch {
    private int count;

    public Strike() {
        this.count = 0;
    }

    private void check(boolean check) {
        if (check) {
            this.count++;
        }
    }

    public void judge(GameNumbers opponentNumbers, GameNumbers playerNumbers) {
        for (int i = 0; i < BaseballGameNumber.MAX_LENGTH; i++) {
            GameNumber opponentNumber = opponentNumbers.getBallNumberByIndex(i);
            GameNumber playerNumber = playerNumbers.getBallNumberByIndex(i);
            check(opponentNumber.equals(playerNumber));
        }
    }

    public int getCount() {
        return this.count;
    }

    public void reset() {
        this.count = 0;
    }

    public boolean is() {
        return this.count > 0;
    }
}
