package menu.domain.wrapper;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static menu.handler.ConstantsHandler.COMMA_DELIMITER;
import static menu.handler.ErrorHandler.INVALID_MENU_FORMAT;

public class CoachWithRestrictedMenu {

    private final String coachName;
    private final List<String> restrictedMenu;

    private CoachWithRestrictedMenu(String coachName, String restrictedMenu) {
        this.coachName = coachName;
        this.restrictedMenu = validateMenuFormat(restrictedMenu);
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
}
