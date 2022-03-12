#include <iostream>
#include <iomanip>

using namespace std;

int prime(int input1)
{
  for (int j=2; j<input1; j++)
    if (input1 % j == 0)
      return 0;
  cout << input1 << endl;
  return input1;
}

int eratos(int input1)
{
  if (input1 == 2 || input1 == 3 || input1 == 5 || input1 == 7)
  {
    cout << input1 << endl;
    return input1;
  }
  else if (input1 == 1 || input1 % 2 == 0 || input1 % 3 == 0 || input1 % 5 == 0 || input1 % 7 == 0)
    return 0;
  else
  {
    cout << input1 << endl;
    return input1;
  }
}

int main()
{
  int input1, input2, sum = 0;
  string sieve;

  cout << "Enter two integers between 0 and 1,000,000,000: " << endl;
  cin >> input1 >> input2;
  cout << "a - Basic inefficient prime generator\nb - Eratosthenes sieve" << endl;
  cin >> sieve;

  if (sieve == "a")
    for (int i=input1; i<input2; i++)
      sum = sum + prime(i);

  else if (sieve == "b")
    for (int i=input1; i<input2; i++)
      sum = sum + eratos(i);

  cout << "The sum of all the prime numbers: " << sum << endl;

  return 0;
}
