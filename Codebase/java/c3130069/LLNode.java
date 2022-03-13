
public class LLNode 
{
	LLNode previous;	// the previous polygon in the list of polygons
	LLNode next;		// the next polygon in the list of polygons
    PlanarShape data;
    
    public LLNode(PlanarShape _data)
    {
    	data = _data;
    }

    public LLNode GetPrevious()	// return the previous polygon in the list of polygons
    {
        if (previous == null)
            return this;
        else
            return previous;
    }

    public LLNode GetNext()	// return the next polygon in the list of polygons
    {
        if (next == null)
            return this;
        else
            return next;
    }

    public PlanarShape GetData()	// return the next polygon in the list of polygons
    {
        if (data == null)
            return null;
        else
            return data;
    }

    public void SetPrevious(LLNode _previous) // set the previous polygon as the parameter in the list of polygons
    {
        previous = _previous;
    }

    public void SetNext(LLNode _next)	// set the next polygon as the parameter in the list of polygons
    {
        next = _next;
    }

    public void SetData(PlanarShape _data)	// set the next polygon as the parameter in the list of polygons
    {
    	data = _data;
    }
}
