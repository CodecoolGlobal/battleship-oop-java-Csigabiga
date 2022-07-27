package com.codecool.battleship;

import com.codecool.battleship.board.Board;
import com.codecool.battleship.utils.Display;
import com.codecool.battleship.utils.Input;
import com.codecool.battleship.utils.MenuSelector;

import java.util.Arrays;

public class Battleship {
    public static void main(String[] args) {
        Display display = new Display();
        Input input = new Input();
        
        boolean isRunning = true;
        while (isRunning) {
            display.printMenu();
            int validatedOption = input.validateInput(3, 1, "Choose an option!");
            new MenuSelector(validatedOption);

            isRunning = false;
        }
    }

}
