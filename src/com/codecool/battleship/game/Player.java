package com.codecool.battleship.game;
import com.codecool.battleship.board.Board;
import com.codecool.battleship.board.Square;
import com.codecool.battleship.board.SquareStatus;
import com.codecool.battleship.ship.Ship;
import com.codecool.battleship.utils.Decoder;
import com.codecool.battleship.utils.Display;
import com.codecool.battleship.utils.Input;

import java.util.ArrayList;
import java.util.List;

public class Player {

    int playerNumber;
    private List<Ship> ships;


    public Player(int playerNumber) {
        this.playerNumber = playerNumber;
    }


    public boolean isAlive() {
        for (int i = 0; i < ships.size(); i++) {
            Ship ship = ships.get(i);
            List<Square> squares = ship.getShipCoordinates();
            for (int j = 0; j < squares.size(); j++) {
                Square square = squares.get(j);
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
    public List<Ship> getPlayerShipList(){
        return this.ships;
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
