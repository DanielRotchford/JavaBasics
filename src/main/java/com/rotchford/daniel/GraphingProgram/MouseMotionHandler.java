/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Rotchford.Daniel.GraphingProgram;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author Daniel
 */
public class MouseMotionHandler implements MouseMotionListener{
    DrawGridComponent component;
    public MouseMotionHandler(DrawGridComponent passedComponent){
      this.component = passedComponent;
    }
    public void mouseMoved(MouseEvent event){
        int mouseX = event.getX();
        int mouseY = event.getY();
        int width = component.getWidth();
        int height = component.getHeight();
        
        if( mouseY < width ){
            int x = mouseX - (width / 2);
            int y = mouseY - (height/ 2);
            System.out.println(
                    "(" + Integer.toString(x) + "," + Integer.toString(y)+ ")");
        }
           
    }
    @Override
    public void mouseDragged(MouseEvent event){
        mouseMoved(event);
        
    }
        
}
