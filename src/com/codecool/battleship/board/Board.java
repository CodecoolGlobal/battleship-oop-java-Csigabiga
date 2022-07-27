package com.codecool.battleship.board;


public class Board {
    private int boardSize;

    public Board(int size) {
        this.boardSize = size;
        this.ocean = new Square[size][size];

    }

    private final Square[][] ocean;


    public boolean isPlacementOk(int x, int y) {
        SquareStatus status = ocean[x][y].getSquareStatus();
        return status == SquareStatus.EMPTY;
    }


    public void changeStatus (int x, int y, SquareStatus status) {
        ocean[x][y].setSquareStatus(status);
    }

    public void fillBoardWithSquares() {

        for (int i= 0; i < boardSize; i++){
            for (int j = 0; j < boardSize; j++) {
                ocean[i][j] = new Square(i,j);
            }
        }
    }

    public int getBoardSize() {
        return boardSize;
    }

    public Square[][] getBoard(){
        return this.ocean;
    }

}

