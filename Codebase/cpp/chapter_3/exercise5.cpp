#include <iostream>
#include <iomanip>
#include <fstream>
#include <string>

using namespace std;

int main()
{
  ifstream inFile;
  ofstream outFile;
  string fName, lName;
  double salary, increase;

  inFile.open("Ch3_Ex5Data.txt");
  outFile.open("Ch3_Ex5Output.dat");

  for (int i=0; i<2; i++)
  {
    outFile << fixed << showpoint << setprecision(2);
    inFile >> lName >> fName >> salary >> increase;
    salary = salary + salary*increase/100;
    outFile << fName << " " << lName << ": $" << salary << endl;
  }

  inFile.close();
  outFile.close();

  return 0;
}
