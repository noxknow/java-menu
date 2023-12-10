package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static menu.handler.ConstantsHandler.*;

public class MenuRecommender {

    public static MenuRecommender create() {
        return new MenuRecommender();
    }

    public List<String> recommendMenus(List<MenuManager> menuManagers) {
        List<String> recommendMenu = new ArrayList<>();

        for (MenuManager menuManager : menuManagers) {
            String menu = Randoms.shuffle(menuManager.getMenus()).get(ZERO_INDEX.getValue());
            recommendMenu.add(menu);
        }

        return recommendMenu;
    }

    public List<MenuManager> getMenuManagerGroup() {
        List<MenuManager> menuManagers = new ArrayList<>();

        for (int dayOfWeek = MONDAY.getValue(); dayOfWeek <= FRIDAY.getValue(); dayOfWeek++) {
            int randomNumber = generateRandomNumber();
            MenuManager menuManager = MenuManager.getMenuManagerByCategory(randomNumber);
            menuManagers.add(menuManager);
        }

        return menuManagers;
    }

    public List<String> randomCategories(List<MenuManager> menuManagers) {
        List<String> categories = new ArrayList<>();

        for (MenuManager menuManager : menuManagers) {
            String category = menuManager.getCategory();
            categories.add(category);
        }

        return categories;
    }

    private int generateRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(MIN_CATEGORY.getValue(), MAX_CATEGORY.getValue());

        return randomNumber;
    }
}

