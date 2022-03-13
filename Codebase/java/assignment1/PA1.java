/**
 * The main class of Assignment 1 - SENG2200
 *
 * Author: Sam Dolbel
 * Date created: 18/3/2020
 * Date modified: 23/3/2020
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class PA1
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

    MyPolygons polygonList = new MyPolygons();	// the list of unsorted polygons
    while(fileScan.hasNext())	// check if file contains anymore non-whitespace characters
    {
      String next = fileScan.next();
      if (next.equals("P"))	// only valid character at this stage is "P", which defines a new polygon
      {
        int pointCount = fileScan.nextInt();	// next integer is the number of points of the polygon
        Polygon newPolygon = new Polygon(pointCount+1);	// number of points + 1
        Point[] points = new Point[pointCount+1];
        for (int i=0; i<pointCount; i++)
        {
          double x = fileScan.nextDouble();	// x-coordinate of the point
          double y = fileScan.nextDouble();	// y-coordinate of the point
          points[i] = new Point(x, y);	// create the new point
        }
        points[pointCount] = points[0]; // the last point of the polygon is a copy of the first
        newPolygon.AddPoints(points);	// add the array of points to the polygon
        polygonList.Append(newPolygon);	// add the polygon to the linked list
      }
    }

    polygonList.Reset();	// return to the start of the list (sentinel node)
    System.out.println("\nUnsorted list");
    for (int i=0; i<polygonList.Count(); i++)	// iterate through the linked list - print the entire unsorted list of polygons
    {
      System.out.println(polygonList.GetCurrent().ToString());	// output the polygon (as a string) to the console
      polygonList.Next();	// get the next node in the list
    }

    MyPolygons sortedList = new MyPolygons();	// the list of polygons sorted by size
    polygonList.Reset();	// return to the sentinel node
    do
    {
      Polygon polygon = new Polygon();
      polygon = polygonList.Remove();	// take a node from the front of the unsorted list

      int sortedCount = sortedList.Count();	// count the number of polygons in the sorted list
      if (sortedCount == 0)
        sortedList.Append(polygon);	// if the list is empty, Append() can start a new list
      else
      {
        boolean inserted = false;	// determines whether the node taken from the unsorted list has been inserted into the sorted list
        do
        {
          if (polygon.ComesBefore(sortedList.GetCurrent()))	// check if the new polygon to be inserted is smaller than the currently selected polygon
          {
            if (polygon.Area() < sortedList.GetSentinel().Area())
              sortedList.Prepend(polygon);	// prepend to the start of the list if the new polygon is smaller than any polygon in the list
            else
              sortedList.Insert(polygon);	// insert between the current and previous node if it is neither the smallest nor the largest

            inserted = true;	// polygon has been inserted
          }
          else if (sortedList.GetCurrent().GetNext() == sortedList.GetSentinel())	// check if current node is at the end of the list and is therefore the largest
          {
            sortedList.Append(polygon);	// append to the end of the list is the new polygon is larger than any polygon in the list
            inserted = true;	// polygon has been inserted
          }
          else
            sortedList.Next();	// move to the next node if the new polygon cannot be inserted yet
        }
        while (inserted == false);
      }
    }
    while(polygonList.Count() > 0);	// keep going until the unsorted list is empty

    sortedList.Reset();	// return to the sentinel node
    System.out.println("\nSorted list");
    for (int i=0; i<sortedList.Count(); i++)	// iterate through the linked list - print the entire sorted list of polygons
    {
      System.out.println(sortedList.GetCurrent().ToString());	// output the polygon (as a string) to the console
      sortedList.Next();	// get the next node in the list
    }
  }
}
