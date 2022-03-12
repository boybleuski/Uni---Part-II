#ifndef SAM_POINT
#define SAM_POINT
#include <iostream>
#include <cstdlib>
#include <string>
#include <sstream>
#include <cmath>
#include "ComparePoly.h"

using namespace std;

class Point
{
  public:
    Point();
    Point(float,float);
    float get_x();
    float get_y();
    string output_point();
    float distance_to_origin();

  private:
    float x;
    float y;
};
#endif
