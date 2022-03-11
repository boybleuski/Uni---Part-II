import java.util.Random;
import java.util.List;
import java.util.PriorityQueue;

public class ProductStage 
{
	private Boolean starved;
	private Boolean blocked;
	private int prevQueue;
	private int nextQueue;
	private double timeStarved;
	private double timeBlocked;
	private double timeElapsed;
	private double m;
	private double n;
	private String stageName;
	private Random rnd;
	private Item processing;
		
	public ProductStage(Boolean _isBlocked, Boolean _isStarved, double _m, double _n,
						String _stageName, int _prevQueue, int _nextQueue)
	{
		starved = _isStarved;
		blocked = _isBlocked;
		timeStarved = 0;
		timeBlocked = 0;
		m = _m;
		n = _n;
		stageName = _stageName;
		prevQueue = _prevQueue;
		nextQueue = _nextQueue;
		rnd = new Random();
	}
	
	public double GetWorkTime()
	{
		return m;
	}
	
	public String GetStageName()
	{
		return stageName;
	}
	
	public int GetPrevQueue()
	{
		return prevQueue;
	}
	
	public int GetNextQueue()
	{
		return nextQueue;
	}
	
	public void Starve()
	{
		starved = true;
	}
	
	public void Unstarve()
	{
		starved = false;
	}
	
	public Boolean Starved()
	{
		return starved;
	}
	
	public void Block()
	{
		blocked = true;
	}
	
	public void Unblock()
	{
		blocked = false;
	}
	
	public Boolean Processing()
	{
		if (processing == null)
			return false;
		else
			return true;
	}
	
	public Boolean Blocked()
	{
		return blocked;
	}
	
	public double GetBlockTime()
	{
		return timeBlocked;
	}
	
	public double GetStarveTime()
	{
		return timeStarved;
	}
	
	public double GetElapsedTime()
	{
		return timeElapsed;
	}
	
	public void TimeBlocked(double _timeBlocked)
	{
		timeBlocked += _timeBlocked;
	}
	
	public void TimeStarved(double _timeStarved)
	{
		timeStarved += _timeStarved;
	}
	
	public void TimeElapsed(double _timeElapsed)
	{
		timeElapsed += _timeElapsed;
	}
	
	public Item FinishProcessing(double _currentRound, double _currentTime)
	{
		if (timeElapsed < _currentTime)
		{
			if (blocked || starved)
			{
				if (blocked)
					TimeBlocked(_currentRound);
				if (starved)
					TimeStarved(_currentRound);
				TimeElapsed(_currentRound);
				return null;
			}
			Item processed = processing;
			processing = null;
			return processed;
		}
		TimeElapsed(_currentRound);
		return null;
	}
	
	public void Process(Item item, double _currentRound)
	{
		double processTime = m+n*(rnd.nextDouble() - 0.5);
		
		if (blocked)
			TimeBlocked(_currentRound);
		if (starved)
			TimeStarved(_currentRound);
		
		if (item != null)
		{
			processing = item;
			processing.FillStages(stageName);
			processing.AddToTime(processTime);
			TimeElapsed(processTime);
		}
		TimeElapsed(_currentRound);
	}
}
