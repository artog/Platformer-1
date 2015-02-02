/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai.game;

import ai.util.Vector;
import java.awt.Color;
import java.awt.Dimension;
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
    
    /**
     * Size of each tile
     */
    public final int tileSize = 20;
    
    public final int fieldHeight = tileSize*25;
    public final int fieldWidth = tileSize*50;
    
    public Game() {
        
        this.setPreferredSize(
            new Dimension(fieldWidth,fieldHeight)
        );
        this.setLayout(null);
        
        
        this.tiles = new ArrayList();
        this.player = new Player(this);
        this.add(this.player);
        
//        int h = this.getSize().height;
//        System.out.println(h);
        
        this.timer = new Timer(10,new ActionListener () {

            @Override
            public void actionPerformed(ActionEvent e) {
                update();
            }
            
        });
        this.timer.start();
        this.setBackground(Color.BLACK);
        
        List<String> map = new ArrayList();
        map.add("111111111111111111111111111111111111111111111111111");
        map.add("100000000000000000000000000000000000000000000000001");
        map.add("100000000000000000000000000000000000000000000000001");
        map.add("100000000000000000000000000000000000000000000000001");
        map.add("100000000000000000000000000000000000000000000000001");
        map.add("100000000000000000000000000000000000000000000000001");
        map.add("100000000000000000000000000000000000000000000000001");
        map.add("100000000000000000000000000000000000000000000000001");
        map.add("100000000000000000000000000000000000000000000000001");
        map.add("100000000000000000000000000000000000000000000000001");
        map.add("100000000000000000000000000000000000000000000000001");
        map.add("100000000000000000000000000000000000000000000000001");
        map.add("100000000000000000000000000000000000000000000000001");
        map.add("100000000000000000000000000000000000000000000000001");
        map.add("100000000000000000000000000000000000000000000000001");
        map.add("100000000000000000000000000000000000000000000000001");
        map.add("100000000000000000000000000000000000000000000000001");
        map.add("100000000000000000000000000000000000000000000000001");
        map.add("100000000000000000000000000000000000000000000000001");
        map.add("100000000000000000000000000000000000000000000000001");
        map.add("100000000000000000000000000000000000000000000000001");
        map.add("100000000000000000000000000000000000000000000000001");
        map.add("100000000000000000000000000000000000000000000000001");
        map.add("100000000000000000000000000000000000000000000000001");
        map.add("100000000000000000000000000000000000000000000000001");
        map.add("111111111111111111111111111111111111111111111111111");
        this.loadMap(map);
    }
    
    public void loadMap(List<String> map) {
        int j = 0;
        int i = 0;
        
        for (String row : map) {
            j = 0;
            for (char c : row.toCharArray()) {
                Tile t = new Tile(this);
                
                t.setBounds(
                    tileSize*j - (tileSize/2),
                    tileSize*i - (tileSize/2), 
                    tileSize, 
                    tileSize
                );
                t.setBackground(Color.BLACK);
                if (c == '1') {
                    t.setSolid(true);
                }
                tiles.add(t);
                j++;
            }
            i++;
        }
        for (Tile t : tiles) {
            this.add(t);
        }
    }
    
    public void update() {
        this.gametime += 10;
        this.player.update();
        
    }
    
    public List<Tile> collision(Rectangle r) {
        List<Tile> collisionTiles = new ArrayList();
        
        for (Tile t : tiles) {
            if (t.getBounds().intersects(r) && t.isSolid()) {
                collisionTiles.add(t);
            }
        }
        return collisionTiles;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void event(Event e) {
        Player.Movement dir = Player.Movement.NONE;
        switch (e) {
            case JUMP: 
                System.out.println("Event: JUMP");
                this.player.jump();
                return;
            case MOVE_LEFT: 
                dir = Player.Movement.LEFT;
                break;
            case MOVE_RIGHT: 
                dir = Player.Movement.RIGHT;
                break;
            case STOP_MOVE: 
                dir = Player.Movement.NONE;
                break;
        }
        System.out.println("Event: "+dir);
        player.move(dir);
    }
    
    public Vector worldToTile(Vector world) {
        
        return new Vector(
            Math.round((float) (world.getX() / tileSize)),
            Math.round((float) (world.getY() / tileSize))
        );
        
    }
}
