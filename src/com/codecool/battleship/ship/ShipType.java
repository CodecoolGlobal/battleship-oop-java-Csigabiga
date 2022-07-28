package com.codecool.battleship.ship;

public enum ShipType {
//    Carrier(5),
//    Battleship(4),
//    Cruiser(3),
    Submarine(2),
    Destroyer(1);


    private final int shipLength;

    ShipType(int length){
        shipLength = length;
    }

    public int getShipLength() {
        return shipLength;
    }
}
