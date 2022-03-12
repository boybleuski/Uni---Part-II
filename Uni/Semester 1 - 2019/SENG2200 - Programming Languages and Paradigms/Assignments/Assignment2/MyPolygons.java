import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Defines a custom Linked List class MyPolygons, to store and manipulate instances of the Polygon class
 *
 * Author: Sam Dolbel
 * Date created: 17/3/2019
 * Date modified: 22/3/2019
 */
public class MyPolygons
{
    private int polyAmount;
    private Node sentinel;

    public MyPolygons()
    {
        polyAmount = 0;
        sentinel = null;
    }

    public Node getSentinel()
    {
        return sentinel;
    }

    public void prepend(Polygon newPoly)
    {
        if(sentinel == null)
           sentinel = new Node(newPoly);
        else
        {
            Node newNode = new Node(newPoly);
            sentinel.setPrev(newNode);
            newNode.setNext(sentinel);
        }
        polyAmount++;
    }

    public void append(Polygon newPoly)
    {
      if(sentinel == null)
         sentinel = new Node(newPoly);
      else
      {
          Node newNode = new Node(newPoly);
          sentinel.setNext(newNode);
          newNode.setPrev(sentinel);
      }
      polyAmount++;
    }

    public Polygon take()
    {
        Polygon headPoly = head.getData();
        front();
        if(current.getNext() != null)
        {
            next();
            head = null;
            current.setPrev(null);
            head = current;
        }
        else
        {
            head = null;
            tail = null;
            current = null;
        }
        polyAmount--;
        return headPoly;
    }

    public int listSize()
    {
        return polyAmount;
    }
    
    public void debugList()
    {
        front();
        while (current!=null)
        {
            current.debugPoly();
            current = current.getNext();
        }

        System.out.println("Number of polygons: " + polyAmount);
    }
}
