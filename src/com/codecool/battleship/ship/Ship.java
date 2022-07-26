package com.codecool.battleship.ship;

import com.codecool.battleship.board.*;

import java.util.List;

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
