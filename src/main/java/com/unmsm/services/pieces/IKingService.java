package com.unmsm.services.pieces;

import com.unmsm.entity.ChessGamePiece;
import java.io.Serializable;

public interface IKingService extends Serializable {

    boolean isChecked(ChessGamePiece piece);
}
