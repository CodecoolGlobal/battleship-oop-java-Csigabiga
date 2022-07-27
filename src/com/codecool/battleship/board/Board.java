package com.codecool.battleship.board;


public class Board {


    private final Square[][] ocean;


    public boolean isPlacementOk(int x, int y) {
        SquareStatus status = ocean[x][y].getSquareStatus();
        return status == SquareStatus.EMPTY;
    }


    public void changeStatus (int x, int y, SquareStatus status) {
        ocean[x][y].setSquareStatus(status);
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
}

