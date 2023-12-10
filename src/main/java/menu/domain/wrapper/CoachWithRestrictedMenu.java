package menu.domain.wrapper;

import menu.domain.MenuManager;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static menu.handler.ConstantsHandler.*;
import static menu.handler.ErrorHandler.*;

public class CoachWithRestrictedMenu {

    private final String coachName;
    private final List<String> restrictedMenus;

    private CoachWithRestrictedMenu(String coachName, String restrictedMenu) {
        this.coachName = coachName;
        this.restrictedMenus = validateMenuFormat(restrictedMenu);
        validateMenuRange(restrictedMenus);
        validateDuplicateMenu(restrictedMenus);
    }

    public static CoachWithRestrictedMenu of(String coachName, String restrictedMenu) {
        return new CoachWithRestrictedMenu(coachName, restrictedMenu);
    }

    private List<String> validateMenuFormat(String restrictedMenu) {
        String regex = "^[ㄱ-ㅎ|가-힣|,| ]*$"; // 빈칸도 가능하도록 + 가 아닌 *

        if (!Pattern.matches(regex, restrictedMenu)) {
            throw INVALID_MENU_FORMAT.getException();
        }

        return Arrays.stream(restrictedMenu.split(COMMA_DELIMITER.getWord()))
                .collect(Collectors.toList());
    }

    private void validateMenuRange(List<String> restrictedMenus) {
        if (restrictedMenus.size() < MIN_MENU_RANGE.getValue() || restrictedMenus.size() > MAX_MENU_RANGE.getValue()) {
            throw INVALID_MENU_RANGE.getException();
        }
    }

    private void validateDuplicateMenu(List<String> restrictedMenuGroup) {
        Set<String> uniqueName = new HashSet<>(restrictedMenuGroup);

        if (uniqueName.size() != restrictedMenuGroup.size()) {
            throw DUPLICATE_RESTRICTED_MENU.getException();
        }
    }

    public String getCoachName() {
        return coachName;
    }

    public List<String> getRestrictedMenus() {
        return List.copyOf(restrictedMenus);
    }
}
