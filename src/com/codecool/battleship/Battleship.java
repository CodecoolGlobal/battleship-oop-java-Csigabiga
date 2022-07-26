package com.codecool.battleship;

import com.codecool.battleship.utils.Display;
import com.codecool.battleship.utils.Input;

public class Battleship {
    public static void main(String[] args) {
        Display display = new Display();
        Input input = new Input();
        
        boolean isRunning = true;
        while (isRunning) {
            display.printMenu();
            input.chooseMenu();
            isRunning = false;
        }
    }

}
