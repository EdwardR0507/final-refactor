package com.unmsm.services.moves.cardinal;

import java.util.ArrayList;

import com.unmsm.gui.ChessGameBoard;
import com.unmsm.utils.ColorOfPiece;
import com.unmsm.utils.IsEnemy;
import com.unmsm.utils.IsOnScreen;


public class CalculateEastMoves extends CalculateCardinalMoves {

    public CalculateEastMoves(int pieceRow, int pieceColumn, ColorOfPiece colorOfPiece) {
        super(pieceRow, pieceColumn, colorOfPiece);
    }

    @Override
    public ArrayList<String> invoke(ChessGameBoard board, int numMoves) {
        ArrayList<String> moves = new ArrayList<>();
         int count = 0;
         if (IsOnScreen.invoke(getPieceRow(),getPieceColumn())) {
             for (int i = getPieceColumn() + 1; i < 8 && count < numMoves; i++) {
                 if ((board.getCell(getPieceRow(), i).getPieceOnSquare()
                         == null || IsEnemy.invoke(board, getPieceRow(), i,getColorOfPiece().getColor()))) {
                     moves.add(getPieceRow() + "," + i);
                     count++;
                     if (IsEnemy.invoke(board, getPieceRow(), i,getColorOfPiece().getColor())) {
                         break;
                     }
                 } else {
                     count=numMoves;
                 }
             }
         }
        return moves;
    }
}

