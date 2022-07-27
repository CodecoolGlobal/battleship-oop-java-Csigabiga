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

    public int validateInput(int max, int min, String msg) {
        int option = getUserInput(msg);
        while (option > max || option < min) {
            option = getUserInput("Invalid input, try again!");
        }
        return option;
    }
}
