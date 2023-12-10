package menu.domain;

import java.util.List;

import static menu.handler.ConstantsHandler.JOIN_MARK;

public class MenuResult {

    private final String coachName;
    private final List<String> recommendMenus;

    private MenuResult(String coachName, List<String> recommendMenus) {
        this.coachName = coachName;
        this.recommendMenus = recommendMenus;
    }

    public static MenuResult of(String coachName, List<String> recommendMenus) {
        return new MenuResult(coachName, recommendMenus);
    }

    public String recommendMenuResult() {
        String menuResult = "[ " + coachName + " | " + String.join(JOIN_MARK.getWord(), recommendMenus) + " ]";

        return menuResult;
    }
}
