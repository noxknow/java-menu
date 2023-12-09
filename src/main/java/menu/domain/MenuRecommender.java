package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuRecommender {

    private MenuRecommender() {

    }

    public static MenuRecommender create() {
        return new MenuRecommender();
    }

    public Map<Integer, String> loadRecommendMenus() {
        Map<Integer, String> recommendMenu = new HashMap<>();

        for (int i = 1; i <= 5; i++) {
            int randomNumber = Randoms.pickNumberInRange(1, 5);
            String menu = getMenu(randomNumber);

            recommendMenu.put(randomNumber, menu);
        }

        return recommendMenu;
    }

    private String getMenu(int randomNumber) {
        MenuManager menuManager = MenuManager.getMenuManager(randomNumber);
        List<String> menus = menuManager.getMenus();
        String menu = Randoms.shuffle(menus).get(0);

        return menu;
    }
}
