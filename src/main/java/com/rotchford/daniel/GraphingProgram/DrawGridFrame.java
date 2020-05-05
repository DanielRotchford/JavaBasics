/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Rotchford.Daniel.GraphingProgram;
 import javax.swing.JFrame;
/**
 *
 * @author Daniel
 */

public class DrawGridFrame extends JFrame {
    
    
    public DrawGridFrame(){
        
        add(new DrawGridComponent() );
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        pack();
        
        
    }
}
    