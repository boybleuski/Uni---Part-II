#include <iostream>
#include <cstdlib>

using namespace std;

int main()
{
  int num1, num2, num3, num4;
  cout << "Enter three integers: " << endl;
  cin >> num1 >> num2 >> num3;

  if (num1 > num2)
  {
    num4 = num1;
    num1 = num2;
    num2 = num4;
  }

  if (num2 > num3)
  {
    num4 = num2;
    num2 = num3;
    num3 = num4;
  }

  cout << num1 << ", " << num2 << ", " << num3;
  return 0;
}
