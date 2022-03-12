#include <iomanip>
#include <cmath>
#include <iostream>

using namespace std;

int main()
{
  const double PI = 3.14159;
  double height;
  double radius;

  cout << fixed << showpoint << setprecision(2);
  cout << "Enter the height of the cylinder: " << endl;
  cin >> height;
  cout << endl;
  cout << "Enter the radius of the base of the cylinder: " << endl;
  cin >> radius;
  cout << endl;

  cout << "Surface area: "
       << 2 * PI * radius * height + 2 * PI * pow(radius, 2.0)
       << endl;
  cout << "Volume of the cylinder: "
       << PI * pow(radius, 2.0) * height << endl;
  return 0;
}
