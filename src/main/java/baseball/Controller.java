package baseball;

import baseball.domain.BaseballGameCalculator;
import baseball.domain.BaseballNumber;
import camp.nextstep.edu.missionutils.Console;

public class Controller {
	private final BaseballGameCalculator baseBallGameCalculator = new BaseballGameCalculator();
	private final BaseballNumber answer = new BaseballNumber();
	private final BaseballNumber input = new BaseballNumber();
	private String command;
	private static final String GAME_RESTART_COMMAND = "1";
	private static final String GAME_END_COMMAND = "2";
	private static final String GUESS_ANSWER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String ASK_RESTART_MESSAGE= "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";
	private static final String INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String WRONG_INPUT_MESSAGE = "잘못된 값을 입력하셨습니다.";

	public void run(){
		do{
			initGame();
			System.out.println(GUESS_ANSWER_MESSAGE);
			System.out.println(ASK_RESTART_MESSAGE);
			inputCommand();
		}while (command.equals(GAME_RESTART_COMMAND));
	}

	private void initGame(){
		answer.initNumber();
		System.out.print(INPUT_NUMBERS_MESSAGE);
		do{
			input.setBaseballNumber(Console.readLine());
		}while(baseBallGameCalculator.calculateBSO(answer,input));
	}

	private void inputCommand(){
		command = Console.readLine();

		while(!command.equals(GAME_RESTART_COMMAND) && !command.equals(GAME_END_COMMAND)){
			System.out.println(WRONG_INPUT_MESSAGE);
			System.out.println(ASK_RESTART_MESSAGE);
			command=Console.readLine();
		}
	}
}