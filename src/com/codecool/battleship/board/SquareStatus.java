package com.codecool.battleship.board;

public enum SquareStatus {


    EMPTY("\uD83C\uDF0A"),
    SHIP("\uD83D\uDC20"),
    HIT("\uD83D\uDCA5"),
    MISS("M");


    private final String fieldName;


    SquareStatus(String symbol){
        fieldName = symbol;
    }


    public String getCharacter() {
        return fieldName;
    }
}

