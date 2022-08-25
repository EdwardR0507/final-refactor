package com.unmsm.services.moves.cardinal;

import com.unmsm.gui.ChessGameBoard;
import com.unmsm.utils.ColorOfPiece;
import com.unmsm.utils.IsEnemy;
import com.unmsm.utils.IsOnScreen;

import java.util.ArrayList;

public class CalculateKnightNorthMoves implements ICalculateCardinalKnightMove {
    private final int pieceRow;
    private final int pieceColumn;
    private final ColorOfPiece colorOfPiece;

    public CalculateKnightNorthMoves(int pieceRow, int pieceColumn, ColorOfPiece colorOfPiece) {
        this.pieceRow = pieceRow;
        this.pieceColumn = pieceColumn;
        this.colorOfPiece = colorOfPiece;
    }

    @Override
    public ArrayList<String> invoke(ChessGameBoard board) {
        ArrayList<String> moves = new ArrayList<>();
        for (int i = 2; i >= -2; i -= 4) {
            for (int j = 1; j >= -1; j -= 2) {
                if (IsOnScreen.invoke(pieceRow + i, pieceColumn + j)
                        && (IsEnemy.invoke(board, pieceRow + i, pieceColumn + j,colorOfPiece.getColor()) ||
                        board.getCell(
                                pieceRow + i,
                                pieceColumn + j)
                                .getPieceOnSquare() == null)) {
                    moves.add((pieceRow + i) + "," + (pieceColumn + j));
                }
            }
        }
        return moves;
    }
}
