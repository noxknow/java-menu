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
        System.out.println();
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
    }

    @Override
    public void requestRestrictedMenus(String coachName) {
        System.out.println();
        System.out.println(coachName + "(이)가 못 먹는 메뉴를 입력해 주세요.");
    }

    @Override
    public void printRecommendMenuResult() {
        System.out.println();
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
    }
}
