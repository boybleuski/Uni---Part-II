/**
 * The main class of Assignment 2 - SENG2200
 *
 * Author: Sam Dolbel
 * Date created: 18/3/2020
 * Date modified: 15/5/2020
 */

import java.util.Iterator;
import java.util.Scanner;
import java.io.*;

public class PA2
{
  public static void main(String[] args)
  {
    File file = new File(args[0]);	// define a file - filename is current directory + the user's input
    Scanner fileScan = null;	// the file scanner
    try
    {
      fileScan = new Scanner(file);
    }
    catch (FileNotFoundException ex)	// only allow existing files
    {
      System.out.println("File not found!");
      System.exit(0);	// abort program if filename is invalid
    }

    LinkedList<LLNode> shapeList = new LinkedList<LLNode>();	// the list of unsorted shapes
    while(fileScan.hasNext())	// check if file contains anymore non-whitespace characters
    {
      String next = fileScan.next();
      if (next.equals("P"))	// only valid character at this stage is "P", which defines a new polygon
      {
        int pointCount = fileScan.nextInt();	// next integer is the number of points of the polygon
        Polygon newShape = new Polygon(pointCount+1);	// number of points + 1
        Point[] points = new Point[pointCount+1];
        for (int i=0; i<pointCount; i++)
          points[i] = new Point(fileScan.nextDouble(), fileScan.nextDouble());	// read the x & y coordinates and create the new point

        points[pointCount] = points[0]; // the last point of the polygon is a copy of the first
        newShape.AddPoints(points);	    // add the array of points to the polygon
        LLNode newLLNode = new LLNode(newShape);
        shapeList.Append(newLLNode);	    // add the polygon to the linked list
      }
      else if (next.equals("C"))
      {
        Point originPoint = new Point(fileScan.nextDouble(), fileScan.nextDouble());  // read the x & y coordinates and create the origin point
        double radius = fileScan.nextDouble(); // radius of the circle
        Circle newShape = new Circle(originPoint, radius);
        LLNode newLLNode = new LLNode(newShape);
        shapeList.Append(newLLNode);	    // add the circle to the linked list
      }
      else if (next.equals("S"))
      {
        Point originPoint = new Point(fileScan.nextDouble(), fileScan.nextDouble());  // read the x & y coordinates and create the origin point
        Point outerPoint = new Point(fileScan.nextDouble(), fileScan.nextDouble());   // read the x & y coordinates and create the intersecting point
        SemiCircle newShape = new SemiCircle(originPoint, outerPoint);
        LLNode newLLNode = new LLNode(newShape);
        shapeList.Append(newLLNode);	    // add the semi-circle to the linked list
      }
    }

    System.out.println("\nUnsorted list");
    System.out.println(shapeList.ToString());	// iterate through the linked list - print the entire unsorted list of polygons
    
    LinkedList<LLNode> sortedList = new LinkedList<LLNode>();	// the list of polygons sorted by size
    
    do
    {
        LLNode shape = shapeList.Remove();	// take a LLNode from the front of the unsorted list

        int sortedCount = sortedList.Count();	// count the number of polygons in the sorted list
        if (sortedCount == 0)
        	sortedList.Append(shape);	// if the list is empty, Append() can start a new list
        else
        {
      		if (shape.GetData().Area() < sortedList.GetSentinel().GetData().Area())
      			sortedList.Prepend(shape);		// prepend to the start of the list if the new polygon is smaller than any polygon in the list
      		else
      			sortedList.Insert(shape);	    // insert between the current and previous LLNode if it is neither the smallest nor the largest
        }
    }
    while(shapeList.Count() > 0);	// keep going until the unsorted list is empty
    
    System.out.println("\nSorted list");
    System.out.println(sortedList.ToString());	// iterate through the linked list - print the entire unsorted list of polygons
  }
}