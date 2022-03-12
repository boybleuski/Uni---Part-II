#include <iostream>
#include <iomanip>
#include <string>
#include <fstream>

using namespace std;


double calcBonus(double gross, double bonus)
{
  return (gross + gross*bonus/100);
};

int main()
{
  ifstream inFile;
  ofstream outFile;

  string fname, lname, dept;
  int cupsSold;
  double gross, bonus, tax, travDist, travTime, cupCost;

  inFile.open("inFile.txt");
  outFile.open("outFile.txt");

  for(int i=0; i<2; i++)
  {
    outFile << fixed << showpoint << setprecision(2);
    inFile >> fname >> lname >> dept >> gross >> bonus >> tax >> travDist >> travTime >> cupsSold >> cupCost;
    outFile << "Name: " << fname << " " << lname << ", Department: " << dept << endl;
    outFile << "Monthly Gross Salary: $" << gross << ", Monthly Bonus: " << bonus << "%, Taxes: " << tax << "%\nPaycheck: $" << calcBonus(gross, bonus) - calcBonus(gross, bonus)*tax/100 << endl << endl;
    outFile << "Distance Traveled: " << travDist << " miles, Traveling Time: " << travTime << " hours" << endl;
    outFile << "Average Speed: " << travDist/travTime << " miles per hour" << endl << endl;
    outFile << "Number of Coffee Cups Sold: " << cupsSold << ", Cost: $" << cupCost << " per cup" << endl;
    outFile << "Sales Amount = $" << cupsSold*cupCost << endl << endl;
    if(i+1 != 2)
    {
      outFile << setfill('~') << setw(50) << "\n" << endl;
    }
  }

  inFile.close();
  outFile.close();

  return 0;
};
