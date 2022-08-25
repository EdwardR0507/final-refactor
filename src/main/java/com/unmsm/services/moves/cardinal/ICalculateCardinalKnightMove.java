package com.unmsm.services.moves.cardinal;

import com.unmsm.gui.ChessGameBoard;
import java.io.Serializable;

import java.util.ArrayList;

public interface ICalculateCardinalKnightMove extends Serializable {

    ArrayList<String> invoke(ChessGameBoard board);

}
