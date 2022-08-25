package com.unmsm.services.pieces;

import com.unmsm.gui.ChessGameBoard;
import java.io.Serializable;
import com.unmsm.utils.ColorOfPiece;
import com.unmsm.utils.IsOnScreen;

import java.util.ArrayList;
import com.unmsm.utils.IsEnemy;

public class PawnMove implements IPawnMove, Serializable{

    @Override
    public ArrayList<String> calculatePossibleMoves(ChessGameBoard board, int row, int column, int color, boolean isNotMoved) {
        ArrayList<String> moves = new ArrayList<>();
        if (IsOnScreen.invoke(row, column)) {
            int currRow =
                    color == ColorOfPiece.WHITE
                            ? (row - 1)
                            : (row + 1);
            int count = 1;
            int maxIter =isNotMoved ? 2 : 1;
            // check for normal moves
            while (count <= maxIter) { // only loop while we have open slots and have not passed our
                // limit
                if (IsOnScreen.invoke(currRow, column) && board.getCell(currRow,
                        column).getPieceOnSquare() == null) {
                    moves.add(currRow + "," + column);
                } else {
                    break;
                }
                currRow =
                        (color == ColorOfPiece.WHITE)
                                ? (currRow - 1)
                                : (currRow + 1);
                count++;
            }

            if (color == ColorOfPiece.WHITE) {
                if (IsEnemy.invoke(board, row - 1, column - 1,color)) {
                    moves.add((row - 1) + "," + (column - 1));
                }
                if (IsEnemy.invoke(board, row - 1, column + 1,color)) {
                    moves.add((row - 1) + "," + (column + 1));
                }
            } else {
                if (IsEnemy.invoke(board, row + 1, column - 1,color)) {
                    moves.add((row + 1) + "," + (column - 1));
                }
                if (IsEnemy.invoke(board, row + 1, column + 1,color)) {
                    moves.add((row + 1) + "," + (column + 1));
                }
            }
            
        }
        return moves;
    }
    
}
