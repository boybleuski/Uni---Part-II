import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Main interface for Assignment1
 *
 * Author: Sam Dolbel
 * Date created: 12/3/2019
 * Date modified: 22/3/2019
 */
public class PA1
{
    public static void main(String[] args)
    {
        String fileName = args[0];
        Scanner output = new Scanner(System.in);
        Scanner instream = null;
        MyPolygons inputList = new MyPolygons();
        MyPolygons sortedList = new MyPolygons();

        try
        {
            instream = new Scanner(new File(fileName));
        }
        catch(FileNotFoundException f)
        {
            System.out.println("File not found.");
            System.exit(0);
        }
        while (instream.hasNext())
        {
            String newPoly = instream.next();
            int sides = instream.nextInt();
            Polygon poly = new Polygon(sides+1);
            for (int i=0; i<sides; i++)
            {
                double x = instream.nextDouble();
                double y = instream.nextDouble();
                poly.addPoint(x, y, i);
            }
            poly.addPoint(poly.getPoint(0).getX(), poly.getPoint(0).getY(), poly.getSides()-1);
            inputList.append(poly);
        }
        inputList.debugList();
        Polygon sortPoly = inputList.take();
        sortedList.insert(sortPoly);
        do
        {
                sortedList.front();
                sortPoly = inputList.take();
                do
                {
                    if(sortedList.getCurrent() != null && sortPoly.comesBefore(sortedList.getCurrent().getData()))
                    {
                        sortedList.insert(sortPoly);
                        System.out.println("Sorted: " + sortedList.listSize() + "Input:  " + inputList.listSize());
                        sortedList.debugList();
                        inputList.debugList();
                    }
                    else if(sortedList.getCurrent() != null && sortedList.getCurrent().getNext() == null)
                    {
                        sortedList.append(sortPoly);
                        System.out.println("Ended...");
                        sortedList.end();
                    }
                    else
                    {
                        sortedList.next();
                        System.out.print(" Next... ");
                    }
                }
                while(sortedList.getCurrent() != sortedList.getTail());
        }
        while(inputList.listSize() != 0);
        sortedList.debugList();
    }
}
