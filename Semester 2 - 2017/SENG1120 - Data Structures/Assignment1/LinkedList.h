// Assignment 1 - SENG1120
// Student No.: 	c3130069
// Name: 			Sam Dolbel
// Tutorial: 		10-12pm Monday
// Created: 		28 August 2017
// Last modified: 3 September 2017

#include <cstdlib>
#include "Node.h"

#ifndef LINKED_LIST
#define LINKED_LIST

using namespace std;

class LinkedList
{
   private:
      Node *prev; 	//pointer of tail node
	  Node *next; 	//pointer of head node
	  
   public:
      // Constructors
	  // Precondition: None
	  // Postcondition: New instance of the LinkedList class with a
	  // user-defined or empty value
	  LinkedList();
	  LinkedList(string);
	  
	  // Mutators
	  void add(string);
	  int count(value_type);
	  void remove(value_type);
	  
	  // Queriers
	  int length();
	  
};

#endif