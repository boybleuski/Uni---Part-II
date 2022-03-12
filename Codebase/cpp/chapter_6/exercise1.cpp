#include <iostream>
#include <iomanip>

using namespace std;

bool isPalindrome(string input)
{
  int stringSize = input.size();

  for (int i=0; i<stringSize/2; i++)
    if(input[i] != input[(stringSize-1)-i])
      return false;
  return true;
}

int main()
{
  string input;

  cout << "Enter a word: " << endl;
  cin >> input;

  if (isPalindrome(input) == true)
    cout << input << " is a palindrome." << endl;
  else
    cout << input << " is not a palindrome." << endl;

  return 0;
}
