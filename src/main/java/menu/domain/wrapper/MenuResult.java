package menu.domain.wrapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static menu.handler.ConstantsHandler.MAX_DUPLICATE;
import static menu.handler.ErrorHandler.DUPLICATE_CATEGORY;

public class MenuResult {

    private final String coachName;
    private final List<String> recommendMenu;
    private final List<String> categories;

    private MenuResult(String coachName, List<String> recommendMenu, List<String> categories) {
        this.coachName = coachName;
        this.recommendMenu = recommendMenu;
        this.categories = categories;
        validateDuplicateCategory(categories);
    }

    public static MenuResult of(String coachName, List<String> recommendMenu, List<String> categories) {
        return new MenuResult(coachName, recommendMenu, categories);
    }

    private void validateDuplicateCategory(List<String> categories) {
        Set<String> uniqueCategory = new HashSet<>(categories);

        if (uniqueCategory.size() <= MAX_DUPLICATE.getValue()) {
            throw DUPLICATE_CATEGORY.getException();
        }
    }
}
