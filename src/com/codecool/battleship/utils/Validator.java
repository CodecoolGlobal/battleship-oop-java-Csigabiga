package com.codecool.battleship.utils;

import com.codecool.battleship.board.Board;
import com.codecool.battleship.ship.ShipType;

public class Validator {


    public boolean validatePlacement(String direction, ShipType ship, int x, int y, Board board) {
        switch (direction) {
            case "left":
                for (int i = 0; i < ship.getShipLength(); i++) {
                    boolean empty = board.isPlacementOk(x - i, y);
                    if (!empty) {return false;}
                }
                break;
            case "right":
                for (int i = 0; i < ship.getShipLength(); i++) {
                    boolean empty = board.isPlacementOk(x + i, y);
                    if (!empty) {return false;}
                }
                break;
            case "up":
                for (int i = 0; i < ship.getShipLength(); i++) {
                    boolean empty = board.isPlacementOk(x, y + i);
                    if (!empty) {return false;}
                }
                break;
            case "down":
                for (int i = 0; i < ship.getShipLength(); i++) {
                    boolean empty = board.isPlacementOk(x, y - i);
                    if (!empty) {return false;}
                }
        }
        return true;
    }
}
