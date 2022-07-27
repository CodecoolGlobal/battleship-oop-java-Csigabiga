package com.codecool.battleship.utils;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    public int getUserInput(String msg) {
        try {
            System.out.println(msg);
            Scanner sc = new Scanner(System.in);
            return sc.nextInt();
        } catch (InputMismatchException e) {
            return 0;
        }
    }

    public int validateInput(int max, int min) {
        int option = getUserInput(Display.ChooseOptionMsg);
        while (option > max || option < min) {
            option = getUserInput(Display.InvalidOptionMsg);
        }
        return option;
    }
}
