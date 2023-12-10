package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
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

    public List<String> randomCategories() {
        List<String> categories = new ArrayList<>();

        for (int dayOfWeek = MONDAY.getValue(); dayOfWeek <= FRIDAY.getValue();) {
            int randomNumber = generateRandomNumber();
            MenuManager menuManager = MenuManager.getMenuManagerByCategory(randomNumber);
            String category = menuManager.getCategory();

            if (Collections.frequency(categories, category) < MAX_DUPLICATE.getValue()) {
                categories.add(category);
                dayOfWeek++;
            }
        }

        return categories;
    }

    private int generateRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(MIN_CATEGORY.getValue(), MAX_CATEGORY.getValue());

        return randomNumber;
    }
}

