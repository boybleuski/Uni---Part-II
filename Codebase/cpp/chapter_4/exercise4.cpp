#include <iostream>
#include <string>
#include <iomanip>
#include <cmath>

using namespace std;

int main()
{
  const double PI = 3.1416;
  string shape;
  double height;
  double radius;
  double length;
  double width;

  cout << fixed << showpoint << setprecision(2);
  cout << "Enter the shape type: (rectangle, circle, cylinder) ";
  cin >> shape;
  cout << endl;

  if (shape == "rectangle")
  {
    cout << "Enter the length of the rectangle: ";
    cin >> length;
    cout << "Enter the width of the rectangle: ";
    cin >> width;
    cout << "Perimeter of the rectangle = " << 2*(length+width) << endl;
    cout << "Area of the rectangle = " << length*width << endl;
  }

  else if (shape == "circle")
  {
    cout << "Enter the radius of the circle: ";
    cin >> radius;
    cout << "Area of the circle = " << PI*pow(radius,2.0) << endl;
    cout << "Circumference of the circle = " << 2*PI*radius << endl;
  }

  else if (shape == "cylinder")
  {
    cout << "Enter of the radius of the base of the cylinder: ";
    cin >> radius;
    cout << "Enter the height of the cylinder: ";
    cin >> height;
    cout << "Surface area of the cylinder = " << 2*PI*radius*height + 2*PI*pow(radius,2.0) << endl;
    cout << "Volume of the cylinder = " << PI*pow(radius,2.0)*height << endl;
  }

  else
    cout << "The program does not handle " << shape << endl;

  return 0;
}
