package com.unmsm.services.pieces;

import com.unmsm.entity.ChessGamePiece;
import com.unmsm.gui.ChessGameBoard;
import java.io.Serializable;

public interface IPieceMoveService extends Serializable {

    boolean move(ChessGameBoard board, ChessGamePiece piece, int row, int col);

    boolean canMove(ChessGameBoard board, ChessGamePiece piece, int row, int col);

    boolean testMoveForKingSafety(ChessGameBoard board, ChessGamePiece piece, int row, int col);

    void showLegalMoves(ChessGameBoard board, ChessGamePiece piece);

    boolean hasLegalMoves(ChessGameBoard board, ChessGamePiece piece);

}


