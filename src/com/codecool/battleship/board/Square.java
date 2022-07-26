package com.codecool.battleship.board;

public class Square {
    private int x;
    private int y;
    private SquareStatus squareStatus;


    public Square(int x, int y) {
        this.x = x;
        this.y = y;
        this.squareStatus = SquareStatus.EMPTY;
    }

    public SquareStatus getSquareStatus() {
        return squareStatus;
    }
}
