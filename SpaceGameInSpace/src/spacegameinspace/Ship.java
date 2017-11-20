/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacegameinspace;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.util.*;

/**
 *
 * @author Andrew
 */
public class Ship extends Sprite{
    
    
    private int dx;
    private int dy;
    private ArrayList missiles;
    private int speed = 3;
    private Image image;
    
    public Ship(int x, int y) {
        super(x,y);
        initShip();
    }
    
    private void initShip(){
        missiles = new ArrayList();
        loadImage("./src/images/enterprise3.png");
        getImageDimensions();
//        ImageIcon ii = new ImageIcon("D:/Space Game In Space/enterprise3.png");
//        image = ii.getImage();
//        x = 400;
//        y = 500;
//        speed = 3;
    }
    
    public void move(){
        x += dx;
        y += dy;
        
    }
    
    public ArrayList getMissiles(){
        return missiles;
    }
    
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();
        
        if (key == KeyEvent.VK_SPACE) {
            fire();
        }
        
        if (key == KeyEvent.VK_LEFT) {
            dx = -speed;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = speed;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -speed;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = speed;
        }
    }
    
    public void fire() {
        missiles.add(new Missile(x, y-height/4));
    }

    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}
