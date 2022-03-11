// This implements a program that inputs two numbers and adds them.
// Programmer: Alex Mendes
// Last modified:  01 Aug 2016
// This file should be used in conjunction with Lab 1 for SENG1120

#include <iostream>
using namespace std;

int main()
{
   int first, second, sum;
   cout << "Enter first integer: ";
   cin >> first;
   cout << "Enter second integer: ";
   cin >> second;
   sum = first + second;
   cout << "Sum is " << sum << endl;
   return 0;
}
