package com.unmsm.utils;

import java.io.Serializable;

public class ResourceOfPiece implements IResourceOfPiece, Serializable{

    int color;

    public ResourceOfPiece(int pieceColor){
        this.color = pieceColor;
    }

    @Override
    public String resourceByType(String pieceType) {
        String PATH = "/ChessImages";
			switch (color) {
				case ColorOfPiece.WHITE:
					return PATH + "/White" + pieceType + ".gif";
				case ColorOfPiece.BLACK:
					return PATH + "/Black" + pieceType + ".gif";
				default:
					return PATH + "/default-Unassigned.gif";
			}
    }
    
}
