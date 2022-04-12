package baseball.domain;

import baseball.constant.BaseballGameNumber;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class GameNumberGenerator implements NumberGenerator {
    @Override
    public List<Integer> generate() {
        final Set<Integer> numberSet = new LinkedHashSet<>();
        while (numberSet.size() < BaseballGameNumber.MAX_LENGTH) {
            numberSet.add(pickWithoutDuplicates(numberSet, BaseballGameNumber.MIN_VALUE, BaseballGameNumber.MAX_VALUE));
        }

        return new ArrayList<>(numberSet);
    }

    private Integer pickWithoutDuplicates(Set<Integer> generated, int rangeMin, int rangeMax) {
        Integer picked;
        do {
            picked = Randoms.pickNumberInRange(rangeMin, rangeMax);
        } while (generated.contains(picked));

        return picked;
    }
}
