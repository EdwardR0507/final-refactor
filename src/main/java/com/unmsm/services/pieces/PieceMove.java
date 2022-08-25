package com.unmsm.services.pieces;

import com.unmsm.services.moves.cardinal.CalculateCardinalMoves;
import com.unmsm.gui.ChessGameBoard;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

public class PieceMove implements Serializable {

    private final List<CalculateCardinalMoves> calculateCardinalMoves;

    public PieceMove(List<CalculateCardinalMoves> calculateCardinalMoves) {
        this.calculateCardinalMoves = calculateCardinalMoves;
    }

    public List<String> calculateCardinalMoves(ChessGameBoard board, int numMoves){
        List<String> allMoves = new ArrayList<>();
        calculateCardinalMoves.forEach(x -> allMoves.addAll(this.calculateCardinalMove(x,board,numMoves))
        );
        return allMoves;
    }

    public List<String> calculateCardinalMove(CalculateCardinalMoves cardinalMove, ChessGameBoard board, int numMoves){
        return cardinalMove.invoke(board,numMoves);
    }
}
