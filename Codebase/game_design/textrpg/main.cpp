#include <cstdlib>
#include <iostream>
#include <string>
#include <random>
#include <windows.h>
#include "NPC.h"

using namespace std;

int main()
{
  string name;
  string sex;
  int age;

  MessageBox(NULL, "Goodbye, cruel world!", "Note", MB_OK);
  cout << "To Pearlwood" << endl << endl;
  cout << "You are a young servant to the Juliens, a ruling house, and everything has gone\ntits up, son." << endl;
  cout << "Lord Bryan and Lady Edna have been slain, collateral damage in a civil war, along with\nmost of their family." << endl;
  cout << "The only survivors are the eldest daughter Helena,\nthe cook Harrison,\nthe late Edna's lady's maid Tuppence,\nthe chauffeur Innes\nand you, the house messenger." << endl;
  cout << "The question is: who are you?" << endl;
  cout << "Are you 'male' or 'female'?" << endl;
  cin >> sex;
  cout << "What is your name?" << endl;
  cin >> name;
  cout << "How old are you?" << endl;
  cin >> age;
  NPC* player = new NPC("Player", name, sex, "Messenger", age);
  player->describe();

  return 0;
}
