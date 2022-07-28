package com.codecool.battleship.game;
import com.codecool.battleship.ship.Ship;
import java.util.List;

public class Player {
    int playerNumber;
    String playerName;
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
}
