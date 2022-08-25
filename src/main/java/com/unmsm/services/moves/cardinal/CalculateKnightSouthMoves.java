package com.unmsm.services.moves.cardinal;

import com.unmsm.gui.ChessGameBoard;
import com.unmsm.utils.ColorOfPiece;
import com.unmsm.utils.IsEnemy;
import com.unmsm.utils.IsOnScreen;

import java.util.ArrayList;

public class CalculateKnightSouthMoves implements ICalculateCardinalKnightMove {

    private final int pieceRow;
    private final int pieceColumn;
    private final ColorOfPiece colorOfPiece;

    public CalculateKnightSouthMoves(int pieceRow, int pieceColumn, ColorOfPiece colorOfPiece) {
        this.pieceRow = pieceRow;
        this.pieceColumn = pieceColumn;
        this.colorOfPiece = colorOfPiece;
    }

    @Override
    public ArrayList<String> invoke(ChessGameBoard board) {
        ArrayList<String> moves = new ArrayList<>();
        for (int i = 1; i >= -1; i -= 2) {
            for (int j = 2; j >= -2; j -= 4) {
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
