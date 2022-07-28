package com.codecool.battleship.game;

import com.codecool.battleship.ship.ShipType;
import com.codecool.battleship.utils.Display;
import com.codecool.battleship.utils.Input;

public class Game {


    private Player PlayerOne;

    private Player PlayerTwo;
    private final Input input;

    private final Display display;

    public Game(Input input, Display display){
        this.input = input;
        this.display = display;


    }

    public void gameLoop(int boardSize){
        Player playerOne = createPlayer(boardSize);
        Player playerTwo = createPlayer(boardSize);
        boolean gameIsWon = false;
        Player currentPlayer = playerOne;
        Player enemyPlayer = playerTwo;
        while(!gameIsWon){
            currentPlayer.shoot(enemyPlayer.getPlayerBoardFactory().getBoard());
            display.displayTwoBoard(currentPlayer.getPlayerBoardFactory().getBoard(), enemyPlayer.getPlayerBoardFactory().getBoard());
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
        //TODO win message with current player
    }

    private Player createPlayer(int boardSize) {
        Player playerClass = new Player(input.getPlayerName(Display.AskPlayerName), boardSize);
        display.printBoardPlacementQuestion();
        int placementAnswer = input.validateInput(2, 1);
        for (int i = 0; i < ShipType.values().length;i++){
            display.displayOneBoard(playerClass.getPlayerBoardFactory().getBoard());
            playerClass.addShipToList(playerClass.getPlayerBoardFactory().placement(placementAnswer, ShipType.values()[i]));
        }
        display.displayOneBoard(playerClass.getPlayerBoardFactory().getBoard());

        return playerClass;
    }
}
