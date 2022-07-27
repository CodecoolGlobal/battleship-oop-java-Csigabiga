package com.codecool.battleship.utils;

import com.codecool.battleship.board.Board;
import com.codecool.battleship.board.Square;

import java.util.Arrays;

public class Display {
    final int ASCII = 96;
    String whiteSpaceBetweenObjects = " ".repeat(2);
    String whiteSpaceBetweenBoards = " ".repeat(30);
    private final Input input;
    public final static String ChooseOptionMsg = "Choose an option";
    public final static String InvalidOptionMsg = "Invalid input, try again!";

    public final static String SpecifyBoardSizeMsg = "Specify the board size (5-10)";
    public final static String WelcomeMsg = "Welcome to the Battleship game!";

    public Display(Input input) {
        this.input = input;
    }

    public void displayOneBoard(Board playerBoard) {
        Square[][] currentBoard = playerBoard.getBoard();
        int boardLength = currentBoard.length;

        String boardDisplay = drawColumnName(boardLength, 5) +
                "\n" +
                drawRows(currentBoard);

        System.out.println(boardDisplay);
    }

    public void displayTwoBoard(Board boardOne, Board boardTwo){
        Square[][] firstBoard = boardOne.getBoard();
        Square[][] secondBoard = boardTwo.getBoard();
        int boardLength = firstBoard.length;
        StringBuilder displayDoubleBoard = new StringBuilder();
        displayDoubleBoard.append(drawColumnName(boardLength, 5));
        displayDoubleBoard.append(whiteSpaceBetweenBoards);
        displayDoubleBoard.append(drawColumnName(boardLength, 1));
        displayDoubleBoard.append("\n");
        displayDoubleBoard.append(drawTwoBoardRows(firstBoard, secondBoard));
        System.out.println(displayDoubleBoard);
    }

    private StringBuilder drawColumnName(int boardLength, int whiteSpaceBeforeNumbers) {
        StringBuilder column = new StringBuilder();
        String whiteSpaces = " ".repeat(whiteSpaceBeforeNumbers);
        column.append(whiteSpaces);
        for (int i = 1; i <= boardLength; i++) {
            column.append(i);
            if (i < 9) {
                column.append(whiteSpaceBetweenObjects);
            } else {
                column.append(" ");
            }
        }
        return column;
    }

    private StringBuilder drawRows(Square[][] currentBoard) {

        int rowCount = 1;
        StringBuilder rows = new StringBuilder();
        for (Square[] row : currentBoard){
            char ch = (char)  (rowCount + ASCII);
            rows.append(whiteSpaceBetweenObjects);
            rows.append(Character.toUpperCase(ch));
            rows.append(whiteSpaceBetweenObjects);
            for(Square square : row){
                rows.append(square.getSquareStatus().getCharacter());
                rows.append(whiteSpaceBetweenObjects);
            }
            rows.append("\n");
            rowCount++;
        }
        return rows;
    }

    private StringBuilder drawTwoBoardRows(Square[][] boardOne, Square[][] boardTwo) {
        StringBuilder twoBoards = new StringBuilder();

        for (int i = 0; i < boardOne.length; i++) {
            char ch = (char) (i + 1 + ASCII);
            twoBoards.append(whiteSpaceBetweenObjects);
            twoBoards.append(Character.toUpperCase(ch));
            twoBoards.append(whiteSpaceBetweenObjects);
            for (Square square : boardOne[i]) {
                twoBoards.append(square.getSquareStatus().getCharacter());
                twoBoards.append(whiteSpaceBetweenObjects);
            }
            twoBoards.append(" ".repeat(27));
            twoBoards.append(Character.toUpperCase(ch));
            twoBoards.append(whiteSpaceBetweenObjects);
            for (Square square : boardTwo[i]) {
                twoBoards.append(square.getSquareStatus().getCharacter());
                twoBoards.append(whiteSpaceBetweenObjects);
            }
            twoBoards.append("\n");

        }
        return twoBoards;
    }

    public void printMenu() {
        System.out.println("""
                Welcome to the Battleship game!
                
                1. Start Game
                2. High Score
                3. Exit Game""");
    }

    public void printSubMenu() {
        System.out.println("""
                1. Single Player
                2. Multiplayer""");
        input.validateInput(2, 1);
        int boardSize = input.validateInput(10, 5);
        Board board = new Board(boardSize);
        board.fillBoardWithSquares();
        System.out.println(Arrays.toString(board.getBoard()));
    }

    public void printHighScore() {
        System.out.println("High Score");
        printMenu();
    }
}