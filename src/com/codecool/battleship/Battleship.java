package com.codecool.battleship;

import com.codecool.battleship.board.Board;
import com.codecool.battleship.board.Square;
import com.codecool.battleship.utils.Display;
import com.codecool.battleship.utils.Input;

import java.util.Arrays;

public class Battleship {
    public static void main(String[] args) {
        Display display = new Display();
        Input input = new Input();
        
        boolean isRunning = true;
        while (isRunning) {
            display.printMenu();
            input.chooseMenu();
            Board board = new Board();
            board.fillBoardWithSquares();
            System.out.println(Arrays.toString(board.getBoard()));
            isRunning = false;
        }
    }

}
