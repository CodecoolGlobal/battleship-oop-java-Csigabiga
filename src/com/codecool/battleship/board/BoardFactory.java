package com.codecool.battleship.board;

import com.codecool.battleship.ship.ShipType;
import com.codecool.battleship.utils.Input;
import com.codecool.battleship.utils.Validator;

import java.util.ArrayList;

public class BoardFactory {

    private final Board board;

    public BoardFactory() {
        this.board = new Board();
        board.fillBoardWithSquares();
    }

    private void randomPlacement() {}


    private boolean manualPlacement(ShipType ship) {
        ArrayList<Integer> coordinates = Input.decoder(Input.coordinates());
        int x = coordinates.get(0);
        int y = coordinates.get(1);
        boolean empty = board.isPlacementOk(x, y);
        if (!empty) {
            return false;
        } else {
            if (ship == ShipType.Destroyer) {
                board.changeStatus(x, y, SquareStatus.SHIP);
            } else {
                String direction = Input.direction();
                if (!Validator.validatePlacement(direction, ship, x, y, board)) {
                    return false;
                }
                for (int i = 0; i < ship.getShipLength() + 1; i++) {
                    int modifier = 0;
                    switch (direction) {
                        case "left" -> board.changeStatus(x - modifier, y, SquareStatus.SHIP);
                        case "right" -> board.changeStatus(x + modifier, y, SquareStatus.SHIP);
                        case "up" -> board.changeStatus(x, y + modifier, SquareStatus.SHIP);
                        case "down" -> board.changeStatus(x, y - modifier, SquareStatus.SHIP);
                    }
                    modifier++;
                }
            }
            return true;
        }
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