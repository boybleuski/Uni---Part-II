import java.util.PriorityQueue;

public class StorageQueue<E> extends PriorityQueue<E>
{
	private double totalItems = 0;
	private double totalTime = 0;
	private double numberOfRounds = 0; 
	
	public double GetTotalItems()
	{
		return totalItems;
	}
	
	public double GetRounds()
	{
		return numberOfRounds;
	}
	
	public double GetAverage()
	{
		return totalTime/totalItems;
	}
	
	public void AddItems(int items)
	{
		totalItems += items;
	}
	
	public void AddTime(double time)
	{
		totalTime += time;
	}
	
	public void AddRound(int items)
	{
		numberOfRounds += items;
	}
}
