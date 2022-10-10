package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballNumber {
	private List<Integer> numberList;

	public BaseballNumber() {
	}

	public BaseballNumber(String input) {
		validateInput(input);
		numberList = convertIntegerList(input);
	}

	private List<Integer> convertIntegerList(String input) {
		return input.chars().boxed().collect(Collectors.toList());
	}

	private void validateInput(String input) {
		if (input.contains("0")) throw new IllegalArgumentException("0은 유효한 값이 아닙니다.");
		if (input.contains("-")) throw new IllegalArgumentException("음수는 유효한 값이 아닙니다.");
		if (input.length() != 3) throw new IllegalArgumentException("입력값의 자릿수가 3이 아닙니다.");
		if (input.chars().distinct().count() != input.length())
			throw new IllegalArgumentException("세 숫자 중 중복된 숫자가 존재합니다.");
	}

	public List<Integer> initNumber() {
		List<Integer> numberList = new ArrayList<>();

		while (numberList.size() != 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (numberList.contains(randomNumber)) continue;
			numberList.add(randomNumber);
		}

		return numberList;
	}

	public List<Integer> getNumberList() {
		return numberList;
	}
}
