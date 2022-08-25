package com.unmsm.services.pieces;

import com.unmsm.services.moves.cardinal.ICalculateCardinalKnightMove;
import com.unmsm.gui.ChessGameBoard;
import java.io.Serializable;
import com.unmsm.utils.IsOnScreen;

import java.util.ArrayList;
import java.util.List;

public class KnightMove implements Serializable {

    private final List<ICalculateCardinalKnightMove> calculateCardinalKnightMoves;

    
    public KnightMove(List<ICalculateCardinalKnightMove> calculateCardinalKnightMoves) {
        this.calculateCardinalKnightMoves = calculateCardinalKnightMoves;
    }

    public List<String> calculatePossibleMoves(ChessGameBoard board, int row, int column) {
        ArrayList<String> moves = new ArrayList<>();
        if (IsOnScreen.invoke(row, column)) {

            calculateCardinalKnightMoves.forEach(cardinalKnightMove -> moves.addAll(cardinalKnightMove.invoke(board)));

        }
        return moves;
    }

}
