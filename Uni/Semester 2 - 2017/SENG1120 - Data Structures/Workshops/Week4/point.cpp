

#include "point.h"
#include <iostream>
#include <cmath>

#ifndef POINT
#define POINT

using namespace Lab3;
using namespace std;

class point;
{
   double x;
   double y;
   
   point::point()
   {
      x = 0;
      y = 0;
   }
   
   point::point(double init_x, double init_y)
   {
      x = init_x;
      y = init_y;	  
   }
   
   void point::setX(double new_x)
   {
      x = new_x;
   }
   
   void point::setY(double new_y)
   {
      y = new_y;
   }
   
   double point::getX()
   {
      return x;
   }
   
   double point::getY()
   {
      return y;
   }
};

ostream operator << (ostream outs, point& p);
{
   return outs << "(" << point.getX() << "," << point.getY() << ")"
}
#endif