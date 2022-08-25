package com.unmsm.utils;

public class IsOnScreen {
    
    private IsOnScreen () {}

    public static boolean invoke(int row, int col){
        return row >= 0 && row <= 7 && col >= 0 && col <= 7;
    }
}
