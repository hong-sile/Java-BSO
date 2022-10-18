package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BaseballGameCalculator {
	public static boolean calculateBSO(BaseballNumber answer, BaseballNumber input){
		List<Integer> answerNumbers = answer.getBaseballNumber();
		List<Integer> inputNumbers = input.getBaseballNumber();
		List<Integer> duplicateNumbers = createDuplicateList(answer.getBaseballNumber(),
				input.getBaseballNumber());
		int strikeCount = 0;
		int ballCount = 0;

		if(duplicateNumbers.size()==0){
			printResultOfGame(0,0);
			return true;
		}

		for(int i=0;i<3;i++){
			if(!duplicateNumbers.contains(inputNumbers.get(i))) continue;
			if(answerNumbers.get(i).equals(inputNumbers.get(i))) strikeCount++;
			else ballCount++;
		}

		printResultOfGame(strikeCount,ballCount);

		if(strikeCount == 3) return false;
		else return true;
	}

	private static List<Integer> createDuplicateList(List<Integer> listOne, List<Integer> listTwo){
		List<Integer> numbers = concatTwoList(listOne, listTwo);
		Set<Integer> duplicateFilter = new HashSet<>();

		return numbers.stream().filter(n -> !duplicateFilter.add(n))
				.collect(Collectors.toList());
	}

	private static List<Integer> concatTwoList(List<Integer> listOne, List<Integer> listTwo) {
		List<Integer> numbers = new ArrayList<>();
		numbers.addAll(listOne);
		numbers.addAll(listTwo);
		return numbers;
	}

	private static void printResultOfGame(int strikeCount, int ballCount){
		if(ballCount == 0 && strikeCount == 0) {
			System.out.println("낫싱");
			return;
		}

		if(ballCount != 0) System.out.print(ballCount+"볼 ");
		if(strikeCount != 0) System.out.print(strikeCount+"스트라이크");

		System.out.println();
	}
}