import java.util.ListIterator;

public class LinkedIterator<E> implements ListIterator<LLNode>
{
	private int currentIndex;
	private LLNode head;
	
	public LinkedIterator(LLNode _head)
	{
		head = _head;
	}
	
	public boolean hasNext() 
	{
		return get().GetNext() != head;
	}

	public LLNode next()
	{
		LLNode obj = head;
		if (hasNext() == false)
			return null;
		else
		{
			currentIndex++;
			return get();
		}
	}
	
	public LLNode get()
	{
		LLNode obj = head;
		for (int i=-1; i<currentIndex; i++)
			obj = obj.GetNext();
		return obj;
	}

	public void add(LLNode _obj)
	{
		LLNode obj = _obj;
		LLNode beforeObj = get().GetPrevious();
		LLNode afterObj = get();
		afterObj.SetPrevious(obj);
		beforeObj.SetNext(obj);
		obj.SetPrevious(beforeObj);
		obj.SetNext(afterObj);
	}

	@Override
	public void remove() { }

	@Override
	public boolean hasPrevious() { return false; }

	@Override
	public LLNode previous() { return null; }

	@Override
	public int nextIndex() { return 0; }

	@Override
	public int previousIndex() { return 0; }
	
	@Override
	public void set(LLNode e) {	}
}
