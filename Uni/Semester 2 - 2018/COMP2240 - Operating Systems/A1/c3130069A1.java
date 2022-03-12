/*
    Writtem by: Sam Dolbel
    Last modified: 7/9/2018
    Class: Thursday 9-11am
    SENG2240 Assignment 1 - program that simulates the functionality of four scheduling algorithms:
      - simulates FCFS, Round Robin, Feedback constant & Narrow Round Robin
      - outputs each process ID, arrival time, service time, starting time, waiting time, turnabout time
*/
import java.util.*;
import java.io.*;

public class c3130069A1
{
  public static void fcfs(String[] id, int[] arrive, int[] execSize, int count)
  {
    for
  }

  public static void round_robin(String[] id, int[] arrive, int[] execSize, int count)
  {

  }

  public static void feedback_constant(String[] id, int[] arrive, int[] execSize, int count)
  {

  }

  public static void narrow_rr(String[] id, int[] arrive, int[] execSize, int count)
  {

  }

  public static void main (String[] args) throws IOException
  {
     Scanner keyboard = new Scanner(System.in);
     Scanner inputStream = new Scanner(new File("datafile1.txt"));
     int disp = 0, count = 0;
     int[] arrive = new int[5], execSize = new int[5];
     String[] id = new String[5];

     try
     {
        String line = "", holder = "";

        while (inputStream.hasNext()) //read a file and extract the important variables
        {
           if (line.equals("DISP:"))
              disp = Integer.parseInt(inputStream.next());
           if (line.equals("ID:"))
           {
              holder = inputStream.next();
              id[count] = holder;
           }
           if (line.equals("Arrive:"))
           {
              holder = inputStream.next();
              arrive[count] = Integer.parseInt(holder);
           }
           if (line.equals("ExecSize:"))
           {
              holder = inputStream.next();
              execSize[count] = Integer.parseInt(holder);
              count++;
           }
           line = inputStream.next();
        }
     }
     finally
     {
        if (inputStream != null)
           inputStream.close();
     }

     fcfs(id, arrive, execSize, count);
     round_robin(id, arrive, execSize, count);
     feedback_constant(id, arrive, execSize, count);
     narrow_rr(id, arrive, execSize, count);
  }
}
