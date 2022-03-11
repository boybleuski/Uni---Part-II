#include <iostream>
#include <cstdlib>
#include <string>
#include <sstream>
#include <cmath>
#include "ComparePoly.h"
#include "Point.h"
#include "Polygon.h"

using namespace std;

  float x;
  float y;

  Point::Point()
  {
    x=0.0;
    y=0.0;
  }

  Point::Point(float newX, float newY)
  {
    x=newX;
    y=newY;
  }

  float Point::get_x()
  {
    return x;
  }

  float Point::get_y()
  {
    return y;
  }

  string Point::output_point()
  {
    stringstream xString, yString;
    string pointString;
    xString << x;
    yString << y;
    pointString = "(" + xString.str() + "," + yString.str() + ")";
    return pointString;
  }

  float Point::distance_to_origin()
  {
    float distance;
    distance = sqrt((x*x)+(y*y));
    return distance;
  }
