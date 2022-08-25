package com.unmsm.services.pieces;

import com.unmsm.entity.ChessGamePiece;
import com.unmsm.gui.ChessGameBoard;
import java.io.Serializable;
import com.unmsm.utils.ColorOfPiece;

import java.util.ArrayList;

public class KingService implements IKingService, Serializable{

    private final ChessGameBoard board;
    private final IPieceMoveService pieceMoveService;

    public KingService(ChessGameBoard board,IPieceMoveService pieceMoveService) {
        this.board = board;
        this.pieceMoveService = pieceMoveService;
    }

    /**
     * Gets a list of GamePieces that can currently attack this game piece.
     *
     * @return ArrayList<GamePiece> the list of attackers
     */
    private ArrayList<ChessGamePiece> getCurrentAttackers(ChessGamePiece piece) {
        ArrayList<ChessGamePiece> attackers = new ArrayList<>();
        int enemyColor =
                (piece.getColorOfPiece().getColor() == ColorOfPiece.BLACK)
                        ? ColorOfPiece.WHITE
                        : ColorOfPiece.BLACK;
        piece.calculatePossibleMoves(board);
        for (int i = 0; i < board.getCells().length; i++) {
            for (int j = 0; j < board.getCells()[0].length; j++) {
                ChessGamePiece currPiece =
                        board.getCell(i, j).getPieceOnSquare();
                if (currPiece != null
                        && currPiece.getColorOfPiece().getColor() == enemyColor) {
                    piece.calculatePossibleMoves(board);
                    if (pieceMoveService.canMove(board,currPiece,piece.getRow(), piece.getColumn())) {
                        attackers.add(currPiece);
                    }
                }
            }
        }
        return attackers;
    }

    /**
     * Determines if this King is checked.
     *
     * @param piece
     * @return true if checked, false if not checked
     */
    @Override
    public boolean isChecked(ChessGamePiece piece){
        return !this.getCurrentAttackers(piece).isEmpty();
    }
}

