package baseball.view;

import baseball.constant.BaseballGameNumber;
import baseball.constant.GameMessage;
import baseball.constant.InputExceptionMessage;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerInputView {
    public List<Integer> receiveInput() {
        System.out.println(GameMessage.WAIT_FOR_PLAYER_INPUT);
        String received = Console.readLine();

        if (received.length() == 0) {
            throw new IllegalArgumentException(InputExceptionMessage.EMPTY_NUMBER_PROVIDED);
        }

        List<Integer> numberList = makeNumbersListFromReceivedInput(received);

        validate(numberList);

        return numberList;
    }

    private void validate(List<Integer> numbers) {
        if (!hasCorrectLength(numbers)) {
            throw new IllegalArgumentException(InputExceptionMessage.OUT_OF_LENGTH_RANGE);
        }

        if (!isUniqueNumbers(numbers)) {
            throw new IllegalArgumentException(InputExceptionMessage.DUPLICATED_NUMBERS_PROVIDED);
        }
    }

    private List<Integer> makeNumbersListFromReceivedInput(String string) {
        String[] stringNumbers = string.split("");
        List<Integer> numbers = new ArrayList<>();

        for (String stringNumber : stringNumbers) {
            numbers.add(Integer.parseInt(stringNumber));
        }

        return numbers;
    }

    private boolean isUniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);

        return numbers.size() == uniqueNumbers.size();
    }

    private boolean hasCorrectLength(List<Integer> numbers) {
        return numbers.size() == BaseballGameNumber.MAX_LENGTH;
    }
}
