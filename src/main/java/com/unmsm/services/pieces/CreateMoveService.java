package com.unmsm.services.pieces;

import com.unmsm.services.moves.cardinal.CalculateEastMoves;
import com.unmsm.services.moves.cardinal.CalculateKnightSouthMoves;
import com.unmsm.services.moves.cardinal.CalculateSouthMoves;
import com.unmsm.services.moves.cardinal.CalculateSouthWestMoves;
import com.unmsm.services.moves.cardinal.CalculateNorthEastMoves;
import com.unmsm.services.moves.cardinal.ICalculateCardinalKnightMove;
import com.unmsm.services.moves.cardinal.CalculateNorthMoves;
import com.unmsm.services.moves.cardinal.CalculateWestMoves;
import com.unmsm.services.moves.cardinal.CalculateNorthWestMoves;
import com.unmsm.services.moves.cardinal.CalculateCardinalMoves;
import com.unmsm.services.moves.cardinal.CalculateKnightNorthMoves;
import com.unmsm.services.moves.cardinal.CalculateSouthEastMoves;
import com.unmsm.utils.ColorOfPiece;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateMoveService {
    
    private CreateMoveService() {
        
    }

    public static List<CalculateCardinalMoves> kingOrQeenMove(int pieceRow, int pieceColumn, ColorOfPiece color){
        List<CalculateCardinalMoves> addAllMove = new ArrayList<>();
        addAllMove.addAll(CreateMoveService.bishopMove(pieceRow,pieceColumn,color));
        addAllMove.addAll(CreateMoveService.rookMove(pieceRow,pieceColumn,color));
        return addAllMove;
    }

    public static List<CalculateCardinalMoves> bishopMove(int pieceRow, int pieceColumn, ColorOfPiece color){
        return Arrays.asList(new CalculateNorthEastMoves(pieceRow,pieceColumn,color),
                new CalculateNorthWestMoves(pieceRow,pieceColumn,color),
                new CalculateSouthEastMoves(pieceRow,pieceColumn,color),
                new CalculateSouthWestMoves(pieceRow,pieceColumn,color));
    }

    public static List<CalculateCardinalMoves> rookMove(int pieceRow, int pieceColumn, ColorOfPiece color){
        return Arrays.asList(new CalculateSouthMoves(pieceRow,pieceColumn,color),
                new CalculateNorthMoves(pieceRow,pieceColumn,color),
                new CalculateEastMoves(pieceRow,pieceColumn,color),
                new CalculateWestMoves(pieceRow,pieceColumn,color));
    }


    public static List<ICalculateCardinalKnightMove> knightMove(int pieceRow, int pieceColumn, ColorOfPiece color){
        return Arrays.asList(new CalculateKnightNorthMoves(pieceRow,pieceColumn,color),
                new CalculateKnightSouthMoves(pieceRow,pieceColumn,color));
    }
}
