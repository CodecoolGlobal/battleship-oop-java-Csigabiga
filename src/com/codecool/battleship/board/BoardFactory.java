package com.codecool.battleship.board;

public class BoardFactory {

    private final Board board;

    public BoardFactory() {
        this.board = new Board();
        board.fillBoardWithSquares();
    }

    public void randomPlacement() {}


    public void manualPlacement() {}
}



    public Board board() {
        return board;
    }


    public Board placement(String type, ShipType ship) {
        if (type.equals("manual")) {
            manualPlacement(ship);
        } else {
            randomPlacement();
        }
        return board;
    }
}