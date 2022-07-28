package com.codecool.battleship.game;

import com.codecool.battleship.ship.ShipType;
import com.codecool.battleship.utils.Display;
import com.codecool.battleship.utils.Input;

public class Game {


    private Player PlayerOne;

    private Player PlayerTwo;
    private final Input input;

    private final Display display;

    public Game(Input input, Display display) {
        this.input = input;
        this.display = display;


    }


    public void gameLoopDemo(int boardSize) {
        Player playerOne = createDemoPlayer(boardSize);
        Player playerTwo = createDemoPlayer(boardSize);
        boolean gameIsWon = false;
        Player currentPlayer = playerOne;
        Player enemyPlayer = playerTwo;
        while(!gameIsWon){
            display.displayTwoBoard(currentPlayer.getPlayerBoardFactory().getBoard(), enemyPlayer.getPlayerBoardFactory().getBoard());
            currentPlayer.manualShoot(enemyPlayer.getPlayerBoardFactory().getBoard());
            if(!enemyPlayer.isAlive()){
                gameIsWon = true;
            }


            if(currentPlayer == playerOne){
                currentPlayer = playerTwo;
                enemyPlayer = playerOne;
            }
            else{
                currentPlayer = playerOne;
                enemyPlayer = playerTwo;
            }
        }
        display.winMessage(currentPlayer.getPlayerName());
    }



    public void gameLoopAi(int boardSize) {
        Player playerOne = createPlayer(boardSize);
        Player playerTwo = createAi(boardSize);
        boolean gameIsWon = false;
        while(!gameIsWon){
            playerOne.manualShoot(playerTwo.getPlayerBoardFactory().getBoard());
            display.displayTwoBoard(playerOne.getPlayerBoardFactory().getBoard(), playerTwo.getPlayerBoardFactory().getBoard());
            if(!playerTwo.isAlive()){
                gameIsWon = true;
                display.winMessage(playerOne.getPlayerName());
            }
            playerTwo.randomShoot(playerOne.getPlayerBoardFactory().getBoard());
            if(!playerOne.isAlive()){
                gameIsWon = true;
                display.winMessage(playerTwo.getPlayerName());
            }

        }
    }


    public void gameLoop(int boardSize) {
        Player playerOne = createPlayer(boardSize);
        Player playerTwo = createPlayer(boardSize);
        boolean gameIsWon = false;
        Player currentPlayer = playerOne;
        Player enemyPlayer = playerTwo;
        while(!gameIsWon){
            Display.clearScreen();
            display.displayTwoBoard(currentPlayer.getPlayerBoardFactory().getBoard(), enemyPlayer.getPlayerBoardFactory().getBoard());
            currentPlayer.manualShoot(enemyPlayer.getPlayerBoardFactory().getBoard());
            if(!enemyPlayer.isAlive()){
                gameIsWon = true;
            }


            if(currentPlayer == playerOne){
                currentPlayer = playerTwo;
                enemyPlayer = playerOne;
            }
            else{
                currentPlayer = playerOne;
                enemyPlayer = playerTwo;
            }
        }
        display.winMessage(currentPlayer.getPlayerName());
    }

    private Player createPlayer(int boardSize) {
        Display.clearScreen();
        Player playerClass = new Player(input.getPlayerName(Display.AskPlayerName), boardSize);
        Display.clearScreen();
        display.printBoardPlacementQuestion();
        int placementAnswer = input.validateInput(2, 1);
        Display.clearScreen();
        for (int i = 0; i < ShipType.values().length;i++){
            display.displayOneBoard(playerClass.getPlayerBoardFactory().getBoard());
            playerClass.addShipToList(playerClass.getPlayerBoardFactory().placement(placementAnswer, ShipType.values()[i]));
            Display.clearScreen();
        }
        display.displayOneBoard(playerClass.getPlayerBoardFactory().getBoard());

        return playerClass;
    }


    private Player createAi(int boardSize) {
        Player playerClass = new Player("Ai", boardSize);
        for (int i = 0; i < ShipType.values().length;i++){
            display.displayOneBoard(playerClass.getPlayerBoardFactory().getBoard());
            playerClass.addShipToList(playerClass.getPlayerBoardFactory().placement(2, ShipType.values()[i]));
        }

        return playerClass;
    }


    private Player createDemoPlayer(int boardSize) {
        Player playerClass = new Player(input.getPlayerName(Display.AskPlayerName), boardSize);
        display.printBoardPlacementQuestion();
        int placementAnswer = input.validateInput(2, 1);
        for (int i = 4; i < ShipType.values().length;i++){
            display.displayOneBoard(playerClass.getPlayerBoardFactory().getBoard());
            playerClass.addShipToList(playerClass.getPlayerBoardFactory().placement(placementAnswer, ShipType.values()[i]));
        }
        display.displayOneBoard(playerClass.getPlayerBoardFactory().getBoard());

        return playerClass;
    }
}
