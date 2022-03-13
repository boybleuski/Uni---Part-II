/**
 * Defines a Polygon class - a series of Cartesian points and references
 * to other Polygons in a linked list class
 *
 * Author: Sam Dolbel
 * Date created: 19/3/2020
 * Date modified: 22/3/2020
 */
import java.lang.Math;

public class Polygon implements ComparePoly
{
  Point[] points;	// the array of points
  int pointCount;	// the number of points
  Polygon previous;	// the previous polygon in the list of polygons
  Polygon next;		// the next polygon in the list of polygons

  public Polygon()
  {
	  pointCount = 0;
  }

  public Polygon(int _pointCount)
  {
    pointCount = _pointCount;
    points = new Point[pointCount];
  }

  public Polygon GetPrevious()	// return the previous polygon in the list of polygons
  {
    if (previous == null)
      return this;
    else
      return previous;
  }

  public Polygon GetNext()	// return the next polygon in the list of polygons
  {
    if (next == null)
      return this;
    else
      return next;
  }

  public void SetPrevious(Polygon _previous) // set the previous polygon as the parameter in the list of polygons
  {
    previous = _previous;
  }

  public void SetNext(Polygon _next)	// set the next polygon as the parameter in the list of polygons
  {
    next = _next;
  }

  public void AddPoints(Point[] _points)	// add the array of points
  {
    points = _points;
  }

  public double Area()	// get the size in area of the polygon
  {
    double area = 0;
    for (int i=0; i<pointCount-1; i++)
    {
      area = area + ((points[i].GetX() * points[i+1].GetY()) - (points[i].GetY() * points[i+1].GetX()));	// Cartesian formula for the area of a polygon
    }

    if (area < 0)
      area = -area;	// get the absolute value of the area

    return area/2;	// finish the formula and return the final area
  }

  public double DistanceFromOrigin()	// get the distance of the closest point from the origin
  {
    double distance = 0;
    for (int i=0; i<points.length; i++)	// get the distance with the mighty power of Pythagoras
    {
      double tempDistance = Math.sqrt(points[i].GetX()*points[i].GetX() + points[i].GetY()*points[i].GetY());
      if (distance == 0 || tempDistance < distance)
        distance = tempDistance;
    }
    return distance;
  }

  public String ToString()	// return the polygon as a string - points are printed with Point.ToString() and area is rounded to two decimal places
  {
    String polygonString = "[";	// opening brace that starts an array
    for (int i=0; i<points.length-1; i++)	// append each consecutive point to the string
    {
      polygonString += points[i].ToString();
    }

    polygonString += ("]: " + String.format("%6.2f", Area()));	// closing brace that ends an array + polygon area
    return polygonString;
  }

  public boolean ComesBefore(Polygon _polygon)
  {
    if (Double.compare(this.Area(), _polygon.Area()) < 0)	// check if this polygon is smaller than the parameter polygon
    {
      if (Double.compare((_polygon.Area() - this.Area()), (this.Area()/1000)) < 0)	// check if the difference between the areas is < 0.1%
      {
        if (Double.compare(this.DistanceFromOrigin(), _polygon.DistanceFromOrigin()) < 0)	// if difference is < 0.1%, check which polygon has a point closest to the origin
          return true;	// this is smaller
        else
          return false;	// parameter is smaller
      }
      else
        return true;	// this is smaller
    }
    else
    {
      if (Double.compare((this.Area() - _polygon.Area()), (_polygon.Area()/1000)) < 0)	// check if the difference between the areas is less than 0.1%
      {
        if (Double.compare(this.DistanceFromOrigin(), _polygon.DistanceFromOrigin()) < 0)	// if difference is < 0.1%, check which polygon has a point closest to the origin
          return true;	// this is smaller
        else
          return false;	// parameter is smaller
      }
      else
        return false;	// parameter is smaller
    }
  }
}
