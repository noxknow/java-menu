package menu.domain.wrapper;

import java.util.List;

public class MenuResult {

    private final String coachName;
    private final List<String> recommendMenu;
    private final List<String> restrictedMenu;
    private final List<String> categories;

    private MenuResult(String coachName, List<String> recommendMenu, List<String> restrictedMenu, List<String> categories) {
        this.coachName = coachName;
        this.recommendMenu = recommendMenu;
        this.restrictedMenu = restrictedMenu;
        this.categories = categories;
    }

    public static MenuResult of(String coachName, List<String> recommendMenu, List<String> restrictedMenu, List<String> categories) {
        return new MenuResult(coachName, recommendMenu, restrictedMenu, categories);
    }
}
