package baseball.view;

import baseball.constant.JudgementMessage;
import baseball.domain.judgement.Ball;
import baseball.domain.judgement.Strike;

public class ResultView {
    private final Strike strike;
    private final Ball ball;

    public ResultView(Strike strike, Ball ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public String print() {
        if (strike.getCount() == 3 && ball.getCount() == 0) {
            return String.format(JudgementMessage.GAME_SUCCESS_JUDGEMENT);
        }

        if (strike.is() && ball.is()) {
            return String.format(JudgementMessage.STRIKE_AND_BALL, ball.getCount(), strike.getCount());
        }

        if (!strike.is() && ball.is()) {
            return String.format(JudgementMessage.ONLY_BALL, ball.getCount());
        }

        if (strike.is() && !ball.is()) {
            return String.format(JudgementMessage.ONLY_STRIKE, strike.getCount());
        }

        return JudgementMessage.NOTHING;
    }
}
