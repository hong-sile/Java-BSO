package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BaseballGameCalculator {

	public boolean calculateBSO(BaseballNumber answer, BaseballNumber input){
		List<Integer> answerNumber = answer.getNumberList();
		List<Integer> inputNumber = input.getNumberList();
		List<Integer> duplicateNumbers = createDuplicateList(answerNumber,inputNumber);
		int strikeCount = 0;
		int ballCount = 0;

		if(duplicateNumbers.size()==0){
			printResultOfGame(0,0);
			return false;
		}

		for(int i=0;i<3;i++){
			if(!duplicateNumbers.contains(inputNumber.get(i))) continue;
			if(answerNumber.get(i).equals(inputNumber.get(i))) strikeCount++;
			else ballCount++;
		}

		printResultOfGame(strikeCount,ballCount);

		if(strikeCount==3) return true;
		else return false;
	}

	private List<Integer> createDuplicateList(List<Integer> listOne, List<Integer> listTwo){
		List<Integer> numbers = Stream.concat(listOne.stream(),listTwo.stream())
				.collect(Collectors.toList());
		Set<Integer> duplicateFilter = new HashSet<>();

		return numbers.stream().filter(n -> !duplicateFilter.add(n))
				.collect(Collectors.toList());
	}

	private void printResultOfGame(int strikeCount, int ballCount){
		if(ballCount ==0 && strikeCount == 0) {
			System.out.println("낫싱");
			return;
		}

		if(ballCount != 0)
			System.out.print(ballCount+"볼 ");
		if(strikeCount != 0)
			System.out.print(strikeCount+"스트라이크");

		System.out.println();
	}
}