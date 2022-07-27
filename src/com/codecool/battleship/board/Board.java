package com.codecool.battleship.board;

public class Board {

    //TODO: change public fields to private
    int boardSize;
    public Square[][] ocean;

    public boolean isPlacementOk() {
        return true;
    }

    public Board(int size) {
        this.boardSize = size;
        this.ocean = new Square[size][size];

    }
    public void fillBoardWithSquares() {
        for (int i= 0; i < boardSize; i++){
            for (int j = 0; j < boardSize; j++) {
                ocean[i][j] = new Square(i,j);
            }
        }
    }
    //todo DELETE ME AFTER TESTING
    public Square[][] getBoard(){
        return this.ocean;
    }

    public int getBoardSize() {
        return boardSize;
    }

}

