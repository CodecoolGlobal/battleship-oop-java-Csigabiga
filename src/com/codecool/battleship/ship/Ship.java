package com.codecool.battleship.ship;

import com.codecool.battleship.board.*;

import java.util.List;

public class Ship {
    private ShipType shipType;
    private List<Square> shipCoordinates;

    public Ship(ShipType ship, List<Square> shipCoordinates) {
        this.shipType = ship;
        this.shipCoordinates = shipCoordinates;
    }


    public void listAdder(Square square) {
        shipCoordinates.add(square);
    }


    public ShipType getShipType() {
        return shipType;
    }


    public void setShipType(ShipType shipType) {
        this.shipType = shipType;
    }


    public List<Square> getShipCoordinates() {
        return shipCoordinates;
    }
}
