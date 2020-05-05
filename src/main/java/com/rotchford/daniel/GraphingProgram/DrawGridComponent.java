/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Rotchford.Daniel.GraphingProgram;

import java.awt.*;
import java.awt.geom.Line2D;
import javax.swing.JComponent;
import javax.swing.JFrame;

import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Daniel
 */
public class DrawGridComponent extends JComponent {
   private GraphInterface graphPanel;

    private ArrayList<Line2D> gridLines;

    public DrawGridComponent() {
        gridLines = GridRender();
        addMouseMotionListener(new MouseMotionHandler(this));
        System.out.println(getWidth());
        setPreferredSize(new Dimension(600,400));
        
    }

    @Override
    public void paintComponent(Graphics g) {
        boolean xDone = false;
        boolean yDone = false;
        boolean change = false;
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(Color.LIGHT_GRAY);
        int frameWidth = getWidth();
        int frameHeight = getHeight();
        

        for (Line2D i : gridLines) {
            g2.draw(i);
            
            if (xDone == false && i.getX1() >= frameWidth - 10) {
                xDone = true;
            }

            if (yDone == false && i.getY1() >= frameHeight - 10) {
                yDone = true;
            }

            if (change == false && xDone == true && yDone == true){
                g2.setPaint(Color.GRAY);
                change = true;
            }
            
            
        }
        g2.setPaint(Color.BLACK);
        g2.draw(new Line2D.Double((frameWidth / 2), 0, (frameWidth / 2), frameHeight));
        g2.draw(new Line2D.Double(0, (frameHeight / 2), frameWidth, (frameHeight / 2)));
    }

    
    
    private ArrayList<Line2D> GridRender() {
        int centX = getWidth() / 2;
        int centY = getHeight() / 2;
        System.out.println(this.getWidth());
        ArrayList<Line2D> allLines = new ArrayList<>();
        ArrayList<Line2D> majorLines = new ArrayList<>();

        int x = (int) Math.floor(centX / 10);
        int y = (int) Math.floor(centY / 10);
        //this allows me to draw a line every ten pixels 
        for (int i = -x; i <= x; i++) {
            if (i % 10 == 0) {
                majorLines.add(
                        LineAssign(centX + i * 10, 0,
                                centX + i * 10, getHeight())); // make variable 

            } else {
                allLines.add(
                        LineAssign(centX + i * 10, 0,
                                centX + i * 10, getHeight()));

            }
        }
        for (int j = -y; j <= y; j++) {
            if (j % 10 == 0) {
                majorLines.add(
                        LineAssign(0, centY + j * 10,
                                getWidth(), centY + j * 10));
            } else {
                allLines.add(
                        LineAssign(0, centY + j * 10,
                                getWidth(), centY + j * 10));

            }
        }
        //adds major lines to the end to be rendered second
        majorLines.forEach((k) -> {
            allLines.add(k);
        });
        return allLines;
    }

    private Line2D LineAssign(int x1, int y1, int x2, int y2) {
        return new Line2D.Double(x1, y1, x2, y2);
    }
    
}
