package com.unmsm;

import com.unmsm.gui.ChessPanel;
import javax.swing.*;

public class ChessMain {

    public static void main(String[] args) {
        JFrame frame = new JFrame("ChessMaster Refactored");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ChessPanel());
        frame.pack();
        frame.setVisible(true);
    }
}
