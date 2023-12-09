package menu.view;

import menu.handler.OutputHandler;

public class ConsoleOutput implements OutputHandler {

    @Override
    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    @Override
    public void printStartMessage() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    @Override
    public void requestCoachNameMessage() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }
}
