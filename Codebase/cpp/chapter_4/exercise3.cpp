#include <iostream>
#include <cstdlib>

using namespace std;

int main()
{
  int num1;

  cout << "Input a number from 0 to 35: " << endl;
  cin >> num1;

  if (num1 >= 0 && num1 <= 9)
    cout << num1;

  else if (num1 > 9 && num1 <= 35)
  {
    num1 = num1 + 55;
    cout << static_cast<char>(num1);
  }

  else
    cout << "Nope." << endl;

  return 0;
}
