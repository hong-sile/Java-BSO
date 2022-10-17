package baseball;

import baseball.domain.BaseballGameCalculator;
import baseball.domain.BaseballNumber;
import camp.nextstep.edu.missionutils.Console;

public class Controller {
	private final BaseballGameCalculator baseBallGameCalculator = new BaseballGameCalculator();
	private final BaseballNumber answer = new BaseballNumber();
	private final BaseballNumber input = new BaseballNumber();
	private static final String gameRestartCommand = "1";
	private static final String gameEndCommand = "2";

	public void run(){
		String command;
		do{
			initGame();
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
			command = inputCommand();
		}while (command.equals(gameRestartCommand));
	}

	private void initGame(){
		answer.initNumber();
		System.out.print("숫자를 입력해주세요 : ");
		do{
			input.setBaseballNumber(Console.readLine());
		}while(baseBallGameCalculator.calculateBSO(answer,input));
	}

	private String inputCommand(){
		String command;
		command = Console.readLine();

		while(!command.equals(gameRestartCommand) && !command.equals(gameEndCommand)){
			System.out.println("잘못된 값을 입력하셨습니다.");
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			command=Console.readLine();
		}

		return command;
	}
}