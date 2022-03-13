
public abstract class PlanarShape implements Comparable<PlanarShape>
{
    protected final double PI = 3.141;
    public abstract String ToString();
    public abstract double Area();
    public abstract double OriginDistance();

    public int compareTo(PlanarShape _shape)
    {
        if (Double.compare(this.Area(), _shape.Area()) < 0)	// check if this polygon is smaller than the parameter polygon
        {
            if (Double.compare((_shape.Area() - this.Area()), (this.Area()/1000)) < 0)	// check if the difference between the areas is < 0.1%
            {
                if (Double.compare(this.OriginDistance(), _shape.OriginDistance()) < 0)	// if difference is < 0.1%, check which polygon has a point closest to the origin
                    return -1;	// this is smaller
                else
                    return 1;	// parameter is smaller
            }
            else
                return -1;	// this is smaller
        }
        else
        {
            if (Double.compare((this.Area() - _shape.Area()), (_shape.Area()/1000)) < 0)	// check if the difference between the areas is less than 0.1%
            {
                if (Double.compare(this.OriginDistance(), _shape.OriginDistance()) < 0)	// if difference is < 0.1%, check which polygon has a point closest to the origin
                    return -1;	// this is smaller
                else
                    return 1;	// parameter is smaller
            }
            else
                return 1;	// parameter is smaller
        }
    }
}