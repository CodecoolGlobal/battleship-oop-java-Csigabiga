package com.codecool.battleship.board;

public class Board {


    public Square[][] ocean;

    public boolean isPlacementOk() {
        return true;
    }

    public Board() {
        this.ocean = new Square[10][10];

    }
    public void fillBoardWithSquares() {
        for (int i= 0; i < 10; i++){
            for (int j = 0; j < 10; j++) {
                ocean[i][j] = new Square(i,j);
            }
        }
    }
    //todo DELETE ME AFTER TESTING
    public Square[][] getBoard(){
        return this.ocean;
    }


}

