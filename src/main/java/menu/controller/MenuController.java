package menu.controller;

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
    }
}
