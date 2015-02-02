/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai.game;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Adam
 */
public class Tile extends JPanel {
    
    private boolean isSolid = false;
    
    private final int size;
    private final Game game;

    public Tile(Game g) {
        game = g;
        this.size = g.tileSize;
    }
    
    public void setSolid(boolean isSolid) {
        this.isSolid = isSolid;
    }

    public boolean isSolid() { return isSolid; }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (isSolid) {
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(0, 0, size, size);
        }
    }
    
    
    
}
