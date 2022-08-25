package com.unmsm.services.moves.cardinal;

import java.io.Serializable;
import com.unmsm.utils.ColorOfPiece;

public abstract class CalculateCardinalMoves implements ICalculateMove, Serializable {
  private int pieceRow;
    private int pieceColumn;
    private ColorOfPiece colorOfPiece;

    protected CalculateCardinalMoves(int pieceRow, int pieceColumn, ColorOfPiece colorOfPiece) {
        this.pieceRow = pieceRow;
        this.pieceColumn = pieceColumn;
        this.colorOfPiece = colorOfPiece;
    }

    public int getPieceRow() {
        return pieceRow;
    }

    public void setPieceRow(int pieceRow) {
        this.pieceRow = pieceRow;
    }

    public int getPieceColumn() {
        return pieceColumn;
    }

    public void setPieceColumn(int pieceColumn) {
        this.pieceColumn = pieceColumn;
    }

    public ColorOfPiece getColorOfPiece() {
        return colorOfPiece;
    }

    public void setColorOfPiece(ColorOfPiece colorOfPiece) {
        this.colorOfPiece = colorOfPiece;
    }
}
