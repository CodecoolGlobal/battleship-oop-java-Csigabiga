package com.codecool.battleship;

import com.codecool.battleship.board.Board;
import com.codecool.battleship.utils.Display;
import com.codecool.battleship.utils.Input;
import com.codecool.battleship.utils.MenuSelector;

import java.util.Arrays;

public class Battleship {
    public static void main(String[] args) {
        Input input = new Input();
        Display display = new Display(input);

        boolean isRunning = true;
        while (isRunning) {
            display.printMenu();
            int validatedOption = input.validateInput(3, 1);
            new MenuSelector(validatedOption, display);

            Board board = new Board(10);
            board.fillBoardWithSquares();
            //TODO delete me after testing
            System.out.println(Arrays.toString(board.getBoard()));
            display.displayOneBoard(board);
            display.displayTwoBoard(board, board);

            isRunning = false;
        }
    }
}