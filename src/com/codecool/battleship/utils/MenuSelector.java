package com.codecool.battleship.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuSelector {
    Display display = new Display();

    public MenuSelector(int option) {
        switch (option) {
            case 1 -> display.printSubMenu();
            case 2 -> display.printHighScore();
            case 3 -> System.exit(1);
        }
    }
}
