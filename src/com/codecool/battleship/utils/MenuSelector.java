package com.codecool.battleship.utils;

public class MenuSelector {
    public MenuSelector(int option, Display display) {
        switch (option) {
            case 1 -> display.printSubMenu();
            case 2 -> display.printHighScore();
            case 3 -> System.exit(1);
        }
    }
}
