/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai.gui;

import ai.game.Game;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

/**
 *
 * @author Adam
 */
public class Main extends JFrame {
    private final JMenuBar menu = new JMenuBar();

    private final Game game;
    /**
     * Creates new form Main
     */
    public Main() {
        this.setSize(new Dimension(1000,500));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        menu.add(new Menu());
        this.setJMenuBar(menu);
        this.setLayout(new BorderLayout());
        this.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    game.event(Game.Event.MOVE_LEFT);
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    game.event(Game.Event.MOVE_RIGHT);
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    game.event(Game.Event.JUMP);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    game.event(Game.Event.STOP_MOVE);
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    game.event(Game.Event.STOP_MOVE);
                }
            }
        });
        int h = this.getSize().height;
        System.out.println(h);
        this.game = new Game();
        this.add(game,BorderLayout.CENTER);
        
        h = game.getSize().height;
        System.out.println(h);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

}
