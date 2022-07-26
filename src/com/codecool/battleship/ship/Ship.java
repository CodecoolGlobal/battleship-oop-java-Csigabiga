package com.codecool.battleship.ship;

public class Ship {
    private String shipType;
    private List<Square> shipCoordinates;


    public String getShipType() {
        return shipType;
    }


    public void setShipType(String shipType) {
        this.shipType = shipType;
    }


    public List<Square> getShipCoordinates() {
        return shipCoordinates;
    }
}
