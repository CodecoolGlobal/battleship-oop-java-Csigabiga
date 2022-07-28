package com.codecool.battleship.board;

import com.codecool.battleship.ship.Ship;
import com.codecool.battleship.ship.ShipType;
import com.codecool.battleship.utils.Decoder;
import com.codecool.battleship.utils.Display;
import com.codecool.battleship.utils.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BoardFactory {
    private final Board board;

    public BoardFactory(int size) {
        this.board = new Board(size);
        board.fillBoardWithSquares();
    }

    private Ship randomPlacement(ShipType ship) {
        ArrayList<String> directions = new ArrayList<>(4);
        directions.add("up");
        directions.add("down");
        directions.add("right");
        directions.add("left");
        int index = ThreadLocalRandom.current().nextInt(0, directions.size());
        List<Square> squareList = new ArrayList<>();
        boolean empty = false;
        while (!empty) {
            int x = ThreadLocalRandom.current().nextInt(0, this.board.getBoardSize());
            int y = ThreadLocalRandom.current().nextInt(0, this.board.getBoardSize());
            empty = board.isPlacementOk(x, y);
            if (empty) {
                if (ship == ShipType.Destroyer) {
                    board.changeStatus(x, y, SquareStatus.SHIP);
                    squareList.add(board.getBoard()[x][y]);

                } else {
                    String direction = directions.get(index);
                    if (!validatePlacement(direction, ship, x, y)) {
                        empty = false;
                    } else {
                        int modifier = 0;
                        for (int i = 0; i < ship.getShipLength(); i++) {
                            switch (direction) {
                                case "up":
                                    board.changeStatus(x - modifier, y, SquareStatus.SHIP);
                                    squareList.add(board.getBoard()[x-modifier][y]);
                                    break;
                                case "down":
                                    board.changeStatus(x + modifier, y, SquareStatus.SHIP);
                                    squareList.add(board.getBoard()[x+modifier][y]);
                                    break;
                                case "right":
                                    board.changeStatus(x, y + modifier, SquareStatus.SHIP);
                                    squareList.add(board.getBoard()[x][y+modifier]);
                                    break;
                                case "left":
                                    board.changeStatus(x, y - modifier, SquareStatus.SHIP);
                                    squareList.add(board.getBoard()[x][y-modifier]);
                                    break;

                            }
                            modifier++;
                        }
                    }
                }
            }
        }
        return new Ship(ship, squareList);
    }


    private Ship manualPlacement(ShipType ship) {
        boolean succes = false;
        List<Square> squareList = new ArrayList<>();
        while (!succes) {
            Display.shipTypeAnnouncer(ship);
            ArrayList<Integer> coordinates = Decoder.decoder(Input.getCoordinate(Display.AskForCoordinateMsg), board.getBoardSize());
            int x = coordinates.get(0);
            int y = coordinates.get(1);
            boolean empty = board.isPlacementOk(x, y);
            if (!empty) {
                succes = false;
            }
            if (ship == ShipType.Destroyer) {
                board.changeStatus(x, y, SquareStatus.SHIP);
                squareList.add(board.getBoard()[x][y]);
                succes = true;
            } else {
                String direction = Input.getDirection(Display.AskForDirectionMsg);
                if (!validatePlacement(direction, ship, x, y)) {
                    succes = false;
                } else {
                    int modifier = 0;
                    for (int i = 0; i < ship.getShipLength(); i++) {
                        switch (direction) {
                            case "up":
                                board.changeStatus(x - modifier, y, SquareStatus.SHIP);
                                squareList.add(board.getBoard()[x-modifier][y]);
                            case "down":
                                board.changeStatus(x + modifier, y, SquareStatus.SHIP);
                                squareList.add(board.getBoard()[x+modifier][y]);
                            case "right":
                                board.changeStatus(x, y + modifier, SquareStatus.SHIP);
                                squareList.add(board.getBoard()[x][y+modifier]);
                            case "left":
                                board.changeStatus(x, y - modifier, SquareStatus.SHIP);
                                squareList.add(board.getBoard()[x][y-modifier]);
                        }
                        modifier++;
                    }
                }
                Display.wrongCoordinate();
            }
        }
        return new Ship(ship, squareList);
    }

    public Board getBoard() {
        return board;
    }


    public Ship placement(int placementType, ShipType ship) {
        if (placementType == 1) {
            return manualPlacement(ship);
        } else {
            return randomPlacement(ship);
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