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
        Polygon sentinelPoly = sentinel.getData();
        if(sentinel.getNext() != null)
        {
            sentinel.getNext().setPrev(null);
            sentinel = sentinel.getNext();
        }
        else
            sentinel = null;
        polyAmount--;
        return headPoly;
    }

    public int listSize()
    {
        return polyAmount;
    }

    public void debugList()
    {
        while (sentinel!=null)
        {
            sentinel.debugPoly();
            sentinel = sentinel.getNext();
        }

        System.out.println("Number of polygons: " + polyAmount);
    }
}
