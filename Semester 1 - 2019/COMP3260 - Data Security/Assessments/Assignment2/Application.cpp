#include <cstdlib>
#include <iostream>
#include <fstream>
#include <string>
#include <windows.h>
#include <algorithm>

using namespace std;

string* const RIJN_S_BOX = new string[256] // Rijndael S-box
  { "63", "7C", "77", "7B", "F2", "6B", "6F", "C5", "30", "01", "67", "2B", "FE", "D7", "AB", "76",
    "CA", "82", "C9", "7D", "FA", "59", "47", "F0", "AD", "D4", "A2", "AF", "9C", "A4", "72", "C0",
    "B7", "FD", "93", "26", "36", "3F", "F7", "CC", "34", "A5", "E5", "F1", "71", "D8", "31", "15",
    "04", "C7", "23", "C3", "18", "96", "05", "9A", "07", "12", "80", "E2", "EB", "27", "B2", "75",
    "09", "83", "2C", "1A", "1B", "6E", "5A", "A0", "52", "3B", "D6", "B3", "29", "E3", "2F", "84",
    "53", "D1", "00", "ED", "20", "FC", "B1", "5B", "6A", "CB", "BE", "39", "4A", "4C", "58", "CF",
    "D0", "EF", "AA", "FB", "43", "4D", "33", "85", "45", "F9", "02", "7F", "50", "3C", "9F", "A8",
    "51", "A3", "40", "8F", "92", "9D", "38", "F5", "BC", "B6", "DA", "21", "10", "FF", "F3", "D2",
    "CD", "0C", "13", "EC", "5F", "97", "44", "17", "C4", "A7", "7E", "3D", "64", "5D", "19", "73",
    "60", "81", "4F", "DC", "22", "2A", "90", "88", "46", "EE", "B8", "14", "DE", "5E", "0B", "DB",
    "E0", "32", "3A", "0A", "49", "06", "24", "5C", "C2", "D3", "AC", "62", "91", "95", "E4", "79",
    "E7", "C8", "37", "6D", "8D", "D5", "4E", "A9", "6C", "56", "F4", "EA", "65", "7A", "AE", "08",
    "BA", "78", "25", "2E", "1C", "A6", "B4", "C6", "E8", "DD", "74", "1F", "4B", "BD", "8B", "8A",
    "70", "3E", "B5", "66", "48", "03", "F6", "0E", "61", "35", "57", "B9", "86", "C1", "1D", "9E",
    "E1", "F8", "98", "11", "69", "D9", "8E", "94", "9B", "1E", "87", "E9", "CE", "55", "28", "DF",
    "8C", "A1", "89", "0D", "BF", "E6", "42", "68", "41", "99", "2D", "0F", "B0", "54", "BB", "16" };

string* const INV_S_BOX = new string[256] // inverse Rijndael S-Box
  { "52", "09", "6A", "D5", "30", "36", "A5", "38", "BF", "40", "A3", "9E", "81", "F3", "D7", "FB",
    "7C", "E3", "39", "82", "9B", "2F", "FF", "87", "34", "8E", "43", "44", "C4", "DE", "E9", "CB",
    "54", "7B", "94", "32", "A6", "C2", "23", "3D", "EE", "4C", "95", "0B", "42", "FA", "C3", "4E",
    "08", "2E", "A1", "66", "28", "D9", "24", "B2", "76", "5B", "A2", "49", "6D", "8B", "D1", "25",
    "72", "F8", "F6", "64", "86", "68", "98", "16", "D4", "A4", "5C", "CC", "5D", "65", "B6", "92",
    "6C", "70", "48", "50", "FD", "ED", "B9", "DA", "5E", "15", "46", "57", "A7", "8D", "9D", "84",
    "90", "D8", "AB", "00", "8C", "BC", "D3", "0A", "F7", "E4", "58", "05", "B8", "B3", "45", "06",
    "D0", "2C", "1E", "8F", "CA", "3F", "0F", "02", "C1", "AF", "BD", "03", "01", "13", "8A", "6B",
    "3A", "91", "11", "41", "4F", "67", "DC", "EA", "97", "F2", "CF", "CE", "F0", "B4", "E6", "73",
    "96", "AC", "74", "22", "E7", "AD", "35", "85", "E2", "F9", "37", "E8", "1C", "75", "DF", "6E",
    "47", "F1", "1A", "71", "1D", "29", "C5", "89", "6F", "B7", "62", "0E", "AA", "18", "BE", "1B",
    "FC", "56", "3E", "4B", "C6", "D2", "79", "20", "9A", "DB", "C0", "FE", "78", "CD", "5A", "F4",
    "1F", "DD", "A8", "33", "88", "07", "C7", "31", "B1", "12", "10", "59", "27", "80", "EC", "5F",
    "60", "51", "7F", "A9", "19", "B5", "4A", "0D", "2D", "E5", "7A", "9F", "93", "C9", "9C", "EF",
    "A0", "E0", "3B", "4D", "AE", "2A", "F5", "B0", "C8", "EB", "BB", "3C", "83", "53", "99", "61",
    "17", "2B", "04", "7E", "BA", "77", "D6", "26", "E1", "69", "14", "63", "55", "21", "0C", "7D" };

string* const FIXED_MATRIX = new string[16]
  { "02", "03", "01", "01",
    "01", "02", "03", "01",
    "01", "01", "02", "03",
    "03", "01", "01", "02" };

/*
  Converts one or more blocks of 4 binary digits to one or more hexadecimal characters.
  Input: Small block of binary digits.
  Output: One hexadecimal character.
*/
string BinaryToHex(string input)
{
  string strToHex = "";
  for(int i=0; i<input.length()/4; i++)
  {
    if (input.substr(i*4,4) == "0000")
      strToHex = strToHex + '0';
    else if (input.substr(i*4,4) == "0001")
      strToHex = strToHex + '1';
    else if (input.substr(i*4,4) == "0010")
      strToHex = strToHex + '2';
    else if (input.substr(i*4,4) == "0011")
      strToHex = strToHex + '3';
    else if (input.substr(i*4,4) == "0100")
      strToHex = strToHex + '4';
    else if (input.substr(i*4,4) == "0101")
      strToHex = strToHex + '5';
    else if (input.substr(i*4,4) == "0110")
      strToHex = strToHex + '6';
    else if (input.substr(i*4,4) == "0111")
      strToHex = strToHex + '7';
    else if (input.substr(i*4,4) == "1000")
      strToHex = strToHex + '8';
    else if (input.substr(i*4,4) == "1001")
      strToHex = strToHex + '9';
    else if (input.substr(i*4,4) == "1010")
      strToHex = strToHex + 'A';
    else if (input.substr(i*4,4) == "1011")
      strToHex = strToHex + 'B';
    else if (input.substr(i*4,4) == "1100")
      strToHex = strToHex + 'C';
    else if (input.substr(i*4,4) == "1101")
      strToHex = strToHex + 'D';
    else if (input.substr(i*4,4) == "1110")
      strToHex = strToHex + 'E';
    else if (input.substr(i*4,4) == "1111")
      strToHex = strToHex + 'F';
    else
      cout << "Error: Binary-to-hex invalid." << endl;
  }
  return strToHex;
}

/*
  Converts one or more hexadecimal character to one or more blocks of 4 binary digits.
  Input: hexadecimal characters.
  Output: Binary digits.
*/
string* HexToBinary(string* input)
{
  string hexToBin = "";
  for (int i=0; i<input->length(); i++)
  {
    if (input->substr(i,1) == "0")
      hexToBin = hexToBin + "0000";
    else if (input->substr(i,1) == "1")
      hexToBin = hexToBin + "0001";
    else if (input->substr(i,1) == "2")
      hexToBin = hexToBin + "0010";
    else if (input->substr(i,1) == "3")
      hexToBin = hexToBin + "0011";
    else if (input->substr(i,1) == "4")
      hexToBin = hexToBin + "0100";
    else if (input->substr(i,1) == "5")
      hexToBin = hexToBin + "0101";
    else if (input->substr(i,1) == "6")
      hexToBin = hexToBin + "0110";
    else if (input->substr(i,1) == "7")
      hexToBin = hexToBin + "0111";
    else if (input->substr(i,1) == "8")
      hexToBin = hexToBin + "1000";
    else if (input->substr(i,1) == "9")
      hexToBin = hexToBin + "1001";
    else if (input->substr(i,1) == "A")
      hexToBin = hexToBin + "1010";
    else if (input->substr(i,1) == "B")
      hexToBin = hexToBin + "1011";
    else if (input->substr(i,1) == "C")
      hexToBin = hexToBin + "1100";
    else if (input->substr(i,1) == "D")
      hexToBin = hexToBin + "1101";
    else if (input->substr(i,1) == "E")
      hexToBin = hexToBin + "1110";
    else if (input->substr(i,1) == "F")
      hexToBin = hexToBin + "1111";
    else
      cout << "Error: Hex-to-binary invalid." << endl;
  }
  return &hexToBin;
}

/*
  Used to convert hexadecimal to a decimal integer to find a position in the Rijndael/inverse S-box matrix
  Input: Single hexadecimal character
  Output: Integer to represent a row/column
*/
int HexToMatrixPos(string input)
{
  int hexToMat;
  if (input == "0")
    hexToMat = 0;
  else if (input == "1")
    hexToMat = 1;
  else if (input == "2")
    hexToMat = 2;
  else if (input == "3")
    hexToMat = 3;
  else if (input == "4")
    hexToMat = 4;
  else if (input == "5")
    hexToMat = 5;
  else if (input == "6")
    hexToMat = 6;
  else if (input == "7")
    hexToMat = 7;
  else if (input == "8")
    hexToMat = 8;
  else if (input == "9")
    hexToMat = 9;
  else if (input == "A")
    hexToMat = 10;
  else if (input == "B")
    hexToMat = 11;
  else if (input == "C")
    hexToMat = 12;
  else if (input == "D")
    hexToMat = 13;
  else if (input == "E")
    hexToMat = 14;
  else if (input == "F")
    hexToMat = 15;
  else
    cout << "Error: Hex-to-matrix invalid." << endl;
  return hexToMat;
}

/*
  Converts a block of 4 binary digits to a hexadecimal character.
  Input: Small block of binary digits.
  Output: One hexadecimal character.
*/
int BinaryToMatrixPos(string input)
{
  int binToMat;
  if (input == "0000")
    binToMat = 0;
  else if (input == "0001")
    binToMat = 1;
  else if (input == "0010")
    binToMat = 2;
  else if (input == "0011")
    binToMat = 3;
  else if (input == "0100")
    binToMat = 4;
  else if (input == "0101")
    binToMat = 5;
  else if (input == "0110")
    binToMat = 6;
  else if (input == "0111")
    binToMat = 7;
  else if (input == "1000")
    binToMat = 8;
  else if (input == "1001")
    binToMat = 9;
  else if (input == "1010")
    binToMat = 10;
  else if (input == "1011")
    binToMat = 11;
  else if (input == "1100")
    binToMat = 12;
  else if (input == "1101")
    binToMat = 13;
  else if (input == "1110")
    binToMat = 14;
  else if (input == "1111")
    binToMat = 15;
  else
    cout << "Error: Binary-to-hex invalid." << endl;
  cout << binToMat << endl;
  return binToMat;
}

string* XORString(string* input1, string* input2)
{
  for(int j=0; j<input1->length(); j++)
  {
    if (input1[j] == input2[j])
      input1->replace(j, 1, "0");
    else
      input1->replace(j, 1, "1");
  }
  return input1;
}

string* MultiplyMatrix(string* input1, string* input2)
{
  string* multiplied;
  const char* fromChar = "00011011";
  string toPointer(fromChar);
  string* pointer;
  *pointer = toPointer;

  if (*input2 == "00000001")
    multiplied = input1;
  else if (*input2 == "00000010")
  {
    if (input1->substr(0,1) == "0")
    {
      *multiplied = input1->substr(1,7);
      multiplied->append("0");
    }
    else
    {
      *multiplied = input1->substr(1,7);
      multiplied->append("0");
      multiplied = XORString(multiplied, pointer);
    }
  }
  else if (*input2 == "00000011")
  {
    if (input1->substr(0,1) == "0")
    {
      *multiplied = input1->substr(1,7);
      multiplied->append("0");
      multiplied = XORString(multiplied, input1);
    }
    else
    {
      *multiplied = input1->substr(1,7);
      multiplied->append("0");
      multiplied = XORString(multiplied, input1);
      multiplied = XORString(multiplied, pointer);
    }
  }
  else
    cout << "Error: Something went wrong with the MixColumns." << endl;
  return multiplied;
}

/*
  Find the position of a hexadecimal number in the Rijndael S-box.
  Input: String representing 4-bytes of text
  Output: String representing substituted bytes
*/
string* SubstituteBytes(string* stringInput)
{
  string byteSub, fullPos = "";

  int i = 0;
  do
  {
    string matrixPos;
    for (int j=0; j<8; j++)
    {
      matrixPos.append(1, stringInput->at(i));
      i++;
    }
    fullPos = fullPos + RIJN_S_BOX[16*BinaryToMatrixPos(matrixPos.substr(0,4)) + (BinaryToMatrixPos(matrixPos.substr(4,4)))];
    cout << fullPos << endl;
  }
  while(i<stringInput->length());

  byteSub = fullPos;

  return HexToBinary(&byteSub);
}

string* ShiftRows(string* text)
{
  string shiftedRows = "";
  cout << "shiftrowstart" << endl;

  for(int i=0; i<4; i++)
  {
    shiftedRows = shiftedRows + text->substr(i*8, 8);
    shiftedRows = shiftedRows + text->substr((i+5)*8, 8);
    shiftedRows = shiftedRows + text->substr((i+10)*8, 8);
    if (i == 0)
      shiftedRows = shiftedRows + text->substr((i+15)*8, 8);
  }
  cout << "shiftrowsend" << endl;
  return &shiftedRows;
}

string* MixColumns(string* text)
{
  cout << "columnstart" << endl;
  string *mult1, *mult2, *mult3, *mult4;
  string *mixedColumns;

  for (int i=0; i<4; i++)
  {
    for (int j=0; j<4; j++)
    {
      *mult1 = text->substr(i*32, 8);
      mult1 = MultiplyMatrix(mult1, HexToBinary(&FIXED_MATRIX[j*4 + 0]));
      *mult2 = text->substr(i*32+8, 8);
      mult2 = MultiplyMatrix(mult2, HexToBinary(&FIXED_MATRIX[j*4 + 1]));
      *mult3 = text->substr(i*32+16, 8);
      mult3 = MultiplyMatrix(mult3, HexToBinary(&FIXED_MATRIX[j*4 + 2]));
      *mult4 = text->substr(i*32+24, 8);
      mult4 = MultiplyMatrix(mult4, HexToBinary(&FIXED_MATRIX[j*4 + 3]));

      mult1 = XORString(mult1, mult2);
      mult1 = XORString(mult1, mult3);
      mult1 = XORString(mult1, mult4);
      mixedColumns->append(*mult1);
    }
  }
  cout << "columnend" << endl;
  return mixedColumns;
}

string* AddRoundKey(string* binKey, int roundNumber)
{
  string roundKey, *byteSub, roundConstant, *leftShift, tempSub;

  leftShift = binKey;
  *leftShift = leftShift->substr(104,24) + leftShift->substr(96,8);
  byteSub = SubstituteBytes(leftShift);
  cout << "roundkeystart" << endl;

  if (roundNumber == 1)
    roundConstant = "00000001";
  else if (roundNumber == 2)
    roundConstant = "00000010";
  else if (roundNumber == 3)
    roundConstant = "00000100";
  else if (roundNumber == 4)
    roundConstant = "00001000";
  else if (roundNumber == 5)
    roundConstant = "00010000";
  else if (roundNumber == 6)
    roundConstant = "00100000";
  else if (roundNumber == 7)
    roundConstant = "01000000";
  else if (roundNumber == 8)
    roundConstant = "10000000";
  else if (roundNumber == 9)
    roundConstant = "00011011";
  else if (roundNumber == 10)
    roundConstant = "00110110";
  else
    cout << "Error: Incorrect number of rounds." << endl;

  cout << *leftShift << endl;

  string* tempByteSub;
  tempByteSub = XORString(&tempSub, &roundConstant);
  *leftShift = tempSub + leftShift->substr(8,leftShift->length()-8);
  cout << "Error: Incorrect number of rounds." << endl;

  for (int i=0; i<byteSub->length(); i++)
  {
    if (byteSub[i] == binKey[i])
    {
      *tempByteSub = *tempByteSub + "0";
    }
    else
      *tempByteSub = *tempByteSub + "1";
  }
  roundKey = *tempByteSub;
  cout << "Error: Incorrect number of rounds." << endl;

  for(int i=1; i<4; i++) // complete the round key
  {
    byteSub->append(binKey->substr(32*i,32));
    cout << "Error: Incorrect number of rounds." << endl;
    tempByteSub = XORString(tempByteSub, byteSub);
    cout << "Error: Incorrect number of rounds." << endl;
    roundKey = roundKey + *tempByteSub;
  }
  cout << "roundkeyend" << endl;
  return &roundKey;
}

/*
  Encrypts a 128-bit plaintext block using a 128-bit key.
  Input: string plainText = 128-bit plaintext block; string key = 128-bit encoding key
  Output: Text file containing the details of the operation.
*/
void Encryption(string* plainText, string* key)
{
  string *roundKey, *newText;

  cout << "Plaintext P: " << endl;
  cout << BinaryToHex(*plainText) << endl << endl;

  cout << "Key K: " << endl;
  cout << BinaryToHex(*key) << endl << endl;

  roundKey = AddRoundKey(key, 1);

  for(int i=2; i<9; i++)
  {
    cout << "Round " << i-1 << " start:" << endl;
    newText = SubstituteBytes(roundKey);
    newText = ShiftRows(newText);
    newText = MixColumns(newText);
    roundKey = AddRoundKey(roundKey, i);
    newText = roundKey;
    cout << "Round " << i-1 << "finished: " << newText;
  }
    newText = SubstituteBytes(newText);
    ShiftRows(roundKey);
    roundKey = AddRoundKey(roundKey, 10);
    newText = roundKey;
    cout << "Round " << 10 << "finished - Final result: " << newText;
}

/*
  Decrypts a 128-bit ciphertext block using a 128-bit key.
  Input: string cipherText = 128-bit ciphertext block; string key = 128-bit encoding key
  Output: Text file containing the details of the operation.
*/
void Decryption(string* cipherText, string* key)
{
  string text, codeKey; //32-char strings

  cout << "Ciphertext C: ";
  cout << BinaryToHex(*cipherText) << endl << endl;

  cout << "Key K: ";
  cout << BinaryToHex(*key) << endl << endl;

  cout << "Plaintext P: ";
}

int main()
{
  bool fileExists = false;
  int encOrDec;
  string text, charKey;
  string *cipherText, *plainText, *key;
  string inputFile, toText, toKey;
  ifstream enterStream;

  do
  {
    enterStream.open("test.txt");
    if (!enterStream.good()) // check if file exists
      cerr << "Invalid file.  Try again." << endl;
    else
      fileExists = true;
  }
  while (!fileExists);

  cout << "Enter '0' (encryption) or '1' (decryption): " << endl;
  cin >> encOrDec;

  if (encOrDec == 0)
  {
    getline(enterStream, text);
    getline(enterStream, charKey);

    plainText = &text;
    key = &charKey;
    Encryption(plainText, key);
  }
  /*else if (encOrDec == 1)
  {
    enterStream.getline(text, 256);
    *cipherText = text;
    enterStream.getline(charKey, 256);
    *key = charKey;
    Decryption(cipherText, key);
  }*/
  else
    cout << "Invalid selection.  Cancelling..." << endl;

  enterStream.close();
  return 0;
}
