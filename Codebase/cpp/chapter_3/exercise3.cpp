#include <iostream>
#include <iomanip>

using namespace std;

int main()
{
  double kilos;
  cout << fixed << showpoint << setprecision(2);
  cout << "Enter weight in kilograms: " << endl;
  cin >> kilos;
  cout << kilos << " kilograms = " << kilos*2.2 << " pounds" << endl;
  return 0;
}
