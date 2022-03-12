package assignment2;

import java.util.*;
import java.lang.Double;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Defines a Polygon, or a collection of connected Cartesian Points
 *
 * Author: Sam Dolbel
 * Date created: 12/3/2019
 * Date modified: 22/3/2019
 */
public class Polygon implements ComparePoly
{
    private Point[] pointArray;
    int sides;

    public Polygon(int sides)
    {
        this.sides = sides;
        pointArray = new Point[sides];
    }

    public void addPoint(double x, double y, int index)
    {
        pointArray[index] = new Point(x, y);
    }

    public Point getPoint(int index)
    {
        return pointArray[index];
    }

    public int getSides()
    {
        return sides;
    }

    public void toString()
    {
        System.out.print("POLY=[ ");
        for(int i=0; i<pointArray.length; i++)
        {
            System.out.print("(" + pointArray[i].getX() + ", " + pointArray[i].getY() + ") ");
        }
        System.out.print("]: "+ calcArea());
    }

    public double distanceFromOrigin()
    {
        double result = 0.0;
        for(int i=1; i<sides-1; i++)
        {
            double test = Math.sqrt((pointArray[0].getX()-pointArray[i].getX())*(pointArray[0].getX()-pointArray[i].getX()) + (pointArray[0].getY()-pointArray[i].getY())*(pointArray[0].getY()-pointArray[i].getY()));
            if(test <= result || result == 0.0)
            {
                result = test;
            }
        }
        return result;
    }

    public double calcArea()
    {
        double area = 0;
        for(int i=0; i<pointArray.length-2; i++)
        {
            area = area + (pointArray[i+1].getX()+pointArray[i].getX()) * (pointArray[i+1].getY()-pointArray[i].getY());
        }
        area = area/2;
        if(area < 0)
        {
            area = -area;
        }
        return area;
    }

    public boolean comesBefore(Polygon input)
    {
        boolean before = false;
        if(Double.compare(this.calcArea(), (input.calcArea()-input.calcArea()*0.05)) < 0)
        {
            before = true;
        }
        else if(Double.compare(this.calcArea(), (input.calcArea()+input.calcArea()*0.05)) > 0)
        {
            before = false;
        }
        else
        {
            if(Double.compare(this.distanceFromOrigin(), (input.distanceFromOrigin())) >= 0)
            {
                before = true;
            }
            else
            {
                before = false;
            }
        }
        return before;
    }
}
