package com.codecool.battleship.utils;

import com.codecool.battleship.board.Board;

import java.util.Arrays;

public class Display {
    private final Input input;

    public final static String ChooseOptionMsg = "Choose an option";
    public final static String InvalidOptionMsg = "Invalid input, try again!";

    public final static String SpecifyBoardSizeMsg = "Specify the board size (5-10)";
    public final static String WelcomeMsg = "Welcome to the Battleship game!";

    public Display(Input input) {
        this.input = input;
    }

    public void printMenu() {
        System.out.println(WelcomeMsg);
        System.out.println("""
                1. Start Game
                2. High Score
                3. Exit Game""");
    }

    public void printSubMenu() {
        System.out.println("""
                1. Single Player
                2. Multiplayer""");
        input.validateInput(2, 1);
        input.getUserInput(SpecifyBoardSizeMsg);
        input.validateInput(10, 5);
    }

    public void printHighScore() {
        System.out.println("High Score");
        printMenu();
    }
}
