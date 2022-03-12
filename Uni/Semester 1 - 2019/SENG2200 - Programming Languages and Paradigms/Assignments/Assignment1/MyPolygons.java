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
    private Node head;
    private Node tail;
    private Node current;
    private Node sentinel;
    
    public MyPolygons()
    {
        polyAmount = 0;
        head = null;
        tail = null;
        current = null;
        sentinel = null;
    }
    
    public Node getHead()
    {
        return head;
    }
    
    public Node getTail()
    {
        return tail;
    }
    
    public Node getCurrent()
    {
        return current;
    }
    
    public void prepend(Polygon newPoly)
    {
        if(sentinel == null)
        {
           sentinel = new Node(newPoly);
           head = sentinel;
           tail = sentinel;
           current = sentinel;
        }
        else
        {
            Node newNode = new Node(newPoly);
            if(head!=null)
            {
                head.setPrev(newNode);
                newNode.setNext(head);
            }
            head = newNode;
        }
        polyAmount++;
    }
    
    public void append(Polygon newPoly)
    {
        if(sentinel == null)
        {
           sentinel = new Node(newPoly);
           head = sentinel;
           tail = sentinel;
           current = sentinel;
        }
        else
        {
            Node newNode = new Node(newPoly);
            if(tail != null)
            {
                tail.setNext(newNode);
                newNode.setPrev(tail);
                tail = newNode;
            }
            else
            {
                tail = newNode;
                head = tail;
                current = head;
            }
        }
        polyAmount++;
    }
    
    public void insert(Polygon newPoly)
    {
        if(current == null || current.getPrev() == null)
        {
            prepend(newPoly);
        }
        else
        {
            Node temp = current.getPrev();
            Node newNode = new Node(newPoly);
            current.setPrev(newNode);
            newNode.setPrev(temp);
            temp.setNext(newNode);
            newNode.setNext(current);
            polyAmount++;
        }
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
    
    public void next()
    {
        if(current != null && current.getNext() != null)
        {
            current = current.getNext();
        }
        else
        {
            current = tail;
        }
    }
    
    public void front()
    {
        current = head;
    }
    
    public void end()
    {
        current = tail;
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
