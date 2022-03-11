#include <iostream>
#include <cstdlib>
#include <string>
#include "ComparePoly.h"
#include "Point.h"
#include "Polygon.h"

using namespace std;

  int main()
  {
    int numberOfSides;
    cout << "Enter polygon." << endl;
    cin >> numberOfSides;
    Point *point[numberOfSides];

    for (int i=0; i<numberOfSides; i++)
    {
      int x, y;
      cin >> x >> y;
      point[i] = new Point(x,y);
    }

    //Polygon *poly = new Polygon();
    Polygon *poly2 = new Polygon(numberOfSides, &point[numberOfSides]);
    cout << "Point 1 = " << point[0]->output_point() << endl;
    cout << "The distance of point 1 to the origin is " << point[0]->distance_to_origin() << endl;
    cout << "Point 2 = " << point[1]->output_point() << endl;
    cout << "The distance of point 2 to the origin is " << point[1]->distance_to_origin() << endl;
    cout << "Polygon 1: " << poly2->output_polygon() << endl;
    return 0;
  }
