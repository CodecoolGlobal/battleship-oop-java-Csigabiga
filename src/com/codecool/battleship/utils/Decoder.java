package com.codecool.battleship.utils;

import java.util.ArrayList;
import java.util.Arrays;

public class Decoder {
    private static final int ASCII = 96;
    private final Input input;

    public Decoder(Input input) {
        this.input = input;
    }


    public static ArrayList<Integer> decoder(String coordinate, int boardSize) {
        ArrayList<Integer> validatedCoordinates = new ArrayList<>();
        int firstCoordinate = coordinate.toLowerCase().charAt(0)-ASCII-1;
        int secondCoordinate = Integer.parseInt(coordinate.substring(1))-1;
        if (secondCoordinate > boardSize-1) {
            Display.printDisplayField(Display.SpecifyCoordinateMsg);
            secondCoordinate = Input.validateInput(boardSize, 0)-1;
        }
        validatedCoordinates.add(firstCoordinate);
        validatedCoordinates.add(secondCoordinate);
        return validatedCoordinates;
    }
}

