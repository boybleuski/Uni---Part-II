#include <iostream>
#include <cstdlib>

using namespace std;

int main()
{
  int input;
  cout << "Enter an integer: " << endl;
  cin >> input;

  if (input > 0)
    cout << "The number is positive.";

  else if (input < 0)
    cout << "The number is negative.";

  else
    cout << "The number is zero.";

  return 0;
}
