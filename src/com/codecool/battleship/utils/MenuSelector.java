package com.codecool.battleship.utils;

public class MenuSelector {
    private final Display display;
    public MenuSelector(Display display) {
        this.display = display;
    }

    public MenuSelector(int option, Display display) {
        this.display = display;
        switch (option) {
            case 1 -> this.display.printSubMenu();
            case 2 -> this.display.printHighScore();
            case 3 -> System.exit(1);
        }
    }
}
