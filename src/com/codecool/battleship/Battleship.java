package com.codecool.battleship;

import com.codecool.battleship.board.Board;
import com.codecool.battleship.board.BoardFactory;
import com.codecool.battleship.utils.Decoder;
import com.codecool.battleship.utils.Display;
import com.codecool.battleship.utils.Input;
import com.codecool.battleship.utils.MenuSelector;

import java.util.Arrays;

public class Battleship {
    public static void main(String[] args) {
        Input input = new Input();
        Display display = new Display(input);
        Decoder decoder = new Decoder(input);

        boolean isRunning = true;
        while (isRunning) {
            display.printDisplayField(Display.WelcomeMsg);
            display.printMenu();
            int validatedOption = input.validateInput(3, 1);
            new MenuSelector(validatedOption, display);

            BoardFactory board = new BoardFactory(10);
            // TODO temp fix for running the Battleship.java
            Board gameBoard = board.getBoard();
            System.out.println(Arrays.toString(gameBoard.getBoard()));
            display.displayOneBoard(gameBoard);
            display.displayTwoBoard(gameBoard, gameBoard);

            isRunning = false;
        }
    }
}