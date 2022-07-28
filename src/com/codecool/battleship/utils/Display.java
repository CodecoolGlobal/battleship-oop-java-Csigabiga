package com.codecool.battleship.utils;

import com.codecool.battleship.board.Board;
import com.codecool.battleship.board.Square;
import com.codecool.battleship.ship.ShipType;


public class Display {
    final int ASCII = 96;
    String whiteSpaceBetweenObjects = " ".repeat(2);
    String whiteSpaceBetweenBoards = " ".repeat(30);
    private final Input input;
    public final static String ChooseOptionMsg = "Choose an option";
    public final static String InvalidOptionMsg = "Invalid input, try again!";
    public final static String SpecifyBoardSizeMsg = "Specify the board size (5-10)";
    public final static String WelcomeMsg = "Welcome to the Battleship game!";
    public final static String AskForCoordinateMsg = "Define a coordinate e.g.:'A1'";
    public final static String AskForDirectionMsg = "Please type the direction to place your ship. (up, left, down, right)";
    public final static String AskPlayerName = "Please enter your name: ";

    public final static String InvalidPlacement = ColorTerminal.ANSI_RED + "Invalid placement coordination!" + ColorTerminal.ANSI_RESET;

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
            column.append(ColorTerminal.ANSI_YELLOW + i + ColorTerminal.ANSI_RESET);
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
            rows.append(ColorTerminal.ANSI_YELLOW + Character.toUpperCase(ch) + ColorTerminal.ANSI_RESET);
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
            twoBoards.append(ColorTerminal.ANSI_YELLOW + Character.toUpperCase(ch) + ColorTerminal.ANSI_RESET);
            twoBoards.append(whiteSpaceBetweenObjects);
            for (Square square : boardOne[i]) {
                twoBoards.append(square.getSquareStatus().getCharacter());
                twoBoards.append(whiteSpaceBetweenObjects);
            }
            twoBoards.append(" ".repeat(27));
            twoBoards.append(ColorTerminal.ANSI_YELLOW + Character.toUpperCase(ch) + ColorTerminal.ANSI_RESET);
            twoBoards.append(whiteSpaceBetweenObjects);
            for (Square square : boardTwo[i]) {
                twoBoards.append(square.getSquareStatus().getCharacter() == "\uD83D\uDC20"? "🌊" : square.getSquareStatus().getCharacter());
                twoBoards.append(whiteSpaceBetweenObjects);
            }
            twoBoards.append("\n");

        }
        return twoBoards;
    }

    public void printMenu() {
        System.out.println("""
                1. Start Game
                2. High Score
                3. Exit Game""");
    }

    public int printSubMenu() {
        System.out.println("""
                1. Single Player
                2. Multiplayer""");
        int result = input.validateInput(2, 1);
        return result;
    }

    public void printHighScore() {
        System.out.println("High Score");
        printMenu();
    }

    public static void printDisplayField(String message){
        System.out.println(message);
    }

    public void printBoardPlacementQuestion(){
        System.out.println("""
                Would you like to place the ships:
                1. Manually
                2. Automatic random placement""");
    }

    public static void shipTypeAnnouncer(ShipType ship){
        System.out.println(String.format("You are placing a %1$s %2$s %3$s which is %4$s%5$s%6$s long.", ColorTerminal.ANSI_YELLOW , ship, ColorTerminal.ANSI_RESET, ColorTerminal.ANSI_YELLOW, ship.getShipLength(), ColorTerminal.ANSI_RESET));
    }

    public static void wrongCoordinate(){
        System.out.println(InvalidPlacement);
    }

    public void winMessage(String playerName){
        System.out.println(String.format("%1$s YOU HAVE SUCCESSFULLY SET ALL OF THE ENEMY FISH SHIP ON FIRE. GG", playerName));
    }
}