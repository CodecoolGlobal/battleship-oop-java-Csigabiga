package com.codecool.battleship.utils;

public class Display {
    public void printMenu() {
        System.out.println("""
                Welcome to the Battleship game!
                
                Choose an option!
                1. Start Game
                2. High Score
                3. Exit Game""");
    }

    public void printSubMenu() {
        System.out.println("""
                Choose an option!
                1. Single Player
                2. Multiplayer""");
    }

    public void printHighScore() {
        System.out.println("High Score");
    }
}
