package com.codecool.battleship;

import com.codecool.battleship.utils.Display;
import com.codecool.battleship.utils.Input;
import com.codecool.battleship.utils.MenuSelector;

public class Battleship {
    public static void main(String[] args) {
        Input input = new Input();
        Display display = new Display(input);
        MenuSelector menuSelector = new MenuSelector(display);

        boolean isRunning = true;
        while (isRunning) {
            display.printMenu();
            int validatedOption = input.validateInput(3, 1);
            new MenuSelector(validatedOption, display);

            isRunning = false;
        }
    }

}
