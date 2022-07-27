package com.codecool.battleship.utils;

import com.codecool.battleship.board.Board;
import com.codecool.battleship.board.Square;

public class Display {
    public void printMenu() {
        System.out.println("""
                Welcome to the BattleShip game!
                Choose an option!
                1. Start Game
                2. Highscores
                3. Exit Game""");

    }
    public void displayOneBoard(Board playerBoard) {
        Square[][] currentBoard = playerBoard.getBoard();
        int boardLength = currentBoard.length;
        final int ASCII = 96;
        StringBuilder boardDisplay = new StringBuilder();
        boardDisplay.append("     ");
        for (int i = 1; i <= boardLength; i++) {
            boardDisplay.append(i);
            if (i < 9) {
                boardDisplay.append("  ");
            } else {
                boardDisplay.append(" ");
            }
        }
        boardDisplay.append("\n");
        int rowCount = 1;
        for (Square[] row : currentBoard){
            char ch = (char)  (rowCount + ASCII);
            boardDisplay.append("   ");
            boardDisplay.append(Character.toUpperCase(ch));
            boardDisplay.append("\n");
            rowCount++;
        }
        System.out.println(boardDisplay);
    }
}
