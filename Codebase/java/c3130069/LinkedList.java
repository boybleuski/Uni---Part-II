/**
 * Defines the LinkedList class, a circular doubly-linked list of
 * PlanarShapes.
 *
 * Author: Sam Dolbel
 * Date created: 19/3/2020
 * Date modified: 23/3/2020
 */

import java.util.Iterator;

public class LinkedList<E>
{
	private LLNode sentinel;	// the first and last node in the list
	int count;	// the number of shapes in the list

	public LinkedList()
	{
		count = 0;
	}

	public int Count()	// get number of shapes
	{
		return count;
	}

	public LLNode GetSentinel()	// get the sentinel node, the first node in the list
	{
		return sentinel;
	}

	public void Prepend(LLNode _shape)	// add a node to the start of the list - this will be the new sentinel node
	{
		Append(_shape);
		sentinel = _shape;
	}

	public void Append(LLNode _shape)
	{
		LLNode shape = _shape;
		if (count == 0)	// if list is empty, add the shape
		{
			shape.SetNext(shape);	// if list count = 1, next and previous nodes to sentinel node are still the sentinel node
			shape.SetPrevious(shape);
			sentinel = shape;	// new node becomes sentinel node
		}
		else
		{
			shape.SetPrevious(sentinel.GetPrevious());	// previous node of new node is the old end of the list
			sentinel.GetPrevious().SetNext(shape);	// next node of the old end node is the new node
			sentinel.SetPrevious(shape);	// previous node of the sentinel node is the new node - making the new node the end node
			if (count == 1)
				sentinel.SetNext(shape);	// if list only contains 2 nodes, next node of the sentinel node is the new node

			shape.SetNext(sentinel);	// next node of the new node is the sentinel node
		}
		count++;	// new shape added
	}

	public void Insert(LLNode _shape)
	{
		boolean inserted = false;
		LinkedIterator<LLNode> iterator = new LinkedIterator<LLNode>(sentinel);
		
		do
		{
			if (_shape.GetData().compareTo(iterator.get().GetData()) > -1)
			{
				if (iterator.next() == null)
				{
					Append(_shape);
					inserted = true;
				}
			}
			else
			{
				iterator.add(_shape);
				count++;	// new shape added
				inserted = true;
			}
		}
		while(inserted == false);
 	}

	public LLNode Remove()	// remove the node from the front of the list
	{
		LLNode removedShape = sentinel;
		if(sentinel.GetNext() != null) // check if sentinel node is the last node
		{
			LLNode newSentinel = sentinel.GetNext();
			sentinel.GetPrevious().SetNext(newSentinel);		// next node of the last node becomes the second node in the list
			newSentinel.SetPrevious(sentinel.GetPrevious());	// previous node of the second node becomes the last node in the list
			sentinel = null;		// old sentinel is removed
			sentinel = newSentinel;	// second node becomes new sentinel
		}
		else	// list is now empty - remove all nodes
		    sentinel = null;

		count--;	// shape deleted from list
		return removedShape;	// return the removed shape
	}
	
	public String ToString()
	{
		String listString = this.GetSentinel().GetData().ToString();
		Iterator<LLNode> iterator = new LinkedIterator<LLNode>(sentinel);
		listString += "\n" + this.GetSentinel().GetNext().GetData().ToString();
		while (iterator.hasNext())
		{
			LLNode next = iterator.next();
			listString += "\n" + next.GetData().ToString();
		}
			
		return listString;
	}
}
