package baseball.controller;

import baseball.constant.GameMessage;
import baseball.domain.GameNumberGenerator;
import baseball.domain.GameNumbers;
import baseball.domain.Opponent;
import baseball.domain.judgement.Judgement;
import baseball.view.PlayerInputView;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseballGameController {
    private final GameNumberGenerator gameNumberGenerator;
    private final PlayerInputView playerInputView;
    private final String USER_RESTART_INPUT = "1";

    public BaseballGameController(GameNumberGenerator gameNumberGenerator) {
        this.gameNumberGenerator = gameNumberGenerator;
        this.playerInputView = new PlayerInputView();
    }

    public void playGame() {
        Judgement judgement = Judgement.createNew();
        Opponent opponent = Opponent.generate(this.gameNumberGenerator);

        while (judgement.isPlay()) {
            List<Integer> receivedInput = this.playerInputView.receiveInput();
            GameNumbers playerNumbers = GameNumbers.of(receivedInput);

            judgement.clear();
            judgement.judge(opponent.getNumbers(), playerNumbers);
        }

        askRestartOrExist();
    }

    private void askRestartOrExist() {
        System.out.println(GameMessage.ASK_REPLAY_TO_PLAYER);
        String answer = Console.readLine();

        if (answer.equals(USER_RESTART_INPUT)) {
            playGame();
        }
    }
}
