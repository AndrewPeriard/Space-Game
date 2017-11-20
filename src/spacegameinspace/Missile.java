/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacegameinspace;

/**
 *
 * @author Andrew
 */
public class Missile extends Sprite{
    private final int BOARD_HEIGHT = 10;
    private final int MISSILE_SPEED = 5;

    public Missile(int x, int y) {
        super(x, y);
        
        initMissile();
    }
    
    private void initMissile() {
        
        loadImage("./images/missile.png");
        getImageDimensions();
    }


    public void move() {
        
        y -= MISSILE_SPEED;
        
        if (y < BOARD_HEIGHT) {
            vis = false;
        }
    }
}
