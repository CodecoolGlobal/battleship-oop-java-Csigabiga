package com.codecool.battleship.utils;

import com.codecool.battleship.board.Board;

import java.util.Arrays;

public class Display {
    Input input = new Input();
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
        input.validateInput(2, 1, "Choose an option!");
        int boardSize = input.validateInput(10, 5, "Specify the board size (5-10)");
        Board board = new Board(boardSize);
        board.fillBoardWithSquares();
        System.out.println(Arrays.toString(board.getBoard()));
    }

    public void printHighScore() {
        System.out.println("High Score");
        printMenu();
    }
}
