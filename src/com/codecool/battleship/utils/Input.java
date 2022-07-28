package com.codecool.battleship.utils;
import java.util.InputMismatchException;
import java.util.Scanner;

import java.util.ArrayList;

public class Input {

//TODO: extract methods below
    public static String coordinates() {return "b2";}


    public static String direction() {return "up";}


    // TODO make better method name
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
    public String getPlayerName(String msg){
        System.out.println(msg);
        Scanner playerName = new Scanner(System.in);
        return playerName.nextLine();

    }
}
