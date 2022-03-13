/**
 * Defines the MyPolygons class, a circular doubly-linked list of
 * Polygons.
 *
 * Author: Sam Dolbel
 * Date created: 19/3/2020
 * Date modified: 23/3/2020
 */
public class MyPolygons
{
  Polygon sentinel;	// the first and last node in the list
  Polygon current;	// the currently selected node in the list
  int count;	// the number of polygons in the list

  public MyPolygons()
  {
    count = 0;
  }

  public int Count()	// get number of polygons
  {
    return count;
  }

  public Polygon GetCurrent()	// get currently selected node
  {
    return current;
  }

  public Polygon GetSentinel()	// get the sentinel node, the first node in the list
  {
    return sentinel;
  }

  public void Prepend(Polygon _polygon)	// add a node to the start of the list - this will be the new sentinel node
  {
    if (count == 0)
    {
      Append(_polygon);	// if list is empty, append the polygon rather than prepend or insert
    }
    else
    {
      Polygon polygon = new Polygon();	// create a new polygon
      polygon = _polygon;
      polygon.SetPrevious(sentinel.GetPrevious());	// previous node of the new sentinel node is the end of the list
      sentinel.SetPrevious(polygon);	// previous node of the old sentinel node is the new sentinel node
      if (count == 1)
        sentinel.SetNext(polygon);	// if list only contains 2 nodes, next node of the old sentinel node is the new node

      polygon.SetNext(sentinel); //next node of the new sentinel node is the old sentinel node
      sentinel = polygon;	// make new node the sentinel node
      Reset();	// return current node to the start of the list
      count++;	// new polygon added
    }
  }

  public void Append(Polygon _polygon)
  {
    Polygon polygon = new Polygon();
    polygon = _polygon;
    if (count == 0)	// if list is empty, add the polygon
    {
      sentinel = new Polygon();	// the starting node of the list
      current = new Polygon();	// current node needs to be added to the heap, otherwise it will just be a reference to the sentinel node
      polygon.SetNext(polygon);	// if list count = 1, next and previous nodes to sentinel node are still the sentinel node
      polygon.SetPrevious(polygon);
      sentinel = polygon;	// new node becomes sentinel node
    }
    else
    {
      polygon.SetPrevious(sentinel.GetPrevious());	// previous node of new node is the old end of the list
      sentinel.GetPrevious().SetNext(polygon);	// next node of the old end node is the new node
      sentinel.SetPrevious(polygon);	// previous node of the sentinel node is the new node - making the new node the end node
      if (count == 1)
        sentinel.SetNext(polygon);	// if list only contains 2 nodes, next node of the sentinel node is the new node

      polygon.SetNext(sentinel);	// next node of the new node is the sentinel node
    }
	Reset();	// return current node to the start of the list
    count++;	// new polygon added
  }

  public void Insert(Polygon _polygon)
  {
    Polygon temp = current.GetPrevious();	// get a temporary reference to the node before the current node for convenience
    Polygon polygon = new Polygon();
    polygon = _polygon;
    polygon.SetPrevious(temp); 	// previous node of the new node is the node that used to be previous to the current node
    current.SetPrevious(polygon);	// previous node of the current node is the new node
    temp.SetNext(polygon);	// next node of the node formerly previous to the current node is the new node
    polygon.SetNext(current);	// next node of the new node is the current node
    count++;	// new polygon added
  }

  public void Next()	// make current node the next node in the list
  {
    current = current.GetNext();
  }

  public void Reset()	// return the current node to the beginning of the list
  {
    current = sentinel;
  }

  public Polygon Remove()	// remove the node from the front of the list
  {
    Reset();	// return current node to the start of the list
    Polygon removedPolygon = sentinel;
    if(sentinel.GetNext() != null) // check if sentinel node is the last node
    {
        Next();	// move to the next node
        sentinel.GetPrevious().SetNext(current);	// next node of the last node becomes the second node in the list
        current.SetPrevious(sentinel.GetPrevious());	// previous node of the second node becomes the last node in the list
        sentinel = null;	// old sentinel is removed
        sentinel = current;	// second node becomes new sentinel
    }
    else	// list is now empty - remove all nodes
    {
        sentinel = null;
        current = null;
    }
    count--;	// polygon deleted from list
    return removedPolygon;	// return the removed polygon
  }
}
