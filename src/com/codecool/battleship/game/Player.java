package com.codecool.battleship.game;
import com.codecool.battleship.board.Board;
import com.codecool.battleship.board.BoardFactory;
import com.codecool.battleship.board.Square;
import com.codecool.battleship.board.SquareStatus;
import com.codecool.battleship.ship.Ship;
import com.codecool.battleship.utils.Decoder;
import com.codecool.battleship.utils.Display;
import com.codecool.battleship.utils.Input;

import java.util.ArrayList;
import java.util.List;

public class Player {
    String playerName;

    private BoardFactory board;
    private List<Ship> ships;

    public Player(String playerName, int boardSize) {
        this.board = new BoardFactory(boardSize);
        this.playerName = playerName;
    }

    public boolean isAlive() {
        for (Ship ship : ships) {
            List<Square> squares = ship.getShipCoordinates();
            for (Square square : squares) {
                if (square.getSquareStatus() != SquareStatus.HIT) {
                    return true;
                }
            }
        }
        return false;
    }

//            for (int i = 0; i < ships.size(); i++) {
//        Ship ship = ships.get(i);
//        List<Square> squares = ship.getShipCoordinates();
//        for (int j = 0; j < squares.size(); j++) {
//            Square square = squares.get(j);
//            if (square.getSquareStatus() != SquareStatus.HIT) {
//                return true;
//            }
//        }
//    }
//        return false;
//}

    public void addShipToList(Ship ship) {
        ships.add(ship);
    }
    public List<Ship> getPlayerShipList() {
        return this.ships;
    }
    public BoardFactory getPlayerBoardFactory() {
        return this.board;
    }


    public boolean shoot(Board board) {
        ArrayList<Integer> coordinates = Decoder.decoder(Input.getCoordinate(Display.AskForCoordinateMsg), board.getBoardSize());
        int x = coordinates.get(0);
        int y = coordinates.get(1);
        SquareStatus state = board.squareStatus(x, y);
        switch (state) {
            case EMPTY:
                board.changeStatus(x, y, SquareStatus.MISS);
                return true;
            case SHIP:
                board.changeStatus(x, y, SquareStatus.HIT);
                return true;
            case HIT:
            case MISS:
                return false;
        }
        return false;
    }
}
