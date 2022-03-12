import java.text.DecimalFormat;
import java.util.Random;
import java.util.Iterator;

public class PA3 
{
	public static final double END_TIME = 10000000;
	public static Random r = new Random();
	
	public static void main(String[] args) 
	{
		double m = Double.parseDouble(args[0]);
		double n = Double.parseDouble(args[1]);
		int qMax = Integer.parseInt(args[2]);
		int[] prodPaths = new int[4];
		double currentTime = 0;
		
		ProductStage[] prodS = new ProductStage[8];
		prodS[0] = new ProductStage(true, false, m, n, "0", 0, 1);
		
		StorageQueue<Item>[] prodQ = new StorageQueue[6];

		prodQ[0] = new StorageQueue<Item>(); // unlimited start
		prodQ[prodQ.length-1] = new StorageQueue<Item>(); // unlimited finish
		for (int i = 1; i < prodQ.length-1; i++) 
			prodQ[i] = new StorageQueue<Item>();
		
		int stageLoc = 1;
		for (int i = 1; i < prodS.length; i++)
		{
			if(prodS[i-1].GetWorkTime() == m && i != 1)
			{
				prodS[i] = new ProductStage(false, true, m*2, n, Integer.toString(stageLoc)+"a", stageLoc, stageLoc+1);
				i++;
				prodS[i] = new ProductStage(false, true, m*2, n, Integer.toString(stageLoc)+"b", stageLoc, stageLoc+1);
			}
			else
				prodS[i] = new ProductStage(false, true, m, n, Integer.toString(stageLoc), stageLoc, stageLoc+1);
			stageLoc++;
		}
		
		do
		{
			double currentRound = m+n*(r.nextDouble()-0.5);
			for (int j = 0; j < prodS.length; j++)
			{
				int prevQueue = 0;
				int nextQueue = 0;
				if (prodS[j].GetElapsedTime() < currentTime)
				{
					if (j != 0)
						prevQueue = prodS[j].GetPrevQueue();
					
					if (j != prodS.length-1)
						nextQueue = prodS[j].GetNextQueue();
					
					if (j == 0)
					{
						Item newItem = new Item(r.nextDouble());
						
						if (prodQ[nextQueue].size() == qMax)
							prodS[j].Block();
						else
							prodS[j].Unblock();
						
						if (prodS[j].Processing())
						{
							Item moveItem = prodS[j].FinishProcessing(currentRound, currentTime);
							if (moveItem != null)
							{
								moveItem.SetQueueTime(0);
								prodQ[nextQueue].add(moveItem);
							}
						}
						if (!prodS[j].Processing())
						{
							if (prodS[j].Blocked())
								prodS[j].Process(null, currentRound);
							else
								prodS[j].Process(newItem, currentRound);
						}
					}
					else if (j == prodS.length-1) 
					{
						if (prodQ[prevQueue].size() == 0)
							prodS[j].Starve();
						else
							prodS[j].Unstarve();
						
						if (prodS[j].Processing())
						{
							Item moveItem = prodS[j].FinishProcessing(currentRound, currentTime);
														
							if (moveItem != null)
							{
								for (int i = 1; i < prodQ.length-1; i++)
								{
									prodQ[i].AddTime(moveItem.GetTime(i-1));
								}
								
								if (moveItem.GetStages().contains("2a"))
								{
									if (moveItem.GetStages().contains("4a"))
										prodPaths[0]++;
									else
										prodPaths[1]++;
								}
								else
								{
									if (moveItem.GetStages().contains("4a"))
										prodPaths[2]++;
									else
										prodPaths[3]++;
								}
							}
						}
						if (!prodS[j].Processing())
						{
							if (prodS[j].Starved())
								prodS[j].Process(null, currentRound);
							else
							{
								Item moveItem = prodQ[prevQueue].poll();
								prodS[j].Process(moveItem, currentRound);
							}
						}
					}
					else
					{
						if (prodQ[prevQueue].size() == 0) // Ensure that the preceding queue is not empty - avoid NullReference
							prodS[j].Starve();
						else
							prodS[j].Unstarve();
						
						if (prodQ[nextQueue].size() == qMax)
							prodS[j].Block();
						else
							prodS[j].Unblock();

						if (prodS[j].Processing())
						{
							Item moveItem = prodS[j].FinishProcessing(currentRound, currentTime);
							if (moveItem != null)
							{
								moveItem.SetQueueTime(0);
								prodQ[nextQueue].add(moveItem);
							}
						}
						if (!prodS[j].Processing())
						{
							if (prodS[j].Blocked() || prodS[j].Starved())
								prodS[j].Process(null, currentRound);
							else
							{	
								Item moveItem = prodQ[prevQueue].poll();
								prodS[j].Process(moveItem, currentRound);
							}
						}
					}
				}
			}
			currentTime += currentRound;
			for (int k = 0; k < prodQ.length; k++)
			{
				Iterator<Item> iter = prodQ[k].iterator();
				while (iter.hasNext())
				{
					iter.next().SetQueueTime(currentRound);
				}
				prodQ[k].AddRound(1);
				prodQ[k].AddItems(prodQ[k].size());
			}
		}
		while(currentTime < END_TIME);
		
		DecimalFormat dec = new DecimalFormat("#0.00");
		
		System.out.printf("Production Stations:\n--------------------------------------------\n");
		System.out.printf("%-5s %12s %12s %12s %n", "Stage", "Work[%]", "Starve[t]", "Block[t]");
		for(int i = 0; i < prodS.length; i++)
			System.out.printf("%-5s %12s %12s %12s %n", prodS[i].GetStageName(), dec.format((100 - ((prodS[i].GetStarveTime() + prodS[i].GetBlockTime()) / END_TIME) * 100)), dec.format(prodS[i].GetStarveTime()), dec.format(prodS[i].GetBlockTime()));
		
		System.out.printf("\nStorage Queues:\n--------------------------------------------\n");
		System.out.printf("%-5s %12s %12s %n", "Store", "AvgTime[t]", "AvgItems");
		for(int i = 1; i < 6; i++)
		{
			String queueName = "Q" + i;
			System.out.printf("%-5s %12s %12s %n", queueName, dec.format(prodQ[i].GetAverage()), dec.format(prodQ[i].GetTotalItems()/prodQ[i].GetRounds()));
		}
		
		System.out.printf("\nProduction Paths:\n--------------------------------------------\n");
		System.out.printf("%-15s %12s %n", "S2a -> S4a", prodPaths[0]);
		System.out.printf("%-15s %12s %n", "S2a -> S4b", prodPaths[1]);
		System.out.printf("%-15s %12s %n", "S2b -> S4a", prodPaths[2]);
		System.out.printf("%-15s %12s %n", "S2b -> S4b", prodPaths[3]);
		
	}
}
