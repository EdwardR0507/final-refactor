package com.unmsm.services.moves.cardinal;

import java.util.ArrayList;

import com.unmsm.gui.ChessGameBoard;
import com.unmsm.utils.ColorOfPiece;
import com.unmsm.utils.IsEnemy;
import com.unmsm.utils.IsOnScreen;

public class CalculateNorthEastMoves extends CalculateCardinalMoves {
  public CalculateNorthEastMoves(int pieceRow, int pieceColumn, ColorOfPiece colorOfPiece) {
    super(pieceRow, pieceColumn, colorOfPiece);
  }

  @Override
    public ArrayList<String> invoke(ChessGameBoard board, int numMoves) {
        ArrayList<String> moves = new ArrayList<>();
         int count = 0;
         if (IsOnScreen.invoke(getPieceRow(),getPieceColumn())) {
             for (int i = 1; i < 8 && count < numMoves; i++) {
                 if (IsOnScreen.invoke(getPieceRow() - i, getPieceColumn() + i)
                         && (board.getCell(getPieceRow() - i,
                         getPieceColumn() + i).getPieceOnSquare() == null)) {
                     moves.add((getPieceRow() - i) + "," + (getPieceColumn() + i));
                     count++;
                 } else if (IsEnemy.invoke(board, getPieceRow() - i, getPieceColumn() + i,getColorOfPiece().getColor())) {
                     moves.add((getPieceRow() - i) + "," + (getPieceColumn() + i));
                     break;
                 } else {
                     count=numMoves;
                 }
             }
         }
        return moves;
    }
}
