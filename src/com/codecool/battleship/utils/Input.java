package com.codecool.battleship.utils;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    public int chooseOption() {
        try {
            Scanner sc = new Scanner(System.in);
            return sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Not a number");
            return 0;
        }
    }

    public int validateInput(int possibleOptions) {
        int option = chooseOption();
        while (option > possibleOptions || option <= 0) {
            System.out.println("Invalid input, try again!");
            option = chooseOption();
        }
        return option;
    }
}
