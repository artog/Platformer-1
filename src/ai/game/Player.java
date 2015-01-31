/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai.game;

import ai.util.Vector;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JPanel;

/**
 *
 * @author Adam
 */
public class Player extends JPanel {
    public enum Movement { LEFT, RIGHT, NONE };
    
    private final Vector position;
    private final Vector movement;
    
    private final Game game;
    
    public Player(Game g) {
        this.game = g;
        
        this.movement = new Vector(0,0);
        this.position = new Vector(0,0);
        this.setBackground(Color.red);
    }
    
    public void move(Player.Movement dir) {
        
        switch (dir) {
            case LEFT:
                movement.setX(-1);
                break;
            case RIGHT:
                movement.setX(1);
                break;
            default:
                movement.setX(0);
        }
    }
    
    public void update() {
        this.position.setX(
                this.position.getX() + this.movement.getX()
        );
        
        Rectangle coll = game.collision(getBounds());
        if (coll != null) {
            this.movement.setY(0);
        }
        
        this.position.setY(
                this.position.getY() + this.movement.getY()
        );
        
        int h = game.getSize().height;
        
        setBounds(
                new Rectangle(
                        Math.round((float)this.position.getX()),
                        h - 10 - Math.round((float)this.position.getY()),
                        10, 10
                )
        );
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        
        g.setColor(Color.CYAN);
        
        g.fillRect(0, 0, 10, 10);
    }
    
    
}
