package com.codecool.battleship.board;

import com.codecool.battleship.ship.ShipType;
import com.codecool.battleship.utils.Decoder;
import com.codecool.battleship.utils.Display;
import com.codecool.battleship.utils.Input;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class BoardFactory {

    private final Board board;

    public BoardFactory(int size) {
        this.board = new Board(size);
        board.fillBoardWithSquares();
    }

    private void randomPlacement(ShipType ship) {
        ArrayList<String> directions = new ArrayList<String>(4);
        directions.add("up");
        directions.add("down");
        directions.add("right");
        directions.add("left");
        int index = ThreadLocalRandom.current().nextInt(0, directions.size());
        boolean empty = false;
        while (!empty) {
            int x = ThreadLocalRandom.current().nextInt(0, this.board.getBoardSize() + 1);
            int y = ThreadLocalRandom.current().nextInt(0, this.board.getBoardSize() + 1);
            empty = board.isPlacementOk(x, y);
            if (empty) {
                if (ship == ShipType.Destroyer) {
                    board.changeStatus(x, y, SquareStatus.SHIP);
                } else {
                    String direction = directions.get(index);
                    if (!validatePlacement(direction, ship, x, y)) {
                        empty = false;
                    } else {
                        int modifier = 0;
                        for (int i = 0; i < ship.getShipLength(); i++) {
                            switch (direction) {
                                case "up" -> board.changeStatus(x - modifier, y, SquareStatus.SHIP);
                                case "down" -> board.changeStatus(x + modifier, y, SquareStatus.SHIP);
                                case "right" -> board.changeStatus(x, y + modifier, SquareStatus.SHIP);
                                case "left" -> board.changeStatus(x, y - modifier, SquareStatus.SHIP);
                            }
                            modifier++;
                        }
                    }
                }
            }
        }
    }


    private boolean manualPlacement(ShipType ship) {
        Display.shipTypeAnnouncer(ship);
        ArrayList<Integer> coordinates = Decoder.decoder(Input.getCoordinate(Display.AskForCoordinateMsg), board.getBoardSize());
        int x = coordinates.get(0);
        int y = coordinates.get(1);
        boolean empty = board.isPlacementOk(x, y);
        if (!empty) {
            return false;
        }
        if (ship == ShipType.Destroyer) {
            board.changeStatus(x, y, SquareStatus.SHIP);
        } else {
            String direction = Input.direction();
            if (!validatePlacement(direction, ship, x, y)) {
                return false;
            }
            int modifier = 0;
            for (int i = 0; i < ship.getShipLength(); i++) {
                switch (direction) {
                    case "up" -> board.changeStatus(x - modifier, y, SquareStatus.SHIP);
                    case "down" -> board.changeStatus(x + modifier, y, SquareStatus.SHIP);
                    case "right" -> board.changeStatus(x, y + modifier, SquareStatus.SHIP);
                    case "left" -> board.changeStatus(x, y - modifier, SquareStatus.SHIP);
                }
                modifier++;
            }
        }
        return true;

    }



    public Board getBoard() {
        return board;
    }


    public void placement(int placementType, ShipType ship) {
        if (placementType == 1) {
            manualPlacement(ship);
        } else {
            randomPlacement(ship);
        }
    }


    private boolean validatePlacement(String direction, ShipType ship, int x, int y) {
        switch (direction) {
            case "up":
                for (int i = 0; i < ship.getShipLength(); i++) {
                    if (x - i < 0) {return false;}
                    boolean empty = board.isPlacementOk(x - i, y);
                    if (!empty) {return false;}
                }
                break;
            case "down":
                for (int i = 0; i < ship.getShipLength(); i++) {
                    if (x + i > board.getBoardSize()-1) {return false;}
                    boolean empty = board.isPlacementOk(x + i, y);
                    if (!empty) {return false;}
                }
                break;
            case "right":
                for (int i = 0; i < ship.getShipLength(); i++) {
                    if (y + i > board.getBoardSize()-1) {return false;}
                    boolean empty = board.isPlacementOk(x, y + i);
                    if (!empty) {return false;}
                }
                break;
            case "left":
                for (int i = 0; i < ship.getShipLength(); i++) {
                    if (y - i < 0) {return false;}
                    boolean empty = board.isPlacementOk(x, y - i);
                    if (!empty) {return false;}
                }
        }
        return true;
    }
}