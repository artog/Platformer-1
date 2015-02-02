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
import java.util.List;
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
    
    private final int size;
    
    public Player(Game g) {
        game = g;
        size = game.tileSize;
        
        int h = game.fieldHeight;
        int w = game.fieldWidth;
        
        movement = new Vector(10,10);
        position = new Vector(w/2,h/2);
        
        setBackground(Color.red);
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
            movement.setY(movement.getY()-20);
        }
    }
    public void update() {
        
        

        double newY = position.getY() + movement.getY();
        double newX = position.getX() + movement.getX();

        Rectangle aabb = new Rectangle(
                (int)Math.round(newX), 
                (int)Math.round(newY),
                (int)Math.round(newX) - (int)Math.round(position.getX()),
                (int)Math.round(newY) - (int)Math.round(position.getY())
        );
        
        List<Tile> coll = game.collision(aabb);
        
        if (coll.size() > 0) {
            for (Tile t : coll) {

                System.out.println(t.getBounds());
            }
//            System.exit(0);
            
            movement.setY(0);
            movement.setX(0);
//            position.setY(coll.getMinY() - size);
            
            position.setX(position.getY());
            position.setY(position.getX());
            
        } else {
            movement.setY(movement.getY()+1);
            
            newY++;
            
            position.setX(newX);
            position.setY(newY);
        }
        
        
        
        int h = game.getSize().height;
        
        setBounds(
                new Rectangle(
                        Math.round( (float)position.getX() ) - size/2,
                        Math.round( (float)position.getY() ) - size/2,
                        size, size
                )
        );
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        
        g.setColor(Color.CYAN);
        
        g.fillRect(0, 0, size, size);
    }
    
    public Vector getPos() {
        return this.position;
    }
    
    
}
