package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballNumber {
	private List<Integer> baseballNumber = new ArrayList<>();
	private static final String ZERO = "0";
	private static final String NEGATIVE = "-";
	private static final Integer BASE_BALL_NUMBER_SIZE = 3;

	public BaseballNumber() {}
	private List<Integer> convertIntegerList(String input) {
		return input.chars().boxed().collect(Collectors.toList());
	}

	private void validateInput(String input) {
		if (input.contains(ZERO)) throw new IllegalArgumentException("0은 유효한 값이 아닙니다.");
		if (input.contains(NEGATIVE)) throw new IllegalArgumentException("음수는 유효한 값이 아닙니다.");
		if (input.length() != BASE_BALL_NUMBER_SIZE) throw new IllegalArgumentException("입력값의 자릿수가 3이 아닙니다.");
		if (input.chars().distinct().count() != input.length())
			throw new IllegalArgumentException("세 숫자 중 중복된 숫자가 존재합니다.");
	}

	public void initNumber() {
		while (baseballNumber.size() != BASE_BALL_NUMBER_SIZE) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (baseballNumber.contains(randomNumber)) continue;
			baseballNumber.add(randomNumber);
		}
	}

	public List<Integer> getBaseballNumber() {
		return baseballNumber;
	}
	public void setBaseballNumber(String input){
		validateInput(input);
		baseballNumber = convertIntegerList(input);
	}
}