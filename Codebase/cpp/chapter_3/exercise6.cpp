#include <iostream>
#include <iomanip>
#include <fstream>
#include <string>

using namespace std;

int main()
{
  double mass, density;

  cout << fixed << showpoint << setprecision(2);
  cout << "Input mass, in grams: " << endl;
  cin >> mass;
  cout << "Input density, in grams per cubic centimetres: ";
  cin >> density;

  cout << "Volume = " << mass / density << " cubic centimetres" << endl;
  return 0;
}
