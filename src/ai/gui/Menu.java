/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai.gui;

import ai.game.Game;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;

/**
 *
 * @author Adam
 */
public class Menu extends JMenu {
    public Menu() {
        init();
        
    }
    private void init() {
        
        JMenuItem newGameItem = new JMenuItem();
        JMenuItem loadMapItem = new JMenuItem();
        JPopupMenu.Separator sep = new JPopupMenu.Separator();
        JMenuItem exitItem = new JMenuItem();

    
        setText("File");

        newGameItem.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newGameItem.setText("New game");
        newGameItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //TODO
            }
        });
        add(newGameItem);

        loadMapItem.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        loadMapItem.setText("Load Map");
        loadMapItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //TODO
            }
        });
        add(loadMapItem);
        add(sep);

        exitItem.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        exitItem.setText("Exit");
        exitItem.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });
        add(exitItem);

        

    }
}
