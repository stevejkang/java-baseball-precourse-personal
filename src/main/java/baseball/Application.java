package baseball;

import baseball.controller.BaseballGameController;
import baseball.domain.GameNumberGenerator;

public class Application {
    public static void main(String[] args) {
        BaseballGameController controller = new BaseballGameController(
            new GameNumberGenerator()
        );

        controller.playGame();
    }
}
