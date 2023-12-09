package menu.controller;

import menu.domain.wrapper.Coach;
import menu.handler.InputHandler;
import menu.handler.OutputHandler;

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
}
