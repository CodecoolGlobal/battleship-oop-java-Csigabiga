package com.codecool.battleship.utils;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    public static int getUserInput(String msg) {
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

    public static String getCoordinate(String askForCoordinateMsg) {
        System.out.println(Display.AskForCoordinateMsg);
        Scanner sc = new Scanner(System.in);
        String coordinates = sc.nextLine();
        if (validateCoordinate(coordinates)) return coordinates;
        else return "";
    }

    public static boolean validateCoordinate(String coordinate) {
        while (coordinate.length() > 3 || coordinate.length() < 2) {
            coordinate = getCoordinate(Display.InvalidOptionMsg);
        }
        return true;
    }

    public static String getDirection() {

        return "";
    }

    public boolean validateDirection() {
        return true;
    }
}
