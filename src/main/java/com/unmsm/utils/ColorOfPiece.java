package com.unmsm.utils;

import java.io.Serializable;

public  class ColorOfPiece implements Serializable {

    /**
     * Represents a black piece as an int
     */
    public static final int BLACK = 0;
    /**
     * Represents a white piece as an int
     */
    public static final int WHITE = 1;
    /**
     * Represents a piece that has not been assigned a color
     */
    public static final int UNASSIGNED = -1;

    private final int color;

    public ColorOfPiece(int pieceColor) {
        this.color = pieceColor;
    }

    public int getColor() {
        return color;
    }
}
