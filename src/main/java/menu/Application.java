package menu;

import menu.controller.MenuController;
import menu.handler.InputHandler;
import menu.handler.OutputHandler;
import menu.view.ConsoleInput;
import menu.view.ConsoleOutput;

public class Application {

    public static void main(String[] args) {

        final InputHandler inputHandler = new ConsoleInput();
        final OutputHandler outputHandler = new ConsoleOutput();

        new MenuController(inputHandler, outputHandler).run();
    }
}
