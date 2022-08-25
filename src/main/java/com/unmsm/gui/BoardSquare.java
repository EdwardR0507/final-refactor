package com.unmsm.gui;

import com.unmsm.entity.ChessGamePiece;

import javax.swing.*;


public class BoardSquare extends JPanel {
    private final int row;
    private final int col;
    private ChessGamePiece piece;
    private JLabel imageLabel;

    public BoardSquare(int row, int col, ChessGamePiece piece) {
        super();
        this.row = row;
        this.col = col;
        this.piece = piece;
        updateImage();
    }

    private void updateImage() {
        if (imageLabel != null) {
            removeAll();
        }
        if (piece != null) {
            imageLabel = new JLabel();
            imageLabel.setIcon(piece.getImage());
            add(imageLabel);
        }
        revalidate(); 
    }

    /**
     * Gets the row number.
     *
     * @return int the row number
     */
    public int getRow() {
        return row;
    }

    /**
     * Gets the column number.
     *
     * @return int the column number
     */
    public int getColumn() {
        return col;
    }

    /**
     * Gets the piece on this square
     *
     * @return GamePiece the piece
     */
    public ChessGamePiece getPieceOnSquare() {
        return piece;
    }

    /**
     * Sets the piece on this square
     *
     * @param p the piece
     */
    public void setPieceOnSquare(ChessGamePiece p) {
        piece = p;
        updateImage();
    }

    /**
     * Clears this square, removing the icon and the piece.
     */
    public void clearSquare() {
        piece = null;
        removeAll();
    }
}