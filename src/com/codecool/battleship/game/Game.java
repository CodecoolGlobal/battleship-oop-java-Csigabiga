package com.codecool.battleship.game;

import com.codecool.battleship.board.Board;
import com.codecool.battleship.board.BoardFactory;
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
    }

    private Player createPlayer(int boardSize) {
        Player playerClass = new Player(input.getPlayerName(Display.AskPlayerName), boardSize);
        display.printBoardPlacementQuestion();
        int placementAnswer = input.validateInput(2, 1);
        for (int i = 0; i < ShipType.values().length;i++){
            display.displayOneBoard(playerClass.getPlayerBoardFactory().getBoard());
            playerClass.getPlayerBoardFactory().placement(placementAnswer, ShipType.values()[i]);
        }
        display.displayOneBoard(playerClass.getPlayerBoardFactory().getBoard());

        return playerClass;
    }
}
