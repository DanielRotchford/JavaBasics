/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Rotchford.Daniel.hello;

import java.awt.geom.Point2D;
import java.util.LinkedList;


/**
 *
 * @author Daniel
 */
public class EquationOfQuadratic {

    private final double a;
    private double b;
    private double c;

    private final LinkedList<Point2D> rootPointsList;

    public EquationOfQuadratic(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        rootPointsList = quadraticEquation(a, b, c);
    }

    private LinkedList quadraticEquation(double ax, double bx, double cx) {

        double disc = (Math.pow(bx, 2) - (4 * ax * cx));
        LinkedList<Point2D> points = new LinkedList();

        if (disc >= 0) {

            points.add(calculateRoot(Math.sqrt(disc), bx, ax, cx));
            Point2D point2 = calculateRoot(-Math.sqrt(disc), bx, ax, cx);
            
            if ( ! point2.equals(points.get(0))) {
                points.add(point2);

            } else {
                System.out.println("roots are not real");
            }
        }
        return points;
    }

    private Point2D calculateRoot(double sqrtroot, double bx, double ax, double cx) {
        double x;
        double y;
        x = (sqrtroot - bx) / (2 * ax);
        y = (ax * Math.pow(x, 2) + bx * x + cx * x);
        Point2D point = new Point2D.Double(x, y);
        return point;
    }
    /**
     * 
     * @param line
     * @return the intersection of a straight line and quadratic equation
     */
    public LinkedList<Point2D> intersect(com.Rotchford.Daniel.hello.EquationOfLine line) {
        double aI = a;
        double bI = (b - line.getGradient());
        double cI = (c - line.getIntercept());

        LinkedList<Point2D> intersectPoints = quadraticEquation(aI, bI, cI);

        return intersectPoints;
    }

    public LinkedList<Point2D> getrootPoints() {
        return rootPointsList;
    }

    public String getQuadratic() {
        String squareString = "";
        String xString = "";
        String constantString = "";
        String bPosNeg = "";
        String cPosNeg = "";
        if (a != 0) {
            squareString = a + "x^2 ";

        }
        if (b != 0) {
            xString = String.valueOf(Math.abs(b)) + "x ";
            if (b > 0) {
                bPosNeg = "+";

            } else {
                bPosNeg = "- ";
            }

        }
        if (c != 0) {

            constantString = String.valueOf(Math.abs(c));
            if (c > 0) {
                cPosNeg = "+ ";
            } else {
                cPosNeg = "- ";
            }

        }
        return squareString + bPosNeg + xString + cPosNeg + constantString + "\n";

    }
    
}
