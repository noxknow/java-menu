package menu.handler;

public interface OutputHandler {

    void printError(String errorMessage);
    void printStartMessage();
    void requestCoachNameMessage();
    void requestRestrictedMenus(String coachName);
    void printRecommendMenuResult();
}
