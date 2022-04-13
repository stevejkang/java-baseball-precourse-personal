package baseball.domain.judgement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.constant.JudgementMessage;
import baseball.domain.GameNumbers;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JudgementTest {
    @Test()
    @DisplayName("3스트라이크")
    void judgementTest_threeStrike() {
        List<Integer> givenOpponentNumbers = new ArrayList<>();
        givenOpponentNumbers.add(1);
        givenOpponentNumbers.add(2);
        givenOpponentNumbers.add(3);

        List<Integer> givenPlayerNumbers = new ArrayList<>();
        givenPlayerNumbers.add(1);
        givenPlayerNumbers.add(2);
        givenPlayerNumbers.add(3);

        GameNumbers opponentNumbers = GameNumbers.of(givenOpponentNumbers);
        GameNumbers playerNumbers = GameNumbers.of(givenPlayerNumbers);

        Judgement judgement = Judgement.createNew();
        judgement.judge(opponentNumbers, playerNumbers);

        assertFalse(judgement.isPlay());
        assertEquals(String.format(JudgementMessage.GAME_SUCCESS_JUDGEMENT), judgement.getMessage());
    }

    @Test()
    @DisplayName("N볼 N스트라이크")
    void judgementTest_strikeAndBall() {
        List<Integer> givenOpponentNumbers = new ArrayList<>();
        givenOpponentNumbers.add(1);
        givenOpponentNumbers.add(2);
        givenOpponentNumbers.add(3);

        List<Integer> givenPlayerNumbers = new ArrayList<>();
        givenPlayerNumbers.add(1);
        givenPlayerNumbers.add(3);
        givenPlayerNumbers.add(2);

        GameNumbers opponentNumbers = GameNumbers.of(givenOpponentNumbers);
        GameNumbers playerNumbers = GameNumbers.of(givenPlayerNumbers);

        Judgement judgement = Judgement.createNew();
        judgement.judge(opponentNumbers, playerNumbers);

        assertTrue(judgement.isPlay());
        assertEquals(String.format(JudgementMessage.STRIKE_AND_BALL, 2, 1), judgement.getMessage());
    }

    @Test()
    @DisplayName("N볼")
    void judgementTest_ball() {
        List<Integer> givenOpponentNumbers = new ArrayList<>();
        givenOpponentNumbers.add(1);
        givenOpponentNumbers.add(2);
        givenOpponentNumbers.add(3);

        List<Integer> givenPlayerNumbers = new ArrayList<>();
        givenPlayerNumbers.add(3);
        givenPlayerNumbers.add(1);
        givenPlayerNumbers.add(2);

        GameNumbers opponentNumbers = GameNumbers.of(givenOpponentNumbers);
        GameNumbers playerNumbers = GameNumbers.of(givenPlayerNumbers);

        Judgement judgement = Judgement.createNew();
        judgement.judge(opponentNumbers, playerNumbers);

        assertTrue(judgement.isPlay());
        assertEquals(String.format(JudgementMessage.ONLY_BALL, 3), judgement.getMessage());
    }

    @Test()
    @DisplayName("N스트라이크")
    void judgementTest_strike() {
        List<Integer> givenOpponentNumbers = new ArrayList<>();
        givenOpponentNumbers.add(1);
        givenOpponentNumbers.add(2);
        givenOpponentNumbers.add(3);

        List<Integer> givenPlayerNumbers = new ArrayList<>();
        givenPlayerNumbers.add(1);
        givenPlayerNumbers.add(2);
        givenPlayerNumbers.add(5);

        GameNumbers opponentNumbers = GameNumbers.of(givenOpponentNumbers);
        GameNumbers playerNumbers = GameNumbers.of(givenPlayerNumbers);

        Judgement judgement = Judgement.createNew();
        judgement.judge(opponentNumbers, playerNumbers);

        assertTrue(judgement.isPlay());
        assertEquals(String.format(JudgementMessage.ONLY_STRIKE, 2), judgement.getMessage());
    }

    @Test()
    @DisplayName("낫싱")
    void judgementTest_nothing() {
        List<Integer> givenOpponentNumbers = new ArrayList<>();
        givenOpponentNumbers.add(1);
        givenOpponentNumbers.add(2);
        givenOpponentNumbers.add(3);

        List<Integer> givenPlayerNumbers = new ArrayList<>();
        givenPlayerNumbers.add(4);
        givenPlayerNumbers.add(5);
        givenPlayerNumbers.add(6);

        GameNumbers opponentNumbers = GameNumbers.of(givenOpponentNumbers);
        GameNumbers playerNumbers = GameNumbers.of(givenPlayerNumbers);

        Judgement judgement = Judgement.createNew();
        judgement.judge(opponentNumbers, playerNumbers);

        assertTrue(judgement.isPlay());
        assertEquals(String.format(JudgementMessage.NOTHING), judgement.getMessage());
    }
}
