package menu.domain.wrapper;

import menu.domain.MenuManager;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static menu.handler.ConstantsHandler.*;
import static menu.handler.ErrorHandler.*;

public class CoachWithRestrictedMenu {

    private final String coachName;
    private final List<String> restrictedMenuGroup;

    private CoachWithRestrictedMenu(String coachName, String restrictedMenu) {
        this.coachName = coachName;
        this.restrictedMenuGroup = validateMenuFormat(restrictedMenu);
        validateMenuType(restrictedMenuGroup);
        validateMenuRange(restrictedMenuGroup);
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

    private void validateMenuType(List<String> restrictedMenuGroup) {
        for (String menu : restrictedMenuGroup) {
            MenuManager menuManager = MenuManager.getMenuManagerByMenus(menu);

            if (menuManager == null) {
                throw NON_EXISTENT_MENU.getException();
            }
        }
    }

    private void validateMenuRange(List<String> restrictedMenuGroup) {
        if (restrictedMenuGroup.size() < MIN_MENU_RANGE.getValue() || restrictedMenuGroup.size() > MAX_MENU_RANGE.getValue()) {
            throw INVALID_MENU_RANGE.getException();
        }
    }
}
