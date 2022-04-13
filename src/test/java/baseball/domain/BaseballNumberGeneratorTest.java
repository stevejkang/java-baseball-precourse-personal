package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballNumberGeneratorTest {
    @Test()
    @DisplayName("세자리 숫자가 생성되는 지")
    void 길이에_맞는_생성() {
        NumberGenerator numberGenerator = new GameNumberGenerator();
        List<Integer> numbers = numberGenerator.generate();

        assertEquals(3, numbers.size(), "3자리 숫자가 생성됨");
    }

    @Test()
    @DisplayName("중복이 없는 숫자가 생성되는 지")
    void 중복이_없는_생성() {
        NumberGenerator numberGenerator = new GameNumberGenerator();
        List<Integer> numbers = numberGenerator.generate();

        Set<Integer> numbersSet = new LinkedHashSet<>(numbers);

        assertEquals(numbers.size(), numbersSet.size(), "중복이 없는 숫자가 생성됨");
    }
}
