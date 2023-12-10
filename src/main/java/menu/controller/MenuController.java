package menu.controller;

import menu.domain.MenuManager;
import menu.domain.MenuRecommender;
import menu.domain.wrapper.Coach;
import menu.domain.wrapper.CoachWithRestrictedMenu;
import menu.handler.InputHandler;
import menu.handler.OutputHandler;

import java.util.ArrayList;
import java.util.List;

public class MenuController {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public MenuController(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void run() {
        outputHandler.printStartMessage();

        Coach coach = loadCoach();

        List<CoachWithRestrictedMenu> coachWithRestrictedMenus = loadCoachWithRestrictedMenus(coach);
    }

    private Coach loadCoach() {
        Coach coach = null;

        while (coach == null) {
            try {
                outputHandler.requestCoachNameMessage();
                String inputNames = inputHandler.inputValue();
                coach = Coach.from(inputNames);
            } catch (IllegalArgumentException e) {
                outputHandler.printError(e.getMessage());
            }
        }

        return coach;
    }

    private List<CoachWithRestrictedMenu> loadCoachWithRestrictedMenus(Coach coach) {
        List<CoachWithRestrictedMenu> coachWithRestrictedMenus = new ArrayList<>();
        List<String> coachNames = coach.getCoachNames();

        while (coachWithRestrictedMenus.isEmpty()) {
            try {
                coachWithRestrictedMenus = addGroup(coachNames, coachWithRestrictedMenus);
            } catch (IllegalArgumentException e) {
                outputHandler.printError(e.getMessage());
            }
        }

        return coachWithRestrictedMenus;
    }

    private List<CoachWithRestrictedMenu> addGroup(List<String> coachNames, List<CoachWithRestrictedMenu> coachWithRestrictedMenus) {
        for (String coachName : coachNames) {
            outputHandler.requestRestrictedMenus(coachName);
            String restrictedMenu = inputHandler.inputValue();
            CoachWithRestrictedMenu coachWithRestrictedMenu = CoachWithRestrictedMenu.of(coachName, restrictedMenu);
            coachWithRestrictedMenus.add(coachWithRestrictedMenu);
        }

        return coachWithRestrictedMenus;
    }

    private void showMenuResult(Coach coach, List<CoachWithRestrictedMenu> coachWithRestrictedMenus) {

    }
}
