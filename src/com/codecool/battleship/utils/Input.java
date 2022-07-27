package com.codecool.battleship.utils;
import java.util.InputMismatchException;
import java.util.Scanner;

import java.util.ArrayList;

public class Input {

//TODO: extract methods below
    public String coordinates() {return "b2";}


    public String direction() {return "up";}


    public ArrayList<Integer> decoder(String coords) {return null;}

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
