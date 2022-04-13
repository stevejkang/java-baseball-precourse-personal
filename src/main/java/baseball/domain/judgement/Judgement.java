package baseball.domain.judgement;

import baseball.constant.GameMessage;
import baseball.domain.GameNumbers;
import baseball.view.ResultView;

public class Judgement {
    private Strike strike;
    private Ball ball;
    private ResultView resultView;
    private GameStatus gameStatus;

    private Judgement() {
        this.strike = new Strike();
        this.ball = new Ball();
        this.resultView = new ResultView(strike, ball);
        this.gameStatus = gameStatus.ON_GOING;
    }

    public static Judgement createNew() {
        return new Judgement();
    }

    public void judge(GameNumbers opponentNumbers, GameNumbers playerNumbers) {
        strike.judge(opponentNumbers, playerNumbers);
        ball.judge(opponentNumbers, playerNumbers);

        System.out.println(this.getMessage());
        gameOverCheck();
    }

    private void gameOverCheck() {
        if (this.isGameOver()) {
            System.out.println(GameMessage.GAME_OVER);
            this.gameStatus = GameStatus.GAME_OVER;
        }
    }

    private boolean isGameOver() {
        return this.strike.getCount() == 3 && this.ball.getCount() == 0;
    }

    public String getMessage() {
        return this.resultView.print();
    }

    public boolean isPlay() {
        return this.gameStatus == GameStatus.ON_GOING;
    }

    public void clear() {
        this.strike.reset();
        this.ball.reset();
    }

}
