package com.codecool.battleship.board;

public class Board {


    public Square[][] ocean;

    public boolean isPlacementOk() {
        //TODO implement placement validation
        return true;
    }

    public Board(int size) {
        this.ocean = new Square[size][size];

    }
    public void fillBoardWithSquares() {
        for (int i= 0; i < ocean.length; i++){
            for (int j = 0; j < ocean.length; j++) {
                ocean[i][j] = new Square(i,j);
            }
        }
    }
    //todo DELETE ME AFTER TESTING
    public Square[][] getBoard(){
        return this.ocean;
    }


}

