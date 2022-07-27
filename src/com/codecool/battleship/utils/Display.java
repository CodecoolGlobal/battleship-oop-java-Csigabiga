package com.codecool.battleship.utils;

import com.codecool.battleship.board.Board;
import com.codecool.battleship.board.Square;

public class Display {

    final int ASCII = 96;
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

        StringBuilder boardDisplay = new StringBuilder();
        boardDisplay.append(drawColumnName(boardLength));
        boardDisplay.append("\n");
        boardDisplay.append(drawRows(currentBoard));
        System.out.println(boardDisplay);
    }

    private StringBuilder drawRows(Square[][] currentBoard) {
        int rowCount = 1;
        StringBuilder rows = new StringBuilder();
        for (Square[] row : currentBoard){
            char ch = (char)  (rowCount + ASCII);
            rows.append("  ");
            rows.append(Character.toUpperCase(ch));
            rows.append("  ");
            for(Square cell : row){
                rows.append(cell.getSquareStatus().getCharacter());
                rows.append("  ");
            }
            rows.append("\n");
            rowCount++;
        }
        return rows;
    }

    private StringBuilder drawColumnName(int boardLength) {
        StringBuilder column = new StringBuilder();
        column.append("     ");
        for (int i = 1; i <= boardLength; i++) {
            column.append(i);
            if (i < 9) {
                column.append("  ");
            } else {
                column.append(" ");
            }
        }
        return column;
    }
}

