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
import java.util.concurrent.ThreadLocalRandom;

public class Player {
    String playerName;

    private BoardFactory board;
    private List<Ship> ships;

    public Player(String playerName, int boardSize) {
        this.board = new BoardFactory(boardSize);
        this.playerName = playerName;

        this.ships = new ArrayList<>();
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


    public void addShipToList(Ship ship) {
        ships.add(ship);
    }
    public List<Ship> getPlayerShipList() {
        return this.ships;
    }
    public BoardFactory getPlayerBoardFactory() {
        return this.board;
    }


    public boolean manualShoot(Board board) {
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


    public boolean randomShoot(Board board) {
        int x = ThreadLocalRandom.current().nextInt(0, board.getBoardSize());
        int y = ThreadLocalRandom.current().nextInt(0, board.getBoardSize());
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
