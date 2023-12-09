package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static menu.handler.ConstantsHandler.*;

public class MenuRecommender {

    public static MenuRecommender create() {
        return new MenuRecommender();
    }

    public List<String> recommendMenus(List<MenuManager> menuManagerGroup) {
        List<String> recommendMenu = new ArrayList<>();

        for (MenuManager menuManager : menuManagerGroup) {
            String menu = Randoms.shuffle(menuManager.getMenus()).get(ZERO_INDEX.getValue());
            recommendMenu.add(menu);
        }

        return recommendMenu;
    }

    public List<MenuManager> getMenuManagerGroup() {
        List<MenuManager> menuManagerGroup = new ArrayList<>();

        for (int dayOfWeek = MONDAY.getValue(); dayOfWeek <= FRIDAY.getValue(); dayOfWeek++) {
            int randomNumber = generateRandomNumber();
            MenuManager menuManager = MenuManager.getMenuManagerByCategory(randomNumber);
            menuManagerGroup.add(menuManager);
        }

        return menuManagerGroup;
    }

    private int generateRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(MIN_CATEGORY.getValue(), MAX_CATEGORY.getValue());

        return randomNumber;
    }
}

