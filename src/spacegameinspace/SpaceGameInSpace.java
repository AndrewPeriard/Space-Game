/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacegameinspace;

import java.awt.EventQueue;
import javax.swing.JFrame;
/**
 *
 * @author Andrew
 */
public class SpaceGameInSpace extends JFrame {

    public SpaceGameInSpace() {
        initUI();
    }
    
    private void initUI() {
        add(new Board());
        
        setSize(1000, 800);
        setResizable(false);
        
        setTitle("Space Game IN SPACE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    /**
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SpaceGameInSpace ex = new SpaceGameInSpace();
                ex.setVisible(true);
            }
        });
    }
    
}
