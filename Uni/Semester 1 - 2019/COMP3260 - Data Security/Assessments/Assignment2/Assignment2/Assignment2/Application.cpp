#include <cstdlib>
#include <iostream>
#include <fstream>
#include <string>

using namespace std;

void encryption(char plainText[], char key[])
{
  char* text = plainText;
  char* codeKey = key;
}

void decryption(char cipherText[], char key[])
{
  char* text = cipherText;
  char* codeKey = key;
}

int main()
{
  int encOrDec;
  char directory[FILENAME_MAX], plainText[128], cipherText[128], key[128];
  string inputFile;

  string charStr(directory);
  cout << "Enter the name of the input file: " << endl;
  cin >> inputFile;
  cout << "Enter 0 (encryption) or 1 (decryption): " << endl;
  cin >> encOrDec;
  ifstream enterStream;
  enterStream.open(charStr + inputFile);
  enterStream.get(key, 128);

  switch (encOrDec)
  {
    case '0' :
      enterStream.get(plainText, 128);
      encryption(plainText, key);
      break;
    case '1' :
      enterStream.get(cipherText, 128);
      decryption(cipherText, key);
      break;
    default :
      cout << "Invalid selection.  Cancelling..." << endl;
  }

  enterStream.close();
  return 0;
}
