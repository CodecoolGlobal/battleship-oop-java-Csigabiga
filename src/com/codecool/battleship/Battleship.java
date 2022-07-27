package com.codecool.battleship;

import com.codecool.battleship.board.Board;
import com.codecool.battleship.utils.Display;
import com.codecool.battleship.utils.Input;
import com.codecool.battleship.utils.MenuSelector;

import java.util.Arrays;

public class Battleship {
    public static void main(String[] args) {
        Display display = new Display();
        Input input = new Input();
        
        boolean isRunning = true;
        while (isRunning) {
            display.printMenu();
            int validatedOption = input.validateInput(3);
            new MenuSelector(validatedOption);

            Board board = new Board(10);
            board.fillBoardWithSquares();
            System.out.println(Arrays.toString(board.getBoard()));
            //TODO delete me after testing
            display.displayOneBoard(board);
            display.displayTwoBoard(board, board);
            isRunning = false;
        }
    }

}
