/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Rotchford.Daniel.hello;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.text.DecimalFormat;

/**
 *
 * @author Daniel
 */

public class EquationOfLine {

    private double x0;
    private double y0;
    private double x1;
    private double y1;
    private double gradient;
    private double intercept;
  
    
    
    public EquationOfLine(String x0, String y0, String x1, String y1) {
        this(Double.parseDouble(x0), Double.parseDouble(y0), Double.parseDouble(x1), Double.parseDouble(y1));
    }

    /**
     * construct the equation of a line
     *
     * @param x0
     * @param y0
     * @param x1
     * @param y1
     */
    public EquationOfLine(double x0, double y0, double x1, double y1) {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
        
        gradient = calculateGradient();
        intercept = calculateIntercept();
        
    }

    /**
     *
     * @return The gradient of the line
     */
    private double calculateGradient() {
        double grad = 0;
        if (x1 != x0) {
            try {
                grad = ((y1 - y0) / (x1 - x0));
            } catch (Exception e) {
                System.out.println("gradient calculation overflowed: "
                + e.getLocalizedMessage());
            }

        } else {
            grad = Double.POSITIVE_INFINITY;
        }
        return grad;
    }

    /**
     * 
     * @return The intercept of the line and the y axis
     */
    private double calculateIntercept() {
        double inter;
        if (gradient != Double.POSITIVE_INFINITY) {
            inter = (y0 - (gradient * x0));
        } else {
            inter = Double.NaN;
        }

        return inter;
    }
    public double rounding(String format,double num){
        DecimalFormat decimalFormat = new DecimalFormat(format);
        num = Double.parseDouble(decimalFormat.format(num));
        return num;
    }
    public String generateFormula(String format) {
        
        String posNeg;
        String formula;
        Double grad;
        Double inter;

        if (intercept >= 0) {
            posNeg = "+ ";

        } else {
            posNeg = "";
        }
        if (gradient != Double.POSITIVE_INFINITY) {
            grad = rounding(format,gradient);
            inter = rounding(format,intercept);
            formula = ("y = " + grad + "x " + posNeg
                    + inter + "\n");
        } else {
            formula = ("x =" + x0 + "\n");
        }

        return formula;
    }
    public double getGradient() {
        return gradient;
    }

    public double getIntercept() {
        return intercept;
    }
    public Point2D calcIntersect(com.Rotchford.Daniel.hello.EquationOfLine altEquation) {
        double x = (altEquation.intercept - intercept) / (gradient - altEquation.gradient);
        double y = (gradient * x + intercept);
        
        return new Point2D.Double(x, y);
    }
}
    

