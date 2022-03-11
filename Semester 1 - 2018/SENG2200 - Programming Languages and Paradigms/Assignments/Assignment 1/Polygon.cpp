#include <iostream>
#include <cstdlib>
#include <string>
#include <sstream>
#include <cmath>
#include "ComparePoly.h"
#include "Point.h"
#include "Polygon.h"

using namespace std;

  int sides;
  Point *newPoint = new Point[10];

  Polygon::Polygon()
  {
    sides = 5;
    int x = 0;
    for(int i=0; i<sides; i++)
    {
      *newPoint[i] = Point(x,x);
      x++;
    }
  }

  Polygon::Polygon(int newSides, Point* point[])
  {
    sides = newSides;
    int x = 1;
    for(int i=0; i<sides; i++)
    {
      *newPoint[i] = *point[i];
      x++;
    }
  }

  string Polygon::output_polygon()
  {
    stringstream xString, yString;
    string polygonString = "";

    for (int i=0; i<sides; i++)
    {
      xString << newPoint[i]->get_x();
      yString << newPoint[i]->get_y();
      polygonString = polygonString + "(" + xString.str() + "," + yString.str() + ")";
      if (i<(sides-1))
      {
        polygonString = polygonString + ", ";
      }
      xString.str("");
      yString.str("");
    }
    return polygonString;
  }
