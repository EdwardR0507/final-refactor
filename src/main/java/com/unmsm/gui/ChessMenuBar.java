package com.unmsm.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Represents the north menu-bar that contains various controls for the game.
 */
public class ChessMenuBar extends JMenuBar {

    /**
     * Create a new ChessMenuBar object.
     */
    public ChessMenuBar() {
        String[] menuCategories = {"File", "Options", "Help"};
        String[] menuItemLists =
                {"New game/restart,Exit", "Toggle graveyard,Toggle game log",
                        "About"};
        for (int i = 0; i < menuCategories.length; i++) {
            JMenu currMenu = new JMenu(menuCategories[i]);
            String[] currMenuItemList = menuItemLists[i].split(",");
            for (String currMenuItemList1 : currMenuItemList) {
                JMenuItem currItem = new JMenuItem(currMenuItemList1);
                currItem.addActionListener(new MenuListener());
                currMenu.add(currItem);
            }
            this.add(currMenu);
        }
    }

    /**
     * Listener for the north menu bar.
     */
    private class MenuListener implements ActionListener {

        /**
         * Takes an appropriate action based on which menu button is clicked
         *
         * @param event the mouse event from the source
         */
        @Override
        public void actionPerformed(ActionEvent event) {
            String buttonName = ((JMenuItem) event.getSource()).getText();
            switch (buttonName) {
                case "About": aboutHandler(); break;
                case "New game/restart": restartHandler(); break;
                case "Toggle game log": toggleGameLogHandler(); break;
                case "Exit": exitHandler(); break;
								default: toggleGraveyardHandler();
            }
        }
        
        /**
        * Takes an appropriate action if the about button is clicked.
        */
       private void aboutHandler() {
           JOptionPane.showMessageDialog(ChessMenuBar.this.getParent(), "YetAnotherChessGame v1.0 by:\nBen Katz\nMyles David\n"
                        + "Danielle Bushrow\n\nFinal Project for CS2114 @ VT");
       }

			
       /**
        * Takes an appropriate action if the restart button is clicked.
        */
       private void restartHandler() {
           ((ChessPanel) ChessMenuBar.this.getParent()).getGameEngine().reset();
       }
       
       /**
        * Takes an appropriate action if the exit button is clicked.
        * Uses Tony Allevato's code for exiting a GUI app without System.exit()
        * calls.
        */
       private void exitHandler() {
           JOptionPane.showMessageDialog(ChessMenuBar.this.getParent(), "Thanks for leaving"
                   + ", quitter! >:(");
           Component possibleFrame = ChessMenuBar.this;
           while (possibleFrame != null && !(possibleFrame instanceof JFrame)) {
               possibleFrame = possibleFrame.getParent();
           }
           JFrame frame = (JFrame) possibleFrame;
					// Solving the bug, checking that the frame is not null
           if (frame != null) {
               frame.setVisible(false);
               frame.dispose();
           }
       }
       
       /**
        * Takes an appropriate action if the toggle graveyard button is clicked.
        */
       private void toggleGraveyardHandler() {
           ((ChessPanel) ChessMenuBar.this.getParent()).getGraveyard(1).setVisible(
                   !((ChessPanel) ChessMenuBar.this.getParent()).getGraveyard(1).isVisible());
           ((ChessPanel) ChessMenuBar.this.getParent()).getGraveyard(2).setVisible(
                   !((ChessPanel) ChessMenuBar.this.getParent()).getGraveyard(2).isVisible());
       }

       /**
        * Takes an appropriate action if the toggle game log button is clicked.
        */
       private void toggleGameLogHandler() {
           ((ChessPanel) ChessMenuBar.this.getParent()).getGameLog().setVisible(
                   !((ChessPanel) ChessMenuBar.this.getParent()).getGameLog().isVisible());
           ((ChessPanel) ChessMenuBar.this.getParent()).revalidate();
       }
    }
    
}