package com.unmsm.services.moves.cardinal;

import java.util.ArrayList;

import com.unmsm.gui.ChessGameBoard;
import com.unmsm.utils.ColorOfPiece;
import com.unmsm.utils.IsEnemy;
import com.unmsm.utils.IsOnScreen;

public class CalculateSouthMoves extends CalculateCardinalMoves {
  public CalculateSouthMoves(int pieceRow, int pieceColumn, ColorOfPiece colorOfPiece) {
    super(pieceRow, pieceColumn, colorOfPiece);
  }
  
  @Override
  public ArrayList<String> invoke(ChessGameBoard board, int numMoves) {
      ArrayList<String> moves = new ArrayList<>();
       int count = 0;
       if (IsOnScreen.invoke(getPieceRow(), getPieceColumn())) {
           for (int i = getPieceRow() + 1; i < 8 && count < numMoves; i++) {
               if ((board.getCell(i, getPieceColumn()).getPieceOnSquare()
                       == null || IsEnemy.invoke(board, i, getPieceColumn(),getColorOfPiece().getColor()))) {
                   moves.add(i + "," + getPieceColumn());
                   count++;
                   if (IsEnemy.invoke(board, i, getPieceColumn(),getColorOfPiece().getColor())) {
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
