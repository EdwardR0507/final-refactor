package com.unmsm.services.pieces;

import com.unmsm.gui.ChessGameBoard;

import java.util.ArrayList;

public interface IPawnMove {

    ArrayList<String> calculatePossibleMoves(ChessGameBoard board, int row, int column, int color, boolean isNotMoved);
}