#ifndef SAM_POLYGON
#define SAM_POLYGON
#include <iostream>
#include <cstdlib>
#include <string>
#include <sstream>
#include <cmath>
#include "ComparePoly.h"
#include "Point.h"

using namespace std;

class Polygon
{
  public:
    Polygon();
    //Polygon(int, Point*[]);
    string output_polygon();

  private:
    int sides;
    Point *newPoint[];

};
#endif
