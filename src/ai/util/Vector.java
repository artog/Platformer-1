/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ai.util;

/**
 *
 * @author Adam
 */
public class Vector {
    private double x;
    private double y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public Vector() {
        this(0,0);
    }

    public double getX() { return this.x; }
    public double getY() { return this.y; }

    public void setX(double x) { this.x = x;}
    public void setY(double y) { this.y = y;}
    
    @Override
    public String toString() {
        return String.format("[%f,%f]", x,y);
    }
}
