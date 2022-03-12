#include <cstdlib>
#include <iostream>

using namespace std;

int main()
{
  int a = 1;
  cout << "a: " << a << endl;
  int* b = &a;
  cout << "b: " << b << endl;
  cout << "&b: " << &b << endl;
  cout << "*b: " << *b << endl;
  int& c = a;
  cout << "c: " << c << endl;
  cout << "&c: " << &c << endl;
  int* d = b;
  cout << "d: " << d << endl;
  cout << "*d: " << *d << endl;
  int* e = b;
  cout << "e: " << e << endl;
  cout << "*e :"  << *e << endl;
  c = a;
  cout << "c: " << c << endl;
  cout << "&c: " << &c << endl;

/*
  a: 1
  b: 0xffffcc14
  &b: 0xffffcc08
  *b: 1
  c: 1
  &c: 0xffffcc14
*/
  return 0;
}
