package com.codecool.battleship.game;
import com.codecool.battleship.ship.Ship;
import java.util.List;

public class Player {
    String playerName;
    private List<Ship> ships;

    public Player(String playerName) {

        this.playerName = playerName;
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
