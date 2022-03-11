// Assignment 1 - SENG1120
// Student No.: 	c3130069
// Name: 			Sam Dolbel
// Tutorial: 		10-12pm Monday
// Created: 		28 August 2017
// Last modified: 3 September 2017

#include <iostream>
#include <cstdlib>
#include "LinkedList.h"

using namespace std;

int main()
{
   string firstLine;
   LinkedList inputOne;
   
   cout << "Enter a sentence." << endl;
   getline(cin, firstLine);
   LinkedList *inputOne = new LinkedList(100);
   
   cout << firstLine << endl;
   return 0;
}