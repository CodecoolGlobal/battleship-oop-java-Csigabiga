package com.codecool.battleship.game;

import com.codecool.battleship.board.Board;
import com.codecool.battleship.board.BoardFactory;
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
        Board playerOneBoard = new BoardFactory(boardSize).getBoard();
        Board playerTwoBoard = new BoardFactory(boardSize).getBoard();
        Player playerOne = createPlayer();
        Player playerTwo = createPlayer();



    }

    private Player createPlayer(){

        return new Player(input.getPlayerName(Display.AskPlayerName));
    }

}
