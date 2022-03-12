
/**
 * Defines a Node class, used to traverse an instance of the 
 * MyPolygons linked list
 *
 * Author: Sam Dolbel
 * Date created: 22/3/2019
 * Date modified: 22/3/2019
 */
public class Node
{
    private Node prev;
    private Node next;
    private Polygon data;
    
    public Node(Polygon poly)
    {
        prev = null;
        next = null;
        data = poly;
    }
    
    public Node getNext()
    {
        return next;
    }
    
    public Node getPrev()
    {
        return prev;
    }
    
    public Polygon getData()
    {
        return data;
    }
    
    public void setNext(Node newNext)
    {
        next = newNext;
    }
    
    public void setPrev(Node newPrev)
    {
        prev = newPrev;
    }
    
    public void setData(Polygon newData)
    {
        data = newData;
    }
    
    public void debugPoly()
    {
        data.debugPolygon();
    }
}
