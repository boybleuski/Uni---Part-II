import java.lang.Math;
import java.text.DecimalFormat;
/**
 * Defines a Point on a Cartesian graph
 *
 * Author: Sam Dolbel
 * Date created: 12/3/2019
 * Date modified: 12/3/2019
 */
public class Point
{
    private double x;
    private double y;

    /* Constructors */
    public Point()
    {
        x = 0;
        y = 0;
    }
    
    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public String toString()
    {
        return (this.x + "," + this.y);
    }
    
    public double getX()
    {
        return this.x;
    }
    
    public double getY()
    {
        return this.y;
    }
}
