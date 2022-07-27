package com.codecool.battleship.board;

public enum SquareStatus {


    EMPTY('.'),
    SHIP('S'),
    HIT('H'),
    MISS('M');


    private final char fieldName;


    SquareStatus(char symbol){
        fieldName = symbol;
    }


    public char getCharacter() {
        return fieldName;
    }
}

