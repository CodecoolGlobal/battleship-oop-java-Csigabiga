package com.codecool.battleship.utils;
import java.util.*;

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

    public static int validateInput(int max, int min) {
        int option = getUserInput(Display.ChooseOptionMsg);
        while (option > max || option < min) {
            option = getUserInput(Display.InvalidOptionMsg);
        }
        return option;
    }
    public String getPlayerName(String msg){
        System.out.println(msg);
        Scanner playerName = new Scanner(System.in);
        return playerName.nextLine();

    }

    public static String getCoordinate(String askForCoordinateMsg) {
        System.out.println(Display.AskForCoordinateMsg);
        Scanner sc = new Scanner(System.in);
        String coordinates = sc.nextLine();
        return (validateCoordinate(coordinates));
    }

    public static String validateCoordinate(String coordinate) {
        while (coordinate.length() > 3 || coordinate.length() < 2) {
            coordinate = getCoordinate(Display.InvalidOptionMsg);
        }
        return coordinate;
    }

    public static String getDirection(String msg) {
        System.out.println(Display.AskForDirectionMsg);
        Scanner scanner = new Scanner(System.in);
        String direction = scanner.nextLine().toLowerCase();
        return validateDirection(direction);
    }

    public static String validateDirection(String direction) {
        ArrayList<String> directions = new ArrayList<String>(Arrays.asList("up", "down", "right", "left"));

        while (!directions.contains(direction)) {
            direction = getDirection(Display.AskForCoordinateMsg);
        }
        return direction;
    }
}
