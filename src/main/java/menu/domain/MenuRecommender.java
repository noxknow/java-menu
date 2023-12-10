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

    public List<String> recommendMenus(List<String> categories, List<String> restrictedMenus) {
        List<String> recommendMenus = new ArrayList<>();

        for (String category : categories) {
            MenuManager menuManager = MenuManager.getMenuManagerByCategory(category);
            String menu = addMenu(menuManager, restrictedMenus, recommendMenus);
            recommendMenus.add(menu);
        }

        return recommendMenus;
    }

    private String addMenu(MenuManager menuManager, List<String> restrictedMenus, List<String> recommendMenus) {
        String menu;

        while (true) {
            menu = Randoms.shuffle(menuManager.getMenus()).get(ZERO_INDEX.getValue());

            if (!recommendMenus.contains(menu) && !restrictedMenus.contains(menu)) {
                break;
            }
        }

        return menu;
    }

    public List<String> randomCategories() {
        List<String> categories = new ArrayList<>();

        for (int dayOfWeek = MONDAY.getValue(); dayOfWeek <= FRIDAY.getValue();) {
            int randomNumber = generateRandomNumber();
            MenuManager menuManager = MenuManager.getMenuManagerByCategoryNumber(randomNumber);
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

