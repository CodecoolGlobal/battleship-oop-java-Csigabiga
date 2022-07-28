package com.codecool.battleship.utils;

public class MenuSelector {
    public int chooseMenu(int option, Display display) {
        switch (option) {
            case 1 -> {
                int result = display.printSubMenu();
                return result;
            }
            case 2 -> display.printHighScore();
            case 3 -> System.exit(1);
        }
    return 0;
    }
}
