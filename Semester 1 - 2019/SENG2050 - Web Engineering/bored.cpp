#include <iostream>
#include <string>

using namespace std;

int main()
{
  const int SIDE = 30;
  cout << "Diamond." << endl;

  for (int i=0; i<SIDE; i++)
  {
    for(int j=0; j<SIDE; j++)
    {
      if(i <= SIDE/2 && j == SIDE/2-i || i > SIDE/2 && j == SIDE-i+SIDE/2)
      {
        cout << "/";
      }

      else if(i <= SIDE/2 && j == SIDE/2+i || i > SIDE/2 && j == i-SIDE/2)
      {
        cout << "\\";
      }

      else
      {
        cout << " ";
      }
    }
    cout << endl;
  }
  return 0;
}
