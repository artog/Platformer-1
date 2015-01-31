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
                movement.setX(-2);
                break;
            case RIGHT:
                movement.setX(2);
                break;
            default:
                movement.setX(0);
        }
    }
    public void jump() {
        if (movement.getY() == 0) {
            movement.setY(movement.getY()+10);
        }
    }
    public void update() {
        
        System.out.println(movement);
        movement.setY(movement.getY()-1);
        
        if (position.getY() <= 0 && movement.getY() < 0) {
            position.setY(0);
            movement.setY(0);
        }
        
        
        position.setX(
                position.getX() + movement.getX()
        );
        
        Rectangle coll = game.collision(getBounds());
        if (coll != null) {
            movement.setY(0);
        }
        
        position.setY(
                position.getY() + movement.getY()
        );
        
        int h = game.getSize().height;
        
        setBounds(
                new Rectangle(
                        Math.round( (float)position.getX() ),
                        h - 10 - Math.round( (float)position.getY() ),
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
