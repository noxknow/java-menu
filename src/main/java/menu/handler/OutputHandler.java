package menu.handler;

import java.util.List;

public interface OutputHandler {

    void printError(String errorMessage);
    void printStartMessage();
    void requestCoachNameMessage();
    void requestRestrictedMenus(String coachName);
    void printCategories(List<String> categories);
}
