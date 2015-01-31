/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Adam
 */
public class Game extends JPanel {
    public enum Event { JUMP, MOVE_LEFT, MOVE_RIGHT, STOP_MOVE };
    private final List<Tile> tiles;
    private final Player player;
    
    private final Timer timer;
    private long gametime;
    
    public Game() {
        
        this.setLayout(null);
        
        
        this.tiles = new ArrayList();
        this.player = new Player(this);
        this.player.setBounds(new Rectangle(10,0,10,10));
        this.add(this.player);
        
        int h = this.getSize().height;
        System.out.println(h);
        
        this.timer = new Timer(10,new ActionListener () {

            @Override
            public void actionPerformed(ActionEvent e) {
                update();
            }
            
        });
        this.timer.start();
        this.setBackground(Color.BLACK);
    }
    public void update() {
        this.gametime += 10;
        this.player.update();
    }
    
    public Rectangle collision(Rectangle r) {
        for (Tile t : tiles) {
            if (t.getBounds().intersects(r)) {
                return new Rectangle(t.getBounds());
            }
        }
        return null;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
    }

    public void event(Event e) {
        Player.Movement dir = Player.Movement.NONE;
        switch (e) {
            case JUMP: 
//              // jump
                break;
            case MOVE_LEFT: 
                dir = Player.Movement.LEFT;
                break;
            case MOVE_RIGHT: 
                dir = Player.Movement.RIGHT;
                break;
            case STOP_MOVE: 
                dir = Player.Movement.NONE;
                break;
            default:
        }
        player.move(dir);
    }
    
    
}
