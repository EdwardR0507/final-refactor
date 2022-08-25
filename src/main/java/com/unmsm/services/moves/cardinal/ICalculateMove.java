package com.unmsm.services.moves.cardinal;

import java.util.ArrayList;

import com.unmsm.gui.ChessGameBoard;

public interface ICalculateMove {

	ArrayList<String> invoke(ChessGameBoard board, int numMoves);
}
