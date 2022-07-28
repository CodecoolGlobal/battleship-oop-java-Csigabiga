package com.codecool.battleship.game;
import com.codecool.battleship.ship.Ship;
import com.codecool.battleship.utils.Decoder;
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
        // TODO iterate through all of the ship coordinates
        return true;
    }

    public void addShipToList(Ship ship) {
        ships.add(ship);
    }
    public List<Ship> getPlayerShipList(){
        return this.ships;
    }


    public boolean shoot(Board board) {
        ArrayList<Integer> coordinates = Decoder.decoder(Input.coordinates());
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
