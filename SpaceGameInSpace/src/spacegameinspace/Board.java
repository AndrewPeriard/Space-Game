/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacegameinspace;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;


/**
 *
 * @author Andrew
 */
public class Board extends JPanel implements ActionListener {
    
    
    private Image space;
    private Timer timer;
    private Ship ship;
    private final int DELAY = 5;
    private final int ICRAFT_X = 400;
    private final int ICRAFT_Y = 500;
    
    public Board() {
        
        initBoard();
    }
    
    private void initBoard() {
        
        loadBackground();
        addKeyListener(new TAdapter());
        setFocusable(true);
        setDoubleBuffered(true);
        
        ship = new Ship(ICRAFT_X, ICRAFT_Y);
        
//        int w = space.getWidth(this);
//        int h = space.getHeight(this);
//        setPreferredSize(new Dimension(w, h));
        
        timer = new Timer(DELAY, this);
        timer.start();
    }
    
    private void loadBackground() {
        
        ImageIcon ii = new ImageIcon("./src/images/spacefull.jpg");
        space = ii.getImage();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.drawImage(space, -300, -250, null);
        doDrawing(g);
        
        Toolkit.getDefaultToolkit().sync();
    }
    
    private void doDrawing(Graphics g){
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(ship.getImage(), ship.getX(), ship.getY(), this);
        
        ArrayList ms = ship.getMissiles();

        for (Object m1 : ms) {
            Missile m = (Missile) m1;
            g2d.drawImage(m.getImage(), m.getX(),
                    m.getY(), this);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        updateMissiles();
        updateShip();
        repaint();  
    }
    
    public void updateMissiles(){
        
        ArrayList ms = ship.getMissiles();

        for (int i = 0; i < ms.size(); i++) {

            Missile m = (Missile) ms.get(i);

            if (m.isVisible()) {

                m.move();
            } else {

                ms.remove(i);
            }
        }
        
    }
    
    public void updateShip(){
        ship.move();
    }
    
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            ship.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            ship.keyPressed(e);
        }
    }
}

