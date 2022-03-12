
#include <iostream>
#include <cstdlib>

using namespace std;

class point
{
   point();
   point(double,double);
   
   void setX();
   void setY();
   double const getX();
   double const getY();
}

//Friend functions
ostream operator << (ostream , point& p);
{
   
}