package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static menu.handler.ConstantsHandler.*;

public class MenuRecommender {

    private MenuRecommender() {

    }

    public static MenuRecommender create() {
        return new MenuRecommender();
    }

    public Map<Integer, String> loadRecommendMenus() {
        Map<Integer, String> recommendMenu = new HashMap<>();

        for (int dayOfWeek = MONDAY.getValue(); dayOfWeek <= FRIDAY.getValue(); dayOfWeek++) {
            int randomNumber = Randoms.pickNumberInRange(MIN_CATEGORY.getValue(), MAX_CATEGORY.getValue());
            String menu = getMenu(randomNumber);

            recommendMenu.put(randomNumber, menu);
        }

        return recommendMenu;
    }

    private String getMenu(int randomNumber) {
        MenuManager menuManager = MenuManager.getMenuManager(randomNumber);
        List<String> menus = menuManager.getMenus();
        String menu = Randoms.shuffle(menus).get(ZERO_INDEX.getValue());

        return menu;
    }
}
